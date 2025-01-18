package com.example.india.utils;

import com.example.india.demo.config.DemoConfig;
import com.example.india.demo.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Date;

@Slf4j
@EnableConfigurationProperties(DemoConfig.class)
public class CommanUtil {


    @Autowired
    private GeneralService generalService;

    @Autowired
    private static DemoConfig demoConfig2;
    
    public static Date convertDate(DemoConfig demoConfig){
        String countryName = demoConfig.getCountryName();
        return new Date();
    }

    public static Boolean getCountryEnabled(DemoConfig demoConfig){
        System.out.println(demoConfig2);
        log.info("ipEnabled value is {}",demoConfig.getIpEnabled());
        return demoConfig.getIpEnabled();

    }

    public static String getMessage(String msg) {
        log.info("print the msg {}",msg);
        return msg;
    }
}
