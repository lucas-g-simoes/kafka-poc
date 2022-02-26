package br.com.simoes.smconsumerservice.consumer;

import br.com.simoes.smconsumerservice.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionsConsumer {

	@KafkaListener(
		topics = "${kafka.topics.transactions.name}",
		groupId = "${kafka.topics.transactions.groupId}",
		containerFactory = "kafkaListenerContainerFactory")
	public void consumer(TransactionDTO message) {
		log.info("Consume new message {}", message);
	}

}
