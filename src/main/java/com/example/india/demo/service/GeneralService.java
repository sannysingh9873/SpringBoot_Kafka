package com.example.india.demo.service;

import com.example.india.demo.config.DemoConfig;
import com.example.india.demo.dto.EmployeeDto;
import com.example.india.demo.producer.KafkaProducer;
import com.example.india.utils.CommanUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GeneralService {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    private DemoConfig demoConfig;

    public void sendToKafka(Object employeeDto){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String message = objectMapper.writeValueAsString(employeeDto);
            kafkaProducer.produceToKafka(message);
        } catch (Exception e) {
            log.error("Exception occurred while sending msg to kafka",e);
        }

    }

    public List<EmployeeDto> getDemoDetails() {
        log.info("In generalService class and getDemoDetails");
        if(CommanUtil.getCountryEnabled(demoConfig)){
            return Collections.singletonList(EmployeeDto.builder().id(101)
                    .name("sanny").address("Bangalore").build());
        }else{
            return Collections.emptyList();
        }


    }
}
