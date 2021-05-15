package com.vodafone.iot.controller;

import com.vodafone.iot.dto.DeviceDTO;
import com.vodafone.iot.services.DevicesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping(path = "/iot-shop/admin")
public class DevicesManagementController {

    @Autowired
    DevicesService service;
    

    @PutMapping(produces = "application/json")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body" ,name="object",example="{\"status\":1,\"simId\":\"5#23\"}",dataTypeClass=String.class )})
    public ResponseEntity<Object>updateDevice(@RequestBody DeviceDTO object){

        return service.updateDevice(object);
        //return new ResponseEntity<>("hey", HttpStatus.OK);
    }

    @DeleteMapping(path="/{simId}",produces = "application/json")
    public ResponseEntity<Object>removeDevice(@PathVariable String simId){

        return service.deleteDevice(simId);
    }


    
}
