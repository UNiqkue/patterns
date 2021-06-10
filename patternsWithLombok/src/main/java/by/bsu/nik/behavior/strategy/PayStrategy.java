package by.bsu.nik.behavior.strategy;

import by.bsu.nik.behavior.model.ChainResult;
import by.bsu.nik.behavior.model.Transaction;

public interface PayStrategy {

    ChainResult startChain(Transaction transaction);
}
