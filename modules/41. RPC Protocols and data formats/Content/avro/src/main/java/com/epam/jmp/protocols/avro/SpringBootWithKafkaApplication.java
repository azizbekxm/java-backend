package com.epam.jmp.protocols.avro;

import com.epam.jmp.protocols.avro.consumer.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.epam.jmp.protocols.avro")
@EnableConfigurationProperties(KafkaProperties.class)
public class SpringBootWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaApplication.class, args);
	}
}
