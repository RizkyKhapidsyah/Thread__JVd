package com.rk.t;

public class M6_SinkronisasiPertama {
    synchronized static void print(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println(str2);
    }
}

class PrintStringsThreads implements Runnable {
    Thread thread;
    String str1, str2;

    PrintStringsThreads(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        M6_SinkronisasiPertama.print(str1, str2);
    }
}

class TestingggThread {
    public static void main(String args[]) {
        new PrintStringsThread("Hello ", "there.");
        new PrintStringsThread("How are ", "you?");
        new PrintStringsThread("Thank you ", "very much!");
    }
}