package nik.behavior.strategy;

import nik.behavior.chain_of_responsibility.BankAccountValidator;
import nik.behavior.chain_of_responsibility.Chain;
import nik.behavior.chain_of_responsibility.FixerStorage;
import nik.behavior.chain_of_responsibility.TransactionChain;
import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

public class BankPayStrategy implements PayStrategy {
    private final Chain<Transaction> payStrategyChain;

    public BankPayStrategy() {
        payStrategyChain = buildPayStrategyChain();
    }

    @Override
    public ChainResult startChain(Transaction transaction) {
        return payStrategyChain.start(transaction);
    }

    private Chain<Transaction> buildPayStrategyChain() {
        return new FixerStorage()
                .addNext(new BankAccountValidator())
                .addNext(TransactionChain.paidDateValidator("Время совершения платежа пустое"))
                .addNext(TransactionChain.cardNumberValidator("Номер карты не заполнен"))
                .addNext(TransactionChain.sumValidator("Не указана сумма"));
    }

}
