package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.Transaction;
import br.com.simoes.TransactionV2;
import br.com.simoes.smconsumerservice.mapper.TransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(topics = "${topics.transactions.name}")
public class TransactionsConsumer {

    @KafkaHandler
    public void consumerV1(Transaction record, Acknowledgment ack) {
        log.info("DTO {}", TransactionMapper.toDTO(record));
        ack.acknowledge();
    }

    @KafkaHandler
    public void consumerV2(TransactionV2 record, Acknowledgment ack) {
        log.info("DTO {}", TransactionMapper.toDTOV2(record));
        ack.acknowledge();
    }

    @KafkaHandler(isDefault = true)
    public void unknownMessage(Object object, Acknowledgment ack) {
        log.info("Unknown Message {}", object);
        ack.acknowledge();
    }

}
