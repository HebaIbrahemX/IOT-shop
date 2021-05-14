package com.vodafone.iot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.vodafone.iot.*")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class VodafoneIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(VodafoneIotApplication.class, args);
	}

}
