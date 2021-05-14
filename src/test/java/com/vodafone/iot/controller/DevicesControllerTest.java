package com.vodafone.iot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.vodafone.iot.config.WebConfig;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = DevicesController.class)
@ContextConfiguration(classes = WebConfig.class)
@ExtendWith(MockitoExtension.class)
public class DevicesControllerTest {

    @Autowired
    private WebApplicationContext wac ;

    private MockMvc mockMvc ;

    
    @BeforeEach
    public void setup(){
        this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void getWaitingDevices() throws Exception{
        ResultActions actions =mockMvc.perform(get("/iot-shop/devices/waiting-for-activation").contentType("application/json"))
        .andDo(print());
        actions.andExpect(status().isOk());
        
    }

    @Test
    void getAvailableDevices() throws Exception{
        ResultActions actions =mockMvc.perform(get("/iot-shop/devices/available-for-sale").contentType("application/json"))
        .andDo(print());
        actions.andExpect(status().isOk());

    }
    
}
