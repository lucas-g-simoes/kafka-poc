package br.com.simoes.smproducerservice.api.controller;

import br.com.simoes.smproducerservice.api.dto.TransactionDTO;
import br.com.simoes.smproducerservice.api.mapper.TransactionMapper;
import br.com.simoes.smproducerservice.producer.TransactionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionProducer producer;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody final TransactionDTO transaction) {
        this.producer.send(TransactionMapper.fromDTO(transaction));
        return ResponseEntity.noContent().build();
    }

}
