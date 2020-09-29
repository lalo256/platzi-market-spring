package com.alucardlalo.platzimarket.domain.dto;

public class AutenticationResponse {
    private String kwt;

    public AutenticationResponse(String kwt) {
        this.kwt = kwt;
    }

    public String getKwt() {
        return kwt;
    }

    public void setKwt(String kwt) {
        this.kwt = kwt;
    }

    /*creado para ayudar al controlador de seguridad*/
}
