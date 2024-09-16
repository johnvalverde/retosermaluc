package com.sermaluc.reto.utils.model;

public class ResponseApiDetalle {
    private String mensaje;

    public ResponseApiDetalle(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
