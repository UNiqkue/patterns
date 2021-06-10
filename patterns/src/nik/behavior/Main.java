package nik.behavior;

import nik.behavior.model.Transaction;
import nik.behavior.service.DefaultActionService;
import nik.behavior.service.DefaultPayService;
import nik.behavior.service.PayService;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {
    //   9. Прохождение платежа через банковскую систему сопровождается целым рядом действий:
    //   фиксирующих,
    //   контролирующих,
    //   снимающих процент банка и прочие вычеты и действия.
    //   Построить цепочки для различного вида платежей
    //   (обычных, льготных, государственных, внутрибанковских)
    //   в соответствии с предметной областью и разработать модель системы.
    public static void main(String[] args) {
        Transaction transaction = new Transaction()
                .setSum(new BigDecimal(50))
                .setStatus(Transaction.Status.NEW)
                .setType(Transaction.Type.TRANSFER)
                .setPaidDate(OffsetDateTime.now())
                .setCardNumber("1234567812341234")
                .setCardProvider(Transaction.CardProvider.BELCART)
                .setPayerAccount("BY1231AKSJJNA2121234")
                .setBeneficiaryAccount("BY45JHABSYW929324567");

        PayService payService = new DefaultPayService(new DefaultActionService());
        payService.pay(transaction);
    }
}
