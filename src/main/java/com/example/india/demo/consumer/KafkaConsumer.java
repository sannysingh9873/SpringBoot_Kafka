package com.example.india.demo.consumer;

import com.example.india.demo.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.india.demo.constant.AppConstants.MY_TOPIC_NAME;

@Component
@Slf4j
public class KafkaConsumer {

   // @KafkaListener(topics = MY_TOPIC_NAME,groupId = "abc")
    public void getKafkaMessage(String msg) throws JsonProcessingException {
        EmployeeDto employeeDto = new ObjectMapper().readValue(msg, EmployeeDto.class);
        log.info("we consume the message >>> :{}" ,employeeDto);
    }

   // @KafkaListener(topics = MY_TOPIC_NAME,groupId = "abcwithconsuer")
    public void getConsumerRecord(ConsumerRecord consumerRecord) throws JsonProcessingException {
        String msg = (String) consumerRecord.value();
        EmployeeDto employeeDto = new ObjectMapper().readValue(msg, EmployeeDto.class);
        log.info("getConsumerRecord message >>> :{}" ,employeeDto);
    }
}
