package br.com.simoes.smproducerservice.configuration;

//@Configuration
public class KafkaProducerConfiguration {

//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServer;
//
//    @Bean
//    public ProducerFactory<String, TransactionDTO> transactionProducerFactory() {
//        Map<String, Object> properties = new HashMap<>();
//
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//        return new DefaultKafkaProducerFactory<>(properties);
//    }
//
//    @Bean
//    public KafkaTemplate<String, TransactionDTO> transactionKafkaTemplate() {
//        return new KafkaTemplate<>(transactionProducerFactory());
//    }

}
