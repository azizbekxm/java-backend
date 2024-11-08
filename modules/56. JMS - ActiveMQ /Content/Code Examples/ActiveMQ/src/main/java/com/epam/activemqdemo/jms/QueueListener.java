package com.epam.activemqdemo.jms;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Slf4j
@Component
public class QueueListener {

    @Value("${activemq.queue}")
    private String queue;

    @JmsListener(destination = "${activemq.queue}", containerFactory = "queueListenerFactory")
    public void receiveMessageFromQueue(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        String messageData = textMessage.getText();
        log.info("Received message: " + messageData + " from queue - " + queue);
    }
}
