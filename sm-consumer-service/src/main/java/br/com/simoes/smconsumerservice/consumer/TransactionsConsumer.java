package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.smconsumerservice.dto.TransactionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionsConsumer {

	@KafkaListener(
		topics = "${kafka.topics.transactions.name}",
		groupId = "${kafka.topics.transactions.groupId}")
	public void consumer(String message) throws JsonProcessingException {
		log.info("Consume new message {}", message);
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(message, TransactionDTO.class);
	}

}
