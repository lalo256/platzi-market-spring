package com.alucardlalo.platzimarket.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alucardlalo.platzimarket.web.controller"))//selecciona el packete que se quiere mostrar en swagger
                .build();
        //para entra y checar la documentacion se usa el direccionamiento
        //localhost:8090/platzi-market/api/swagger-ui.html
    }
}
