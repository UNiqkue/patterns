package nik.behavior.service;

import nik.behavior.model.Transaction;
import nik.behavior.strategy.PayStrategy;

public interface ActionService {
    void setStrategy(PayStrategy somePayStrategy);

    void execute(Transaction transaction);
}
