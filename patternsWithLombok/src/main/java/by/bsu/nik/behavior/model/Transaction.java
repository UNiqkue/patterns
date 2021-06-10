package by.bsu.nik.behavior.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Transaction {
    private UUID id;
    private BigDecimal sum;
    private Status status;
    private Type type;
    private OffsetDateTime paidDate;
    private String cardNumber;
    private CardProvider cardProvider;
    private String payerAccount; //счёт плательщика
    private String beneficiaryAccount; //счёт получателя

    public enum CardProvider {
        MASTERCARD, VISA, BELCART
    }

    public enum Status {
        NEW
    }

    public enum Type {
        TRANSFER, //обычный
        PREFERENTIAL, //льготный
        GOS, //государственный
        IN_BANK //внутрибанковский
    }

}
