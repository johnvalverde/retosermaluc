package com.sermaluc.reto.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseApiPayload<T> {
    private String mensaje;
    private T body;
}
