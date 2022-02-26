package br.com.simoes.smkafkaadministrator.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
public class KafkaAdminConfiguration {

	@Value("${kafka.bootstrap.url}")
	private String bootstrapServer;

	@Bean
	public KafkaAdmin admin() {
		return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer));
	}

}
