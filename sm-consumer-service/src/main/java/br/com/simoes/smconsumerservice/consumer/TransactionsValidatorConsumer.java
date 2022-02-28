package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.smconsumerservice.dto.TransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionsValidatorConsumer {

    @KafkaListener(
            topics = "${kafka.topics.transactions-validator.name}",
            groupId = "${kafka.topics.transactions-validator.groupId}")
    public void consumer(String message) throws JsonProcessingException {
        log.info("Consume new message {}", message);
        ObjectMapper mapper = new ObjectMapper();
        TransactionDTO transaction = mapper.readValue(message, TransactionDTO.class);
        log.info("Validate transaction for {}", transaction.getAccount());
    }

}
