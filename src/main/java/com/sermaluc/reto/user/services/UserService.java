package com.sermaluc.reto.user.services;

import com.sermaluc.reto.user.dtos.CreateUserRequestDTO;
import com.sermaluc.reto.user.dtos.CreateUserResponseDTO;
import com.sermaluc.reto.user.dtos.ListUserOutputDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) throws IOException;
    List<ListUserOutputDTO> listUsers();
}
