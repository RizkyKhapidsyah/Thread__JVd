package com.rk.t;

import javax.naming.Name;

public class M3_ImplementasiInterfaceRunnable implements Runnable {

    Thread T;

    M3_ImplementasiInterfaceRunnable(String Nama) {
        T = new Thread(this, Nama);
        T.start();
    }

    @Override
    public void run() {
        String N = T.getName();

        for (int i = 0; i < 100; i++) {
            System.out.print(N);
        }
    }
}

class TestThread{
    public static void main(String[] args) {
        new M3_ImplementasiInterfaceRunnable("A");
        new M3_ImplementasiInterfaceRunnable("B");
        new M3_ImplementasiInterfaceRunnable("C");
        new M3_ImplementasiInterfaceRunnable("D");
    }
}
