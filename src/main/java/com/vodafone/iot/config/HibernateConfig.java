package com.vodafone.iot.config;

import com.vodafone.iot.model.Device;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@org.springframework.context.annotation.Configuration 
public class HibernateConfig {

    private SessionFactory factorysession;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.pass}")
    private String dbPass;
   
    @Bean
    public SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.setProperty("hibernate.connection.username",dbUser );
        cfg.setProperty("hibernate.connection.password",dbPass );
        cfg.addAnnotatedClass(Device.class);
        
        try {
            factorysession = cfg.buildSessionFactory();
        } catch (BeansException ex) {
        }
        return factorysession;
    }
    
}
