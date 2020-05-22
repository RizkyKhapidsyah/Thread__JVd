package com.rk.t;

import javax.swing.*;
import java.awt.*;

public class M1_CounterDown extends JFrame {

    JLabel L;

    M1_CounterDown(String Judul) {
        super(Judul);
        L = new JLabel("Mulai Hitung!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new Panel(), BorderLayout.WEST);
        getContentPane().add(L);
        setSize(300, 300);
        setVisible(true);
    }

    void MulaiCounter() {
        try {
            for (int i = 10; i > 0; i++) {
                Thread.sleep(1000);
                L.setText(1 + "");
            }

            Thread.sleep(1000);
            L.setText("Hitungan Mundur Selesai!");
            Thread.sleep(1000);

        } catch (InterruptedException IE) {
            System.out.println(IE);
        }

        L.setText(Thread.currentThread().toString());
    }

    public static void main(String[] args) {
        M1_CounterDown CD = new M1_CounterDown("Count Down GUI");
        CD.MulaiCounter();
    }

}
