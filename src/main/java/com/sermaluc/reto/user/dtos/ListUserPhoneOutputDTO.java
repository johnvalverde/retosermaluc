package com.sermaluc.reto.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListUserPhoneOutputDTO {
    private String number;
    private String cityCode;
    private String countryCode;
}
