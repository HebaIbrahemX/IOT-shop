package com.vodafone.iot.dao;

import java.util.List;

import com.vodafone.iot.model.Device;


public interface DAO {


    public Device updateDeviceStatus(String simId,int status);
    public Device addDevice(Device newDevice);
    public boolean deleteDevice(String simId);
    public List<Device> getDevicesByStatus(int status);
    
}
