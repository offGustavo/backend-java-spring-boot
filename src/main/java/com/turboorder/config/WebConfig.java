package com.turboorder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Permitir requisições de localhost:3000 (ou qualquer origem do seu frontend)
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000") // Altere o endereço para o seu frontend
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
        .allowedHeaders("*") // Permite todos os cabeçalhos
        .allowCredentials(true); // Permite credenciais, como cookies
  }
}
