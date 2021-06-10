package nik.behavior.chain_of_responsibility;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

import java.math.BigDecimal;

public class GosPercentWithdrawing implements TransactionChain {
    private static final BigDecimal PERCENT = new BigDecimal(10);

    @Override
    public ChainResult start(Transaction transaction) {
        if (transaction.getSum() == null) {
            return ChainResult.withError("Не заполнена сумма");
        }
        BigDecimal oldSum = transaction.getSum();
        BigDecimal newSum = oldSum.movePointLeft(2).multiply(PERCENT);
        transaction.setSum(newSum);
        ChainResult.withMessage("Снято 10% в рублях это " + oldSum.subtract(newSum));

        return ChainResult.ok();
    }
}
