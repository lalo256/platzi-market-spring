package com.alucardlalo.platzimarket.web.security;

import com.alucardlalo.platzimarket.domain.service.APIUserDetailService;
import com.alucardlalo.platzimarket.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.Basic;
/*interfaz encargada de la seguridad de la API*/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   //inyeccion de servicio
    @Autowired
    private APIUserDetailService apiUserDetailService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    //metodo para definir el uso de usuario y contraseña declarados en service.APIUserDetailService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(apiUserDetailService);
    }

    //anexo de seguridad  para el uso del token
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()//todas las peticiones que tengan authentica son permitidas
        .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//se agrego para asignar peticiones al filtro
        //cualquier otra peticion necesita autentificacion
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    //elecion para gestor de autentificacion
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
