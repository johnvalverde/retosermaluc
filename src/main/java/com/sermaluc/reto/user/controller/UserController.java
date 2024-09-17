package com.sermaluc.reto.user.controller;


import com.sermaluc.reto.user.dtos.CreateUserRequestDTO;
import com.sermaluc.reto.user.dtos.CreateUserResponseDTO;
import com.sermaluc.reto.user.dtos.ListUserOutputDTO;
import com.sermaluc.reto.user.services.UserService;
import com.sermaluc.reto.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sermaluc.reto.user.config.PathsUser.*;
import static com.sermaluc.reto.utils.config.PathsUtil.ROOT_API;
import static com.sermaluc.reto.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + MODULE + VERSION)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(CREATE_USER)
    public ResponseApi<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) throws IOException {
        return ResponseApi.build(userService.createUser(createUserRequestDTO));
    }

    @GetMapping(LIST_USERS)
    public ResponseApi<List<ListUserOutputDTO>> listUsers() {
        return ResponseApi.build(userService.listUsers());
    }

}
