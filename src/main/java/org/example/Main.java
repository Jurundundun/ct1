package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {
    public static void main(String[] args) {

        final double a0 = -1.3;
        double b0 = 1;
        double E = 0.001;
        double[] e = new double[] {0.1,0.01,0.001, 0.0001,0.00001};
        double[] eo = new double[] {-Math.log(0.1),-Math.log(0.01), -Math.log(0.001), -Math.log(0.0001), -Math.log(0.00001)};
        double[] cnt = new double[e.length];

        EventQueue.invokeLater(() -> {
            int i = 0;
            double[] buffer;
            double n;
            for (;i < e.length;i++){
                buffer = Functions.bitByBitSearch(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int) n;
            }
            DrawGraphs ex = new DrawGraphs("График");

            ex.updateDataset("Поразрядный поиск", eo,cnt);

            for (i = 0; i < e.length;i++){
                buffer = Functions.dichotomyOne(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int)n;
            }
            System.out.println(Arrays.toString(cnt));
            ex.updateDataset("Дихотомия1", eo,cnt);
            ex.initUI();

            for (i = 0; i < e.length;i++){
                buffer = Functions.dichotomyTwo(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int)n;
            }
            System.out.println(Arrays.toString(cnt));
            ex.updateDataset("Дихотомия2", eo,cnt);
            ex.initUI();

            for (i = 0; i < e.length;i++){
                buffer = Functions.goldenRatio(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int)n;
            }
            System.out.println(Arrays.toString(cnt));
            ex.updateDataset("Золотое сечение", eo,cnt);
            ex.initUI();


            for (i = 0; i < e.length;i++){
                buffer = Functions.fibonacci(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int)n;
            }
            System.out.println(Arrays.toString(cnt));
            ex.updateDataset("Фибоначчи", eo,cnt);
            ex.initUI();

            for (i = 0; i < e.length;i++){
                buffer = Functions.parabolaMethod(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int)n;
            }
            System.out.println(Arrays.toString(cnt));
            ex.updateDataset("Метод парабол", eo,cnt);
            ex.initUI();

            ex.setVisible(true);
        });

        EventQueue.invokeLater(() -> {
            int i = 0;
            double[] buffer;
            double n;
            for (;i < e.length;i++){
                buffer = Functions.enumeration(a0, b0, e[i]);
                n = buffer[2];
                cnt[i] = (int) n;
            }
            DrawGraphs ex = new DrawGraphs("График 2");

            ex.updateDataset("Перебор", eo,cnt);

            ex.initUI();

            ex.setVisible(true);
        });




        double[] buffer;

        buffer = Functions.enumeration(a0, b0, E);
        System.out.printf("Перебор: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.bitByBitSearch(a0, b0, E);
        System.out.printf("Поразрядный поиск: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.dichotomyOne(a0, b0, E);
        System.out.printf("Дихотомия1: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.dichotomyTwo(a0, b0, E);
        System.out.printf("Дихотомия2: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.goldenRatio(a0, b0, E);
        System.out.printf("Золотое сечение: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.fibonacci(a0, b0, E);
        System.out.printf("Фибоначчи: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);

        buffer = Functions.parabolaMethod(a0, b0, E);
        System.out.printf("Метод парабол: X* = %f, Ymin = %f, n = %d\n", buffer[0], buffer[1],(int)buffer[2]);


    }
}