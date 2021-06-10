package nik.behavior.strategy;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

public interface PayStrategy {

    ChainResult startChain(Transaction transaction);
}
