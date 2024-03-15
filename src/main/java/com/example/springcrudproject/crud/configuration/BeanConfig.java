package com.example.springcrudproject.crud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class BeanConfig {
    @Bean // 삽입 성공시 메시지가 알러트 창으로 뜨게 해주는 설정
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath : messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        Locale.setDefault(Locale.KOREA);
        return messageSource ;
    }
}
