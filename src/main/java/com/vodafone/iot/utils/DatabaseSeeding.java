package com.vodafone.iot.utils;

import com.vodafone.iot.dao.DeviceDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeding {

    @Autowired
    DeviceDAO dao;

    @EventListener(classes = { ContextRefreshedEvent.class })
    public void seed() {
        dao.populateDeviceTable();
    }

   

}
