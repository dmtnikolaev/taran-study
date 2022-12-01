package com.etu.lab.amsensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.MapInfoContributor;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

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

    @Bean
    InfoContributor getInfoContributor() {
        Map<String, Object> details = new HashMap<>();
        details.put("nameApp", "Amsensors");
        details.put("developer", "Dmitri Nicolaev, Stepan Repin");
        details.put("email", "stnrepin@gmail.com");
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("info", details);
        return new MapInfoContributor(wrapper);
    }
}
