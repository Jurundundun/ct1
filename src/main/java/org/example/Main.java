package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class Main extends JFrame {
    public static void main(String[] args) {
        double a0 = -1.3;
        double b0 = 1;
        double E = 1e-05;
        double[] e = new double[] {0.01, 0.001, 0.0001, 0.00001};
        double[] cnt = new double[e.length];
        int i = 0;
        double x ,n;
        double[] buffer;
        for (;i < e.length;i++){
            buffer = Functions.dichotomyOne(a0, b0, e[i]);
            x = buffer[0];
            n = buffer[1];
            cnt[i] = n;
        }
        System.out.println("enumeration" + Arrays.toString(Functions.enumeration(a0, b0, E)));
        System.out.println("bitByBitSearch" + Arrays.toString(Functions.bitByBitSearch(a0, b0, E)));
        System.out.println("dichotomyOne" + Arrays.toString(Functions.dichotomyOne(a0, b0, E)));
        System.out.println("dichotomyTwo" + Arrays.toString(Functions.dichotomyTwo(a0, b0, E)));
        System.out.println("goldenRatio" + Arrays.toString(Functions.goldenRatio(a0, b0, E)));
        System.out.println("fibonacci" + Arrays.toString(Functions.fibonacci(a0, b0, E)));
        System.out.println("parabolaMethod" + Arrays.toString(Functions.parabolaMethod(a0, b0, E)));
        EventQueue.invokeLater(() -> {

            DrawGraphs ex = new DrawGraphs("Function",e,cnt);
            ex.setVisible(true);
        });

    }
}