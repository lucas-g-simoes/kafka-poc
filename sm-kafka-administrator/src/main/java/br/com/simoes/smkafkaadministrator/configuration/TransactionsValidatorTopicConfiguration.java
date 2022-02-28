package br.com.simoes.smkafkaadministrator.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TransactionsValidatorTopicConfiguration {

    @Value("${kafka.topics.transactions-validator.name}")
    private String TOPIC_NAME;

    @Value("${kafka.topics.transactions-validator.partitions}")
    private int TOPIC_PARTITIONS;

    @Value("${kafka.topics.transactions-validator.replicas}")
    private int TOPIC_REPLICAS;

    @Bean
    public NewTopic transactionsValidator() {
        return TopicBuilder
                .name(TOPIC_NAME)
                .partitions(TOPIC_PARTITIONS)
                .replicas(TOPIC_REPLICAS)
                .build();
    }

}
