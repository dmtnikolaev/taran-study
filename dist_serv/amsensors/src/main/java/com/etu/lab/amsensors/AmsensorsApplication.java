package com.etu.lab.amsensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootApplication
public class AmsensorsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmsensorsApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
       SessionLocaleResolver localeResolver = new SessionLocaleResolver();
       Locale ru = new Locale("en", "US");
       localeResolver.setDefaultLocale(ru);
       return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
       ResourceBundleMessageSource messageSource =
           new ResourceBundleMessageSource();
       messageSource.setUseCodeAsDefaultMessage(true);
       messageSource.setBasenames("messages");
       messageSource.setDefaultEncoding("UTF-8");
       return messageSource;
    }
}
