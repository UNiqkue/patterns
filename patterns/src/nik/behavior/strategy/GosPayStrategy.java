package nik.behavior.strategy;

import nik.behavior.chain_of_responsibility.BankAccountValidator;
import nik.behavior.chain_of_responsibility.Chain;
import nik.behavior.chain_of_responsibility.FixerStorage;
import nik.behavior.chain_of_responsibility.GosPercentWithdrawing;
import nik.behavior.chain_of_responsibility.TransactionChain;
import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

public class GosPayStrategy implements PayStrategy {
    private final Chain<Transaction> payStrategyChain;

    public GosPayStrategy() {
        payStrategyChain = buildPayStrategyChain();
    }

    @Override
    public ChainResult startChain(Transaction transaction) {
        return payStrategyChain.start(transaction);
    }

    private Chain<Transaction> buildPayStrategyChain() {
        return new FixerStorage()
                .addNext(new BankAccountValidator())
                .addNext(new GosPercentWithdrawing())
                .addNext(TransactionChain.paidDateValidator("Время совершения платежа пустое"));
    }
}
