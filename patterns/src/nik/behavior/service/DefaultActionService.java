package nik.behavior.service;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;
import nik.behavior.strategy.PayStrategy;

public class DefaultActionService implements ActionService {
    private PayStrategy payStrategy;

    @Override
    public void setStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    @Override
    public void execute(Transaction transaction) {
        ChainResult chainResult = payStrategy.startChain(transaction);
        if (chainResult.isNotValid()){
            System.out.println("Присутствует ошибка");
        }
        chainResult.getAllMessages()
                .forEach(System.out::println);
    }
}
