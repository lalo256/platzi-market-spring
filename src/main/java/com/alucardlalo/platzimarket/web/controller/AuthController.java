package com.alucardlalo.platzimarket.web.controller;

import com.alucardlalo.platzimarket.domain.dto.AutenticationResponse;
import com.alucardlalo.platzimarket.domain.dto.AuteticationRequest;
import com.alucardlalo.platzimarket.domain.service.APIUserDetailService;
import com.alucardlalo.platzimarket.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private APIUserDetailService apiUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AutenticationResponse> createToken(@RequestBody AuteticationRequest request){
        try{//se agregan en try para verificar su correcto funcionamiento
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            UserDetails userDetails = apiUserDetailService.loadUserByUsername(request.getUserName());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AutenticationResponse(jwt),HttpStatus.OK);//retorno al ser correcta la autentificacion
        }catch (BadCredentialsException e){ //marca de error cuando usuario y contraseña no coincidan
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);//retorno al no ser correcta la autentificacion
        }
    }
}
