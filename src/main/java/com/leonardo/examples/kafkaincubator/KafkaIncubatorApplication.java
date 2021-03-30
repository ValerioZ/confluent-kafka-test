package com.leonardo.examples.kafkaincubator;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@SpringBootApplication
public class KafkaIncubatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaIncubatorApplication.class, args);
	}

}
