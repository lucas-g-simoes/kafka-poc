package br.com.simoes.smproducerservice.api.mapper;

import br.com.simoes.Transaction;
import br.com.simoes.TransactionV2;
import br.com.simoes.smproducerservice.api.dto.TransactionDTO;

public abstract class TransactionMapper {

    private TransactionMapper() {
    }

    public static Transaction fromDTO(final TransactionDTO dto) {
        return Transaction
                .newBuilder()
                .setAccountId(dto.getAccount())
                .setAmmount(dto.getAmount())
                .build();
    }

    public static TransactionV2 fromDTOV2(final TransactionDTO dto) {
        return TransactionV2
                .newBuilder()
                .setAccountId(dto.getAccount())
                .setAmmount(dto.getAmount())
                .setType(dto.getType())
                .build();
    }

}
