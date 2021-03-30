package com.leonardo.examples.kafkaincubator.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    NewTopic dajeStream() {
        return new NewTopic("test_topic_test2", 3, (short) 3);
    }
}
