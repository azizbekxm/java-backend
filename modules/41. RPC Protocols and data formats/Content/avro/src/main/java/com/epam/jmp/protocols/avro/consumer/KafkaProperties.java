package com.epam.jmp.protocols.avro.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.kafka")
@Getter
@Setter
public class KafkaProperties {
    private Map<String, String> producer;
    private Map<String, String> consumer;
}
