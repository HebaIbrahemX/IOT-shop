package com.vodafone.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="iot_device")
public class Device {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    // int id;

    @Column(name="device_status",nullable = false)
    int status;
 
    @Id
    @Column(name="sim_id",unique = true,nullable = false)
    String simId ;

    @Column(name = "sim_operator_code")
    int simOperator ;

    @Column(name = "sim_country_code")
    int countryCode;

    @Column(name = "device_temprature")
    int deviceTemperature;  //in celsius

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public int getSimOperator() {
        return simOperator;
    }

    public void setSimOperator(int simOperator) {
        this.simOperator = simOperator;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getDeviceTemperature() {
        return deviceTemperature;
    }

    public void setDeviceTemperature(int deviceTemperature) {
        this.deviceTemperature = deviceTemperature;
    }


    
}
