package app;

import model.Account;
import model.Bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BankApp {
    private static final String DB_FILE = "bank.db";

    public static void main(String[] args) {
        Bank bank = Bank.loadFromFile(DB_FILE);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to SimpleBank!");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1": // create
                        System.out.print("Holder name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Initial deposit (or blank for 0): ");
                        String init = sc.nextLine().trim();
                        BigDecimal initial = init.isEmpty() ? BigDecimal.ZERO : new BigDecimal(init);
                        Account acc = bank.createAccount(name, initial);
                        System.out.println("Account created: " + acc);
                        break;
                    case "2": // deposit
                        System.out.print("Account ID: ");
                        int did = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Amount: ");
                        BigDecimal damt = new BigDecimal(sc.nextLine().trim());
                        bank.deposit(did, damt);
                        System.out.println("Deposited. New balance: " + bank.getAccount(did).getBalance());
                        break;
                    case "3": // withdraw
                        System.out.print("Account ID: ");
                        int wid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Amount: ");
                        BigDecimal wamt = new BigDecimal(sc.nextLine().trim());
                        bank.withdraw(wid, wamt);
                        System.out.println("Withdrawn. New balance: " + bank.getAccount(wid).getBalance());
                        break;
                    case "4": // transfer
                        System.out.print("From Account ID: ");
                        int fid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("To Account ID: ");
                        int tid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Amount: ");
                        BigDecimal tamt = new BigDecimal(sc.nextLine().trim());
                        bank.transfer(fid, tid, tamt);
                        System.out.println("Transfer successful.");
                        break;
                    case "5": // view
                        System.out.print("Account ID: ");
                        int vid = Integer.parseInt(sc.nextLine().trim());
                        Account va = bank.getAccount(vid);
                        if (va == null) System.out.println("No account with id " + vid);
                        else System.out.println(va);
                        break;
                    case "6": // list
                        List<Account> all = bank.listAccounts();
                        if (all.isEmpty()) System.out.println("No accounts.");
                        else all.forEach(System.out::println);
                        break;
                    case "7": // close
                        System.out.print("Account ID to close: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        boolean ok = bank.closeAccount(cid);
                        System.out.println(ok ? "Closed." : "No such account.");
                        break;
                    case "0": // exit
                        running = false;
                        bank.saveToFile(DB_FILE);
                        System.out.println("Saved. Goodbye!");
                        break;
                    default:
                        System.out.println("Unknown option.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number. Try again.");
            } catch (IllegalArgumentException | NoSuchElementException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Unexpected error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an action:");
        System.out.println("1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View account");
        System.out.println("6. List accounts");
        System.out.println("7. Close account");
        System.out.println("0. Save & Exit");
        System.out.print("Enter choice: ");
    }
}

