package br.com.simoes.smproducerservice.api.controller;

import br.com.simoes.smproducerservice.api.dto.TransactionDTO;
import br.com.simoes.smproducerservice.api.mapper.TransactionMapper;
import br.com.simoes.smproducerservice.producer.TransactionProducer;
import br.com.simoes.smproducerservice.producer.TransactionV2Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionProducer producer;

    private final TransactionV2Producer v2Producer;

    @PostMapping(value = "/v1/transactions", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody final TransactionDTO transaction) {
        this.producer.send(TransactionMapper.fromDTO(transaction));
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v2/transactions", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createV2(@RequestBody final TransactionDTO transaction) {
        this.v2Producer.send(TransactionMapper.fromDTOV2(transaction));
        return ResponseEntity.noContent().build();
    }

}
