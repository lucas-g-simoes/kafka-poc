package br.com.simoes.smproducerservice.api;

import br.com.simoes.smproducerservice.dto.TransactionDTO;
import br.com.simoes.smproducerservice.producer.TransactionProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionProducer producer;

	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(final TransactionDTO transaction) throws JsonProcessingException {
		this.producer.send(transaction);
		return ResponseEntity.noContent().build();
	}

}
