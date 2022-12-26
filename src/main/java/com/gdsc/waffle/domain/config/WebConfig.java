package com.gdsc.waffle.domain.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://vercel.com/gdsc-dju-gds/waffle-shoulder-fairy-frontend","https://waffle-shoulder-fairy-frontend.vercel.app","https://localhost:3000")
                .allowedMethods("GET","POST","PATCH","DELETE");

    }
}
