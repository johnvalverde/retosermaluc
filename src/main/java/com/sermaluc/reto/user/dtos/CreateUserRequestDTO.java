package com.sermaluc.reto.user.dtos;

import lombok.Data;
import java.util.List;

@Data
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
    private List<CreateUserPhoneDTO> phones;
}
