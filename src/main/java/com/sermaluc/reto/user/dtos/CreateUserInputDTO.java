package com.sermaluc.reto.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserInputDTO {
    private String userId;
    private String name;
    private String email;
    private String password;
}
