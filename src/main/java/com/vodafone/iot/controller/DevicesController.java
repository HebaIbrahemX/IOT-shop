package com.vodafone.iot.controller;


import com.vodafone.iot.services.DevicesService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iot-shop/devices")
public class DevicesController {

    @Autowired
    DevicesService service;

    @GetMapping(path = "/waiting-for-activation",produces = "application/json")
    public ResponseEntity<Object> getWaitingDevices(){
        return service.getWaitingDevices();

    }

    @GetMapping(path = "/available-for-sale",produces = "application/json")
    public ResponseEntity<Object> getAvailableDevices(){
        return service.getAvailableDevices();

    }
    
}
