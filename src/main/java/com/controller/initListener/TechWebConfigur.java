package com.controller.initListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TechWebConfigur extends WebMvcConfigurerAdapter {

    @Bean
    public AuthorInterceptor getSecurityInterceptor() {
        return new AuthorInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSecurityInterceptor());
    }
}
