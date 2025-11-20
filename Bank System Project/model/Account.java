package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private String holderName;
    private BigDecimal balance;
    private final LocalDateTime createdAt;

    public Account(int id, String holderName, BigDecimal initialDeposit) {
        this.id = id;
        this.holderName = holderName;
        this.balance = initialDeposit == null ? BigDecimal.ZERO : initialDeposit;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public BigDecimal getBalance() { return balance; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public synchronized void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}

