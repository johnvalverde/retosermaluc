package com.sermaluc.reto.utils.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseApi<T> {

    private int status;
    private String message;
    private T body;

    public ResponseApi() {
        this.status = 200;
        this.message = "Success";
        this.body = null;
    }

    public ResponseApi<?> responseError(String message) {
        this.status = 400;
        this.message = message;
        return this;
    }

    public static <G> ResponseApi<G> build(G g) {
        ResponseApi<G> responseApi = new ResponseApi<G>();
        responseApi.setBody(g);
        return responseApi;
    }
}
