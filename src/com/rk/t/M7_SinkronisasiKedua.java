package com.rk.t;

public class M7_SinkronisasiKedua {
    static void print(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println(str2);
    }
}

class PrintStringsThreadss implements Runnable {
    Thread thread;
    String str1, str2;
    M7_SinkronisasiKedua ts;

    PrintStringsThreadss(String str1, String str2, M7_SinkronisasiKedua ts) {
        this.str1 = str1;
        this.str2 = str2;
        this.ts = ts;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        synchronized (ts) {
            ts.print(str1, str2);
        }
    }
}

class TestThreads {
    public static void main(String args[]) {
        M7_SinkronisasiKedua ts = new M7_SinkronisasiKedua();
        new PrintStringsThreadss("Hello ", "there.", ts);
        new PrintStringsThreadss("How are ", "you?", ts);
        new PrintStringsThreadss("Thank you ", "very much!", ts);
    }
}