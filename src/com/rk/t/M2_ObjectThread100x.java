package com.rk.t;

public class M2_ObjectThread100x extends Thread {

    M2_ObjectThread100x(String Nama) {
        super(Nama);
        start();
    }

    @Override
    public void run() {
        String Nama = getName();

        for (int i = 0; i < 100; i++) {
            System.out.print(Nama);
        }
    }
}

class TesThread {
    public static void main(String[] args) {
        M2_ObjectThread100x pnt1 = new M2_ObjectThread100x("A");
        M2_ObjectThread100x pnt2 = new M2_ObjectThread100x("B");
        M2_ObjectThread100x pnt3 = new M2_ObjectThread100x("C");
        M2_ObjectThread100x pnt4 = new M2_ObjectThread100x("D");
    }
}

