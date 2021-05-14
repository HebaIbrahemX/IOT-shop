package com.vodafone.iot.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.vodafone.iot.dao.DeviceDAO;
import com.vodafone.iot.dto.DeviceDTO;
import com.vodafone.iot.model.Device;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DevicesServiceTest {

    @Mock
    DeviceDAO dao;

    @Mock
    GeneralValidation validation;

    @InjectMocks
    DevicesService service;

    ResponseEntity<Object> serviceRes;
    String simId="5#23";
    int status=2;
    Device device;
    DeviceDTO dto;
    List<Device> devices;


    public DevicesServiceTest(){
        this.device =new Device();
        device.setCountryCode(1234);
        device.setSimId("5#23");
        device.setSimOperator(1);
        device.setStatus(2);
        device.setDeviceTemperature(25);

        this.dto =new DeviceDTO();
        dto.setCountryCode(1234);
        dto.setSimId("5#23");
        dto.setSimOperator(1);
        dto.setStatus(2);
        devices =new ArrayList<Device>();
        devices.add(this.device);


    }

    @Test
    void updateDevice(){
        Mockito.when(dao.updateDeviceStatus(simId, status)).thenReturn(this.device);
         serviceRes =service.updateDevice(dto);
         assertEquals(serviceRes.getStatusCode(),HttpStatus.OK);
         verify(dao).updateDeviceStatus(simId, status);
    }

    @Test
    void deleteDevice(){
        Mockito.when(dao.deleteDevice(simId)).thenReturn(true);
        serviceRes =service.deleteDevice(simId);
        assertEquals(serviceRes.getStatusCode(),HttpStatus.OK);
         verify(dao).deleteDevice(simId);      

    }

    @Test
    void getWaitingDevices(){
        Mockito.when(dao.getWaitingDevices()).thenReturn(devices);
        serviceRes=service.getWaitingDevices();
        assertEquals(serviceRes.getStatusCode(),HttpStatus.OK);
        verify(dao).getWaitingDevices();
    }

    
    @Test
    void getAvailableDevices(){
        Mockito.when(dao.getDevicesForSale() ).thenReturn(null);
        serviceRes=service.getAvailableDevices();
        assertEquals(serviceRes.getStatusCode(),HttpStatus.OK);
        verify(dao).getDevicesForSale();
    }
    
}
