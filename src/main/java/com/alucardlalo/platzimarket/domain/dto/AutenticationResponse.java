package com.alucardlalo.platzimarket.domain.dto;

public class AutenticationResponse {
    private String jwt;

    public AutenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getjwt() {
        return jwt;
    }

    public void setjwt(String jwt) {
        this.jwt = jwt;
    }

    /*creado para ayudar al controlador de seguridad*/
}
