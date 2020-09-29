package com.alucardlalo.platzimarket.domain.dto;
//controlador para los usuarios y contraseña
public class AuteticationRequest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*creado para ayudar al controlador de seguridad*/
}
