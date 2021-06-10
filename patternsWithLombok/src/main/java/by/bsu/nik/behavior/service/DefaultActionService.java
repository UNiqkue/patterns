package by.bsu.nik.behavior.service;

import by.bsu.nik.behavior.model.ChainResult;
import by.bsu.nik.behavior.model.Transaction;
import by.bsu.nik.behavior.strategy.PayStrategy;

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
