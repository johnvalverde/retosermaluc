package com.sermaluc.reto.auth.services.impl;

//import com.sermaluc.reto.auth.mappers.AuthMapper;

import com.sermaluc.reto.auth.model.*;
import com.sermaluc.reto.user.mappers.UserMapper;
import com.sermaluc.reto.utils.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("MyBatisUserDetailService")
public class MyBatisUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    public MyBatisUserDetailService() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userMapper.findUser(username);
        if (user == null) {
            throw new BusinessException("Usuario no encontrado");
        }

        return new UserDetailsCustom(user);
    }


}

