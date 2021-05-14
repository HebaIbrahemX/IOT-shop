package com.vodafone.iot.dao;

import java.util.List;

import com.vodafone.iot.model.Device;
import com.vodafone.iot.utils.DeviceStatus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceDAO implements DAO {

  
    @Autowired
    SessionFactory factory;
    Session session;
  

    @Override
    public boolean deleteDevice(String simId) {
       
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        Device device =(Device)session.get(Device.class, simId);
        if(device==null){
            return false;
        }else{
        session.delete(device);
        return true;}
    }

    @Override
    public Device updateDeviceStatus(String simId, int status) {
        
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        Query query= session.createQuery("Update Device m set m.status=:status WHERE m.simId=:simId");
        query.setParameter("status", status);
        query.setParameter("simId", simId);
        query.executeUpdate();

        return (Device)session.get(Device.class, simId);
        
    }

    @Override
    public Device addDevice(Device newDevice) {
        
        return null;
    }


    @Override
    public List<Device> getDevicesByStatus(int status) {
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        Query query= session.createQuery("SELECT m FROM Device m WHERE m.status=:status",Device.class);
        query.setParameter("status", status);
        
        return query.getResultList();
    }

    public List<Device> getWaitingDevices() {
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        Query query= session.createQuery("SELECT m FROM Device m WHERE m.status=:status",Device.class);
        query.setParameter("status", DeviceStatus.WAITING_FOR_ACTIVATION);    
        return query.getResultList();
    }

    public List<Device>getDevicesForSale(){
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        String queryClause="SELECT m FROM Device m WHERE m.status=:status";
        Query query= session.createQuery(queryClause,Device.class);
        query.setParameter("status", DeviceStatus.WAITING_FOR_ACTIVATION);    
        return query.getResultList();

    }
    //-----------------------------------------
    public void populateDeviceTable() {
        session = factory.getCurrentSession(); 
        session.beginTransaction();
        List<Device> devices=session.createQuery("SELECT m FROM Device m ",Device.class).getResultList();
        if(devices.isEmpty()){
            System.out.println("======================Started seeding");

        Device device =new Device();
        device.setCountryCode(1234);
        device.setSimId("5#23");
        device.setSimOperator(1);
        device.setStatus(1);
        device.setDeviceTemperature(25);
        session.save(device);
        session.flush();
        session.close();
    
    }
        else{
            System.out.println("=========No seeding needed");
        }

    }
    
}
