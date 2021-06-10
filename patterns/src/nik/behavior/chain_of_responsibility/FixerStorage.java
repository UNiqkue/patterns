package nik.behavior.chain_of_responsibility;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FixerStorage implements TransactionChain{
    private final Map<UUID, Transaction> transactionMap;

    public FixerStorage() {
        this.transactionMap = new HashMap<>();
    }
    @Override
    public ChainResult start(Transaction transaction) {
        UUID uuid = UUID.randomUUID();
        transaction.setId(uuid);
        transactionMap.put(uuid, transaction);
        return ChainResult.withMessage("Данная транзакция сохранена с id = " + uuid);
    }
}
