package br.com.simoes.smconsumerservice.mapper;

import br.com.simoes.Transaction;
import br.com.simoes.TransactionV2;
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

    public static TransactionDTO toDTOV2(final TransactionV2 transaction) {
        return TransactionDTO
                .builder()
                .account(transaction.getAccountId())
                .amount(transaction.getAmmount())
                .type(transaction.getType().toString())
                .build();
    }
}
