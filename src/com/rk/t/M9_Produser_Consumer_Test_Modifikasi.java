package com.rk.t;

public class M9_Produser_Consumer_Test_Modifikasi {

}

class SharedData2 {
    int data;
    boolean valueSet = false;

    synchronized void set(int value) {
        if (valueSet) { //baru saja membangkitkan sebuah nilai
            try {
                wait();
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
        System.out.println("Generate " + value);
        data = value;
        valueSet = true;
        notify();
    }

    synchronized int get() {
        if (!valueSet) { //produsen belum men-set sebuah nilai
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }
        System.out.println("Get " + data);
        valueSet = false;
        notify();
        return data;
    }
}

/* Bagian kode ini tidak ada yang berubah*/
class Producer2 implements Runnable {
    SharedData2 sd;

    Producer2(SharedData2 sd) {
        this.sd = sd;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.set((int) (Math.random() * 100));
        }
    }
}

class Consumer2 implements Runnable {
    SharedData2 sd;

    Consumer2(SharedData2 sd) {
        this.sd = sd;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.get();
        }
    }
}

class TestProducerConsumer2 {
    public static void main(String args[]) throws Exception {
        SharedData2 sd = new SharedData2();
        new Producer2(sd);
        new Consumer2(sd);
    }
}