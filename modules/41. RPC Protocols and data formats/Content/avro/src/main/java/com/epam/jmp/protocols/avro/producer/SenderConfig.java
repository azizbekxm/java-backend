package com.epam.jmp.protocols.avro.producer;

import com.epam.jmp.protocols.avro.consumer.KafkaProperties;
import com.epam.jmp.protocols.avro.util.CastUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class SenderConfig {
    @Bean
    public ProducerFactory<String, Object> producerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaProducerFactory<String, Object>(CastUtil.castMap(kafkaProperties.getProducer()));
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(KafkaProperties kafkaProperties) {
        return new KafkaTemplate<String, Object>(producerFactory(kafkaProperties));
    }
}
