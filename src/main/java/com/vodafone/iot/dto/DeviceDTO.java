package com.vodafone.iot.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DeviceDTO implements DTO{



    @NotNull(message = "'status' field is required")
    int status;

    @NotBlank(message = "'simId' field is required")
    String simId ;

   
    int simOperator ;

    int countryCode;

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
    
    
}
