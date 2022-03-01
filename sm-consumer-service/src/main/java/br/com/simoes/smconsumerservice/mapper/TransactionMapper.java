package br.com.simoes.smconsumerservice.mapper;

import br.com.simoes.Transaction;
import br.com.simoes.smconsumerservice.dto.TransactionDTO;

public abstract class TransactionMapper {

    private TransactionMapper() {
    }

    public static TransactionDTO toDTO(final Transaction transaction) {
        return TransactionDTO
                .builder()
                .account(transaction.getAccountId())
                .amount(transaction.getAmmount())
                .build();
    }

}
