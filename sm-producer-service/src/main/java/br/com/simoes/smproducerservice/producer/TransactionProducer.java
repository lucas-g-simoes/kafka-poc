package br.com.simoes.smproducerservice.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Instant;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class TransactionProducer {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final KafkaProducer<String, String> producer = new KafkaProducer<>(properties());

		final ProducerRecord<String, String> record = new ProducerRecord<>("simoes-transactions", "testeKey", "testeValue");

		producer
			.send(record, (data, e) -> {
				if (Objects.nonNull(e)) {
					log.error("Error to producer message", e);
					return;
				}

				log.info("Topic {} / Partition {} / Offset {} / Timestamp {}", data.topic(), data.partition(), data.offset(), Instant.ofEpochMilli(data.timestamp()));
			})
			.get();
	}

	private static Properties properties() {
		final Properties properties = new Properties();

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		return properties;
	}

}
