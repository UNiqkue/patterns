package by.bsu.nik.behavior.strategy;

import by.bsu.nik.behavior.model.ChainResult;
import by.bsu.nik.behavior.model.Transaction;
import by.bsu.nik.behavior.chain_of_responsibility.BankAccountValidator;
import by.bsu.nik.behavior.chain_of_responsibility.Chain;
import by.bsu.nik.behavior.chain_of_responsibility.FixerStorage;
import by.bsu.nik.behavior.chain_of_responsibility.GosPercentWithdrawing;
import by.bsu.nik.behavior.chain_of_responsibility.TransactionChain;

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
