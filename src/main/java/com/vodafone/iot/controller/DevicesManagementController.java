package com.vodafone.iot.controller;

import com.vodafone.iot.dto.DeviceDTO;
import com.vodafone.iot.services.DevicesService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iot-shop/admin")
public class DevicesManagementController {

    @Autowired
    DevicesService service;
    

    @PutMapping(produces = "application/json")
    public ResponseEntity<Object>updateDevice(@RequestBody DeviceDTO object){

        return service.updateDevice(object);
        //return new ResponseEntity<>("hey", HttpStatus.OK);
    }

    @DeleteMapping(path="/{simId}",produces = "application/json")
    public ResponseEntity<Object>removeDevice(@PathVariable String simId){

        return service.deleteDevice(simId);
    }


    
}
