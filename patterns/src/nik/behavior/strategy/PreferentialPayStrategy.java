package nik.behavior.strategy;

import nik.behavior.chain_of_responsibility.BankAccountValidator;
import nik.behavior.chain_of_responsibility.Chain;
import nik.behavior.chain_of_responsibility.FixerStorage;
import nik.behavior.chain_of_responsibility.PreferentialSumAdding;
import nik.behavior.chain_of_responsibility.TransactionChain;
import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

public class PreferentialPayStrategy implements PayStrategy {
    private final Chain<Transaction> payStrategyChain;

    public PreferentialPayStrategy() {
        payStrategyChain = buildPayStrategyChain();
    }

    @Override
    public ChainResult startChain(Transaction transaction) {
        return payStrategyChain.start(transaction);
    }

    private Chain<Transaction> buildPayStrategyChain() {
        return new FixerStorage()
                .addNext(new BankAccountValidator())
                .addNext(new PreferentialSumAdding())
                .addNext(TransactionChain.paidDateValidator("Время совершения платежа пустое"));
    }
}
