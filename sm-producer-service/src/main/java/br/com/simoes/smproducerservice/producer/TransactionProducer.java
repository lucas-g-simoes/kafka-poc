package br.com.simoes.smproducerservice.producer;

import br.com.simoes.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionProducer {

	@Value("${topics.transactions.name}")
	private String topic;

	private final KafkaTemplate<String, Transaction> kafkaTemplate;

	public void send(final Transaction transaction) {
		log.info("Send {} to {}", transaction, this.topic);

		this.kafkaTemplate
			.send(this.topic, String.valueOf(transaction.getAccountId()), transaction)
			.addCallback(new ListenableFutureCallback<>() {

				@Override
				public void onFailure(final Throwable ex) {
					log.error("Fail to send message", ex);
				}

				@Override
				public void onSuccess(final SendResult<String, Transaction> result) {
					final RecordMetadata data = result.getRecordMetadata();
					log.info("Success to publish message");
					log.info("Topic {}", data.topic());
					log.info("Partition {}", data.partition());
					log.info("Date {}", Instant.ofEpochMilli(data.timestamp()));
				}
			});
	}

}
