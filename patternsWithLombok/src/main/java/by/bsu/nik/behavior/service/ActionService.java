package by.bsu.nik.behavior.service;

import by.bsu.nik.behavior.model.Transaction;
import by.bsu.nik.behavior.strategy.PayStrategy;

public interface ActionService {
    void setStrategy(PayStrategy somePayStrategy);

    void execute(Transaction transaction);
}
