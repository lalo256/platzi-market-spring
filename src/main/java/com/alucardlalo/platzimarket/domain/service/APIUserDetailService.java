package com.alucardlalo.platzimarket.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/*apartado para establecer la contraseña y usuario para entrar a las peticiones de la API*/
//si no se declara el usuario y contraseña Spring genera una aleatoria al momento de compilar simpre con el usuario user
@Service
public class APIUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Eduardo","{noop}Alucardlalo",new ArrayList<>());
        //declaracion de usuario y contraseña para el Spring security
        //se agrego {noop} antes de la contraseña para que esta funcione
        //debe remplazarse esta manera de autentificar por una revision a base de datos
    }
}
