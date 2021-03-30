package com.leonardo.examples.kafkaincubator.component;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
@RequiredArgsConstructor
@EnableScheduling
class Producer {
    private final KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    private NewTopic dajeStream;

    @EventListener(ApplicationStartedEvent.class)
    public void producer() {
        LongStream.range(1,10).forEach(i -> {
            kafkaTemplate.send(dajeStream.name(), i, "Daje").addCallback( result ->
            {
                if (result != null) {
                    System.out.println(result.getProducerRecord().value());
                    final long offset = result.getRecordMetadata().offset();
                    System.out.println("offset=" + offset);
                    final int partition = result.getRecordMetadata().partition();
                    System.out.println("partition=" + partition);
                }
            }, ex -> System.err.println("not now"));
        });
    }

    @Scheduled(fixedDelayString = "${application.kafka.producer.fixedDelay_ms:5000}")
    public void producerScheduled() {
        LongStream.range(1,10).forEach(i -> {
            kafkaTemplate.send(dajeStream.name(), i, "Daje").addCallback( result ->
            {
                if (result != null) {
                    System.out.println(result.getProducerRecord().value());
                    final long offset = result.getRecordMetadata().offset();
                    System.out.println("offset=" + offset);
                    final int partition = result.getRecordMetadata().partition();
                    System.out.println("partition=" + partition);
                }
            }, ex -> System.err.println("not now"));
        });
    }

}
