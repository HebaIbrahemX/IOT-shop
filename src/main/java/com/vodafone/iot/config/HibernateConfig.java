package com.vodafone.iot.config;

import com.vodafone.iot.model.Device;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration 
public class HibernateConfig {

    private SessionFactory factorysession;
   
    @Bean
    public SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Device.class);
        
        try {
            factorysession = cfg.buildSessionFactory();
        } catch (BeansException ex) {
        }
        return factorysession;
    }
    
}
