package com.vodafone.iot.services;

import java.util.List;

import com.vodafone.iot.dao.DeviceDAO;
import com.vodafone.iot.dto.DeviceDTO;
import com.vodafone.iot.model.Device;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DevicesService {
    @Autowired
    DeviceDAO dao;

    @Autowired
    GeneralValidation validation;

    public  ResponseEntity<Object> updateDevice(DeviceDTO obj){

        validation.validateData(obj);
        Device updatedDevice =dao.updateDeviceStatus(obj.getSimId(), obj.getStatus());
        JSONObject body =new JSONObject();
        if(updatedDevice==null){
            body.put("message", "Couldn't find device with SIM-ID = "+obj.getSimId());
            return new ResponseEntity<>(body.toString(),HttpStatus.NOT_FOUND);

        }else{
           
            body.put("data", updatedDevice);
            return new ResponseEntity<>(body.toString(),HttpStatus.OK);
        }
       
    
    }

    public ResponseEntity<Object> deleteDevice(String simId){
        boolean isDeleted=dao.deleteDevice(simId);
        JSONObject body =new JSONObject();
        if(isDeleted){
            body.put("message", "Device Deleted Successfully");
            return new ResponseEntity<>(body.toString(),HttpStatus.OK);

        }
        else{
            body.put("message", "Couldn't find device with SIM-ID = "+simId);
            return new ResponseEntity<>(body.toString(),HttpStatus.NOT_FOUND);
        }
  

    }

    public  ResponseEntity<Object> getWaitingDevices(){
        JSONObject body =new JSONObject();
        List<Device> devices=dao.getWaitingDevices();
        body.put("message", "Success");
        body.put("data", devices);

        return new ResponseEntity<>(body.toString(),HttpStatus.OK);
        
    }
    
    public  ResponseEntity<Object> getAvailableDevices(){
        JSONObject body =new JSONObject();
        List<Device> devices=dao.getDevicesForSale();
        body.put("message", "Success");
        body.put("data", devices);

        return new ResponseEntity<>(body.toString(),HttpStatus.OK);
        
    }
}
