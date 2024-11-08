package com.epam.jmp.protocols.avro.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import com.epam.jmp.protocols.avro.example.User;

@Service
public class UserReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "my-test-topic", groupId = "group_id")
    public void consume(User message) throws IOException {
        LOGGER.info(String.format("#### -> Consumed User message -> %s", message));
    }
}
