package Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(Currency currency, Users users, double balance) {
        this.currency = currency;
        this.users = users;
        this.balance = balance;
    }

    public BankAccount(Users users, double balance) {
        this.users = users;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return balance == that.balance && Objects.equals(id, that.id) && Objects.equals(currency, that.currency) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, users, balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", users=" + users +
                ", balance=" + balance +
                '}';
    }
}
