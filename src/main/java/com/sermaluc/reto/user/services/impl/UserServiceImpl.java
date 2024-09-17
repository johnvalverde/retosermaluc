package com.sermaluc.reto.user.services.impl;

import com.sermaluc.reto.auth.model.User;
import com.sermaluc.reto.auth.model.UserDetailsCustom;
import com.sermaluc.reto.auth.services.JWTService;
import com.sermaluc.reto.user.dtos.*;
import com.sermaluc.reto.user.mappers.UserMapper;
import com.sermaluc.reto.user.services.UserService;
import com.sermaluc.reto.utils.exceptions.BusinessException;
import com.sermaluc.reto.utils.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UtilService utilService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Override
    @Transactional
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) throws IOException {

        if (!utilService.isValidEmail(createUserRequestDTO.getEmail())) {
            throw new BusinessException("Email no válido");
        }

        if (!utilService.isValidPassword(createUserRequestDTO.getPassword())) {
            throw new BusinessException("La contraseña debe tener almenos un número");
        }

        if (userMapper.existsUser(createUserRequestDTO.getEmail())) {
            throw new BusinessException("El correo ya se encuentra registrado");
        }

        String userId = UUID.randomUUID().toString();

        userMapper.createUser(new CreateUserInputDTO(
                userId,
                createUserRequestDTO.getName(),
                createUserRequestDTO.getEmail(),
                passwordEncoder.encode(createUserRequestDTO.getPassword()
                )));

        createUserRequestDTO.getPhones().forEach(createUserPhoneDTO ->
                userMapper.createPhone(new CreatePhoneInputDTO(
                        userId,
                        createUserPhoneDTO.getNumber(),
                        createUserPhoneDTO.getCityCode(),
                        createUserPhoneDTO.getCountryCode()
                ))
        );

        User user = userMapper.findUser(createUserRequestDTO.getEmail());

        UserDetailsCustom udc = new UserDetailsCustom(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(udc, null);
        String tokenJWT = jwtService.create(auth);

        return new CreateUserResponseDTO(user.getUserId(), user.getName(), user.getUsername(),
                user.getCreated(), user.getModified(), user.getLastLogin(), user.getIsActive(), user.getPhones(), tokenJWT);
    }

    @Override
    public List<ListUserOutputDTO> listUsers() {
        return userMapper.listUsers();
    }

}
