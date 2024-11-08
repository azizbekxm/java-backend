package com.epam.jmp.protocols.avro.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${spring.kafka.topic.avro}")
    private String avroTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Object user) {
        LOGGER.info("sending user='{}'", user.toString());
        LOGGER.info(String.format("#### -> Producing message -> %s", user.toString()));
        kafkaTemplate.send(avroTopic, user);
    }
}
