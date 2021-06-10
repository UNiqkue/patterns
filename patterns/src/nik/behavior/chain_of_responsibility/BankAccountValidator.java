package nik.behavior.chain_of_responsibility;

import nik.behavior.model.ChainResult;
import nik.behavior.model.Transaction;

public class BankAccountValidator implements TransactionChain {
    @Override
    public ChainResult start(Transaction transaction) {
        if (transaction.getPayerAccount() == null || transaction.getPayerAccount().length()!=20){
            ChainResult.withError("Поле payerAccount не заполнено или кол-во символов не равно 20");
        }
        if (transaction.getBeneficiaryAccount() == null || transaction.getBeneficiaryAccount().length()!=20){
            ChainResult.withError("Поле beneficiaryAccount не заполнено или кол-во символов не равно 20");
        }
        return ChainResult.withMessage("Проверка на валидацию номера счетов прошла успешно");
    }
}
