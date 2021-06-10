package nik.behavior.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

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

    public UUID getId() {
        return id;
    }

    public Transaction setId(UUID id) {
        this.id = id;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public Transaction setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Transaction setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Transaction setType(Type type) {
        this.type = type;
        return this;
    }

    public OffsetDateTime getPaidDate() {
        return paidDate;
    }

    public Transaction setPaidDate(OffsetDateTime paidDate) {
        this.paidDate = paidDate;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Transaction setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CardProvider getCardProvider() {
        return cardProvider;
    }

    public Transaction setCardProvider(CardProvider cardProvider) {
        this.cardProvider = cardProvider;
        return this;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public Transaction setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
        return this;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public Transaction setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(sum, that.sum) && status == that.status && type == that.type && Objects.equals(paidDate, that.paidDate) && Objects.equals(cardNumber, that.cardNumber) && cardProvider == that.cardProvider && Objects.equals(payerAccount, that.payerAccount) && Objects.equals(beneficiaryAccount, that.beneficiaryAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, status, type, paidDate, cardNumber, cardProvider, payerAccount, beneficiaryAccount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sum=" + sum +
                ", status=" + status +
                ", type=" + type +
                ", paidDate=" + paidDate +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardProvider=" + cardProvider +
                ", payerAccount='" + payerAccount + '\'' +
                ", beneficiaryAccount='" + beneficiaryAccount + '\'' +
                '}';
    }
}
