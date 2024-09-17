package com.sermaluc.reto.auth.model;

import com.sermaluc.reto.user.dtos.ListUserPhoneOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String userId;
    private String name;
    private String username;
    private String created;
    private String modified;
    private String lastLogin;
    private String password;
    private Short isActive;
    private List<ListUserPhoneOutputDTO> phones;
}
