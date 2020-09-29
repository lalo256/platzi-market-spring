package com.alucardlalo.platzimarket.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JWTUtil {

    //se nesecita una constante para firmar el token y se declara sig con nombre key
    public static final String key = "Alucardlalo";

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())//optencion de contraseña con userDetail y la hora local
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))//vencimiento de contraseña apartir del tiempo local + 10 hr
                .signWith(SignatureAlgorithm.HS256,key).compact();//firma de algoritmo con formato HS256 y la key declarada
    }
}
