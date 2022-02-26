package br.com.simoes.smconsumerservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class TransactionsConsumer {

	public static void main(String[] args) {
		final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties());

		consumer.subscribe(Collections.singletonList("simoes-transactions"));
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

		if (records.isEmpty()) {
			log.warn("No message");
			return;
		}

		 for (ConsumerRecord<String, String> record : records) {
			 log.info("--- Message in Topic ---");
			 log.info("Key: {}", record.key());
			 log.info("Value: {}", record.value());
			 log.info("Partition: {}", record.partition());
			 log.info("Offset: {}", record.offset());
		 }
	}

	private static Properties properties() {
		Properties properties = new Properties();

		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		return properties;
	}

}
