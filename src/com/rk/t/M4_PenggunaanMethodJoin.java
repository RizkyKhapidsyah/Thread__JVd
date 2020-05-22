package com.rk.t;

public class M4_PenggunaanMethodJoin implements Runnable {

    Thread T;

    M4_PenggunaanMethodJoin(String N) {
        T = new Thread(this, N);
        T.start();
    }

    public void run() {
        String name = T.getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }
}

class TestingThread {
    public static void main(String args[]) {
        M4_PenggunaanMethodJoin pnt1 = new M4_PenggunaanMethodJoin("A");
        M4_PenggunaanMethodJoin pnt2 = new M4_PenggunaanMethodJoin("B");
        M4_PenggunaanMethodJoin pnt3 = new M4_PenggunaanMethodJoin("C");
        M4_PenggunaanMethodJoin pnt4 = new M4_PenggunaanMethodJoin("D");
        System.out.println("Running threads...");

        try {
            pnt1.T.join();
            pnt2.T.join();
            pnt3.T.join();
            pnt4.T.join();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }

        System.out.println("Threads killed."); //dicetak terakhir
    }
}