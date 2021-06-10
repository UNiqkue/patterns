package nik.behavior.chain_of_responsibility;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

import java.math.BigDecimal;

public class PreferentialSumAdding implements TransactionChain {
    private static final BigDecimal SUM = new BigDecimal(5);

    @Override
    public ChainResult start(Transaction transaction) {
        if (transaction.getSum() == null) {
            return ChainResult.withError("Не заполнена сумма");
        }
        BigDecimal oldSum = transaction.getSum();
        transaction.setSum(oldSum.add(SUM));
        ChainResult.withMessage("К сумме перевода добавлено :)) рублей = " + SUM);

        return ChainResult.ok();
    }
}
