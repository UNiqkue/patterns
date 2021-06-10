package by.bsu.nik.behavior.chain_of_responsibility;

import by.bsu.nik.behavior.model.ChainResult;
import by.bsu.nik.behavior.model.Transaction;

import java.math.BigDecimal;

public class DefaultPercentWithdrawing implements TransactionChain {
    private static final BigDecimal PERCENT = new BigDecimal(5);

    @Override
    public ChainResult start(Transaction transaction) {
        if (transaction.getSum() == null) {
            return ChainResult.withError("Не заполнена сумма");
        }
        BigDecimal oldSum = transaction.getSum();
        if (Transaction.CardProvider.MASTERCARD.equals(transaction.getCardProvider())
                || Transaction.CardProvider.VISA.equals(transaction.getCardProvider())) {
            BigDecimal newSum = oldSum.movePointLeft(2).multiply(PERCENT);
            transaction.setSum(newSum);
            ChainResult.withMessage("Снято 5% в рублях это " + oldSum.subtract(newSum));
        } else {
            BigDecimal newSum = oldSum.movePointLeft(2);
            transaction.setSum(newSum);
            ChainResult.withMessage("Снято 1% в рублях это " + oldSum.subtract(newSum));
        }

        return ChainResult.ok();
    }
}