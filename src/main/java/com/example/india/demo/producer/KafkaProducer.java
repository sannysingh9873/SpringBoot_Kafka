package com.example.india.demo.producer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.example.india.demo.constant.AppConstants.MY_TOPIC_NAME;


@Slf4j
@Component
public class KafkaProducer {


    @Autowired
    private KafkaTemplate kafkaTemplate;
    public void produceToKafka(String message){
        try {
            log.info("sending kafka message");
            kafkaTemplate.send(MY_TOPIC_NAME,message);
            log.info("message send successfully");
        } catch (Exception e) {
            log.error("publishing kafka message failed");
            throw  new RuntimeException("Failed to publish message",e);
        }
    }
}
