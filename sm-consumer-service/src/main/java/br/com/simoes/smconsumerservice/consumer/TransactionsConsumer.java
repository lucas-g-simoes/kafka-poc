package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.smconsumerservice.dto.TransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionsConsumer {

	@KafkaListener(topics = "${topics.transactions.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
	public void consumer(ConsumerRecord<String, TransactionDTO> record) throws JsonProcessingException {
		log.info("Consume new message {} - {} - {}", record.topic(), record.partition(), record.offset());
        log.info("Message {}", record.value());
	}

}
