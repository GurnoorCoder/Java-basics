package model;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank implements Serializable {
    private static final long serialVersionUID = 2L;

    private final Map<Integer, Account> accounts = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1000); // start IDs at 1000

    public Account createAccount(String name, BigDecimal initialDeposit) {
        int id = idGenerator.getAndIncrement();
        Account acc = new Account(id, name, initialDeposit == null ? BigDecimal.ZERO : initialDeposit);
        accounts.put(id, acc);
        return acc;
    }

    public Account getAccount(int id) {
        return accounts.get(id);
    }

    public List<Account> listAccounts() {
        List<Account> list = new ArrayList<>(accounts.values());
        list.sort(Comparator.comparingInt(Account::getId));
        return list;
    }

    public boolean closeAccount(int id) {
        return accounts.remove(id) != null;
    }

    public void deposit(int id, BigDecimal amount) {
        Account a = accounts.get(id);
        if (a == null) throw new NoSuchElementException("Account not found: " + id);
        a.deposit(amount);
    }

    public void withdraw(int id, BigDecimal amount) {
        Account a = accounts.get(id);
        if (a == null) throw new NoSuchElementException("Account not found: " + id);
        a.withdraw(amount);
    }

    public void transfer(int fromId, int toId, BigDecimal amount) {
        if (fromId == toId) throw new IllegalArgumentException("Cannot transfer to same account");
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (from == null || to == null) throw new NoSuchElementException("Account not found");
        // simple synchronized order by id to avoid deadlock if multi-threaded
        Account first = fromId < toId ? from : to;
        Account second = fromId < toId ? to : from;
        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    /* Persistence helpers */

    public static Bank loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) return new Bank();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof Bank) {
                return (Bank) obj;
            } else {
                System.err.println("File doesn't contain Bank object. Starting fresh.");
                return new Bank();
            }
        } catch (Exception e) {
            System.err.println("Failed to load bank data: " + e.getMessage());
            return new Bank();
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Failed to save bank data: " + e.getMessage());
        }
    }
}
