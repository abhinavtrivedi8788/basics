package com.engineering.basics.lock;

public class BankImpl {

    public void operations(){
        BankAccount bankAccount = new BankAccount(100000);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(70000);
            }
        };

        Thread t1 = new Thread(task,"ABHINAV");
        Thread t2 = new Thread(task,"RICHA");

        t1.start();
        t2.start();
    }

   static void main() {
        BankImpl bank = new BankImpl();
        bank.operations();
    }


}
