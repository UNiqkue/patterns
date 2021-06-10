package by.bsu.nik.behavior.chain_of_responsibility;

import by.bsu.nik.behavior.model.ChainResult;
import by.bsu.nik.behavior.model.Transaction;

import java.util.Objects;
import java.util.function.Function;

public interface TransactionChain extends Chain<Transaction> {
    static TransactionChain addValidator(Function<Transaction, ChainResult> resultFunction) {
        return resultFunction::apply;
    }

    static TransactionChain paidDateValidator(String message) {
        return TransactionChain.addValidator((transaction) -> {
            if (Objects.nonNull(transaction.getPaidDate())) {
                return ChainResult.ok();
            } else {
                return ChainResult.withError(message);
            }
        });
    }

    static TransactionChain cardNumberValidator(String message) {
        return TransactionChain.addValidator((transaction) -> {
            if (Objects.nonNull(transaction.getCardNumber())) {
                return ChainResult.ok();
            } else {
                return ChainResult.withError(message);
            }
        });
    }

    static TransactionChain sumValidator(String message) {
        return TransactionChain.addValidator((transaction) -> {
            if (Objects.nonNull(transaction.getSum())) {
                return ChainResult.ok();
            } else {
                return ChainResult.withError(message);
            }
        });
    }

}
