package Entity;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    private BankAccount cardFrom;
    @ManyToOne
    private BankAccount cardTo;
    private int sum;


    public Transaction() {
    }

    public Transaction(BankAccount cardFrom, BankAccount cardTo, int sum) {
        this.cardFrom = cardFrom;
        this.cardTo = cardTo;
        this.sum = sum;
    }

    public Transaction(BankAccount cardTo, int sum) {
        this.cardTo = cardTo;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BankAccount getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(BankAccount cardFrom) {
        this.cardFrom = cardFrom;
    }

    public BankAccount getCardTo() {
        return cardTo;
    }

    public void setCardTo(BankAccount cardTo) {
        this.cardTo = cardTo;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", cardFrom=" + cardFrom +
                ", cardTo=" + cardTo +
                ", sum=" + sum +
                '}';
    }
}
