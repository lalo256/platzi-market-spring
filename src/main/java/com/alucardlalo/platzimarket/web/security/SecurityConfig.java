package com.alucardlalo.platzimarket.web.security;

import com.alucardlalo.platzimarket.domain.service.APIUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*interfaz encargada de la seguridad de la API*/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   //inyeccion de servicio
    @Autowired
    private APIUserDetailService apiUserDetailService;

    //metodo para definir el uso de usuario y contraseña declarados en service.APIUserDetailService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(apiUserDetailService);
    }
}
