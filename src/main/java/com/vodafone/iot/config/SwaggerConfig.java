package com.vodafone.iot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    String  baseUrl="http://localhost:8080";


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
    registry.
        addResourceHandler(baseUrl + "/swagger-ui/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
        .resourceChain(false);
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController(baseUrl + "/swagger-ui/")
        .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
  }
  @Bean
  public Docket apiDocket() {
      return new Docket(DocumentationType.SWAGGER_2).host(baseUrl)
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build().apiInfo(apiInfo());
  }


private ApiInfo apiInfo() {
    return new ApiInfo(
      "IOT Shop API", 
      "Some custom description of API.", 
      "API TOS", 
      "Terms of service", 
      new Contact("Heba Ibrahem", "www.https://github.com/HebaIbrahemX", "heba.ibrahem.x@gmail.com"), 
      "License of API", "API license URL", Collections.emptyList());
}
    
}
