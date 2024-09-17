package com.sermaluc.reto.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserResponseDTO {
    private String userId;
    private String name;
    private String email;
    private String created;
    private String modified;
    private String lastLogin;
    private Short isActive;
    private List<ListUserPhoneOutputDTO> phones;
    private String token;
}
