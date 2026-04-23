package com.engineering.basics.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int  balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    private Lock reentrantLock = new ReentrantLock();

    public void withdraw(int amount){

        //synchronized implementation
        /*System.out.println(Thread.currentThread().getName() + " attempting to Withdraw " + amount);
       if (balance >= amount) {
            System.out.println(Thread.currentThread().getName()+ " proceeding with withdrawal " );
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal " + balance);

        }else{
            System.out.println(Thread.currentThread().getName()+ " Not enough balance ");
        }*/
        try {
            System.out.println(Thread.currentThread().getName() + " attempting to Withdraw " + amount);
            if (reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName()+ " proceeding with withdrawal :)" );
                        Thread.sleep(2000);// simulate the db call
                        balance = balance - amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        reentrantLock.unlock();// to release the lock
                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+ " Not enough balance ");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+ " could not acquire lock , will try again later :(");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


