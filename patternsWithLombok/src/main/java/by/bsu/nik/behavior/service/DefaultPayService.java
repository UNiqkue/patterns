package by.bsu.nik.behavior.service;

import by.bsu.nik.behavior.model.Transaction;
import by.bsu.nik.behavior.strategy.BankPayStrategy;
import by.bsu.nik.behavior.strategy.GosPayStrategy;
import by.bsu.nik.behavior.strategy.PayStrategy;
import by.bsu.nik.behavior.strategy.PreferentialPayStrategy;
import by.bsu.nik.behavior.strategy.TransferPayStrategy;

import java.util.HashMap;
import java.util.Map;

public class DefaultPayService implements PayService {
    private final ActionService actionService;
    private final Map<Transaction.Type, PayStrategy> payStrategyMap;

    public DefaultPayService(ActionService actionService) {
        this.actionService = actionService;
        this.payStrategyMap = buildPayStrategyMap();
    }

    @Override
    public void pay(Transaction transaction) {
        PayStrategy somePayStrategy = payStrategyMap.get(transaction.getType());
        actionService.setStrategy(somePayStrategy);
        actionService.execute(transaction);
    }

    private Map<Transaction.Type, PayStrategy> buildPayStrategyMap() {
        HashMap<Transaction.Type, PayStrategy> payStrategyMap = new HashMap<>();
        payStrategyMap.put(Transaction.Type.TRANSFER, new TransferPayStrategy());
        payStrategyMap.put(Transaction.Type.GOS, new GosPayStrategy());
        payStrategyMap.put(Transaction.Type.PREFERENTIAL, new PreferentialPayStrategy());
        payStrategyMap.put(Transaction.Type.IN_BANK, new BankPayStrategy());
        return payStrategyMap;
    }
}
