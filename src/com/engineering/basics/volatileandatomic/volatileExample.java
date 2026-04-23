package com.engineering.basics.volatileandatomic;


class SharedResource {

    // by making the flag variable volatile,
    // we ensure that all threads see the most up-to-date value of the flag variable.
    // As every Thread will read the value of flag directly from main memory, rather than from a thread-local cache,
    // which ensures visibility of changes made by one thread to other threads.
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        System.out.println("Writer Thread: Setting flag to " + flag);
        this.flag = flag;
    }

    public boolean getFlag() {
        while(!flag){
        }
        System.out.println("Reader Thread: Flag is true, exiting loop.");
        return flag;
    }
}

public class volatileExample {
    static void main() {
        SharedResource sharedResource = new SharedResource();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedResource.setFlag(true);
        });

        Thread readerThread = new Thread(() -> {
                System.out.println("Reader Thread: Flag value is " + sharedResource.getFlag());
        });

        writerThread.start();
        readerThread.start();
    }
}
