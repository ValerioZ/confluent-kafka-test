package com.leonardo.examples.kafkaincubator.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "myconsumer", topics = "test_topic_test2")
    public void consume(ConsumerRecord<Long, String> myRecord) {
        System.out.println("My Record:" + myRecord.key() + " - " + myRecord.value());
    }
}
