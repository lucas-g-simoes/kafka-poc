package br.com.simoes.smconsumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SMConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SMConsumerServiceApplication.class, args);
	}

}
