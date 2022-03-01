package br.com.simoes.smproducerservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

	private Integer amount;

	private Integer account;

	private String type;

}
