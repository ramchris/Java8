package com.company.locks;

public class BankAccount {
    private final int id; // Unique, immutable ID
    private double balance;

    public BankAccount(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }
    private static final Object tieBreaker = new Object();

    public static void transferWithHash(BankAccount from, BankAccount to, double amount) {
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        System.out.println("fromHash: " + fromHash);
        System.out.println("toHash: " + toHash);

        if (fromHash < toHash) {
            synchronized (from) { synchronized (to) {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("Transfer successful from " + from.id + " to " + to.id);
                    System.out.println("new balance of account "+from.id+": " + from.balance);
                    System.out.println("new blaance of acccount b:" + to.balance);
                }
            } }
        } else if (toHash < fromHash) {
            synchronized (to) { synchronized (from) {
                if (to.balance >= amount) {
                    to.balance -= amount;
                    from.balance += amount;
                    System.out.println("Transfer successful from " + from.id + " to " + to.id);
                    System.out.println("new balance of account "+from.id+": " + from.balance);
                    System.out.println("new blaance of acccount b:" + to.balance);
                }
            } }
        } else {
            // Tie-breaker: only one thread can attempt a transfer between
            // these specific conflicting hash-code objects at a time.
            synchronized (tieBreaker) {
                synchronized (from) { synchronized (to) { /* perform transfer */ } }
            }
        }
    }


    public static void transfer(BankAccount from, BankAccount to, double amount) {
        // Step 1: Identify the order based on ID
        BankAccount firstLock = from.id < to.id ? from : to;
        BankAccount secondLock = from.id < to.id ? to : from;

        // Step 2: Acquire locks in the strictly defined order
        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.balance >= amount) {
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("Transfer successful from " + from.id + " to " + to.id);
                    System.out.println("new balance of account "+from.id+": " + from.balance);
                    System.out.println("new blaance of acccount b:" + to.balance);
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1, 100);
        BankAccount account2 = new BankAccount(2, 50);
        // transfer(account1, account2, 30);
        transferWithHash(account1, account2, 30);
    }
}
