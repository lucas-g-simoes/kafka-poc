package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.Transaction;
import br.com.simoes.smconsumerservice.mapper.TransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionsConsumer {

    @KafkaListener(topics = "${topics.transactions.name}")
    public void consumer(ConsumerRecord<String, Transaction> record, Acknowledgment ack) {
        log.info("Consume new message {} - {} - {}", record.topic(), record.partition(), record.offset());

        log.info("Message {}", record.value());
        log.info("DTO {}", TransactionMapper.toDTO(record.value()));

        ack.acknowledge();
    }

}
