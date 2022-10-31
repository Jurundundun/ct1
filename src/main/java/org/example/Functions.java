package org.example;

public class Functions {
    private static double funcOne(double x){
        double rez = 0;
        if (x <= 1) {
            rez = x * x;
        }
        else {
            rez = 2 * x - 1;
        }
        return rez;

    }
    private static double funcTwo(double x) {
        return Math.pow(x,6);
    }


// метод перебора

    public static double[] enumeration(double a0, double b0, double E) {
        double min = funcOne(a0);
        double n = Math.ceil((b0 - a0) / E);
        double N = n + 1;
        double[] result ;
        double x,c = 0;
        int i = 0;
        for(;i < n;i++) {
            x = a0 + i * (b0 - a0) / n;
            c = funcOne(x);
            if (c < min) {
                min = c;
            }
        }
        result = new double[] {min,N};
        return result;
    }

//Метод поразрядного поиска


    public static double[] bitByBitSearch(double a0, double b0, double E) {
        double L = 0.1;
        double d = L * (b0 - a0);
        double n = Math.ceil((Math.log(d / E) / (Math.log(1 / L)) + 1));
        double x0,x1;
        double[] result;
        int k;
        int border = 1;
        int i = 0;
        for(;i<Math.ceil(n/2);i++) {
            if (border == 1) {
                x0 = a0;
                x1 = funcOne(a0 + d);
                k = 1;
                while (funcOne(x0) > funcOne(x1)) {
                    k += 1;
                    x0 = x1;
                    x1 = funcOne(a0 + k * d);
                }

                a0 = x0;
                b0 = x1;
                //L = d * L
                d = d * L;
                border = 0;
            }
            else {
                x0 = b0;
                x1 = funcOne(b0 - d);

                k = 1;
                while (funcOne(x0) > funcOne(x1)) {
                    k += 1;
                    x0 = x1;
                    x1 = funcOne(a0 - k * d);
                }

                a0 = x1;
                b0 = x0;
                //L = d * L
                d = L * d;
                border = 1;
            }
        }
        result = new double[] {a0,n};
        return result;
    }


    public static double[] dichotomyOne(double a0, double b0, double E) {
        double q = 1.5 * E;
        double n = Math.ceil(Math.log((b0 - a0 - q) / (2 * E - q))/Math.log(2));
        double N = 2 * n;
        double[] result;
        double x1,x2,min;
        int i = 0;
        for(;i < n;i++) {
            x1 = (a0 + b0 - q) / 2;
            x2 = (a0 + b0 + q) / 2;
            if (funcOne(x1) <= funcOne(x2)) {
                b0 = x2;
            }
            else {
                a0 = x1;
            }
        }

        min = (a0 + b0) / 2;
        result = new double[] {a0,N};
        return result;
    }


    public static double[] dichotomyTwo(double a0, double b0, double E) {
        double n = Math.ceil(Math.log((b0 - a0) / (2 * E))/Math.log(2));
        double N = 2 * n + 1;
        //while (b0 - a0) > E
        double x2 = a0 + (b0 - a0) / 2;
        double x1,x3;
        double[] result;
        int i = 0;
        for (;i < n;i++) {
            x1 = a0 + (b0 - a0) / 4;
            x3 = a0 + 3 * (b0 - a0) / 4;
            if (funcOne(x1) <= funcOne(x2)) {
                b0 = x2;
                x2 = x1;
            }
            else if (funcOne(x2) <= funcOne(x3)) {
                a0 = x1;
                b0 = x3;
            }
            else if (funcOne(x2) > funcOne(x3)) {
                a0 = x2;
                x2 = x3;
            }
        }
        result = new double[] {x2,N};
        return result;
    }


    public static double[] goldenRatio(double a0, double b0, double E) {
        double Fi = (Math.pow(5,0.5) - 1) /2;
        double F = 1 / Fi;
        double n = Math.ceil(Math.log((b0 - a0) / (2 * E)) / Math.log(F));
        double N = n + 1;
        double x1 = a0 + (b0 - a0) * (1 - Fi);
        double x2 = a0 + (b0 - a0) * Fi;
        double[] result;
        int i = 0;
        for (;i < n;i++) {
            if (funcOne(x1) <= funcOne(x2)) {
                b0 = x2;
                x2 = x1;
                x1 = a0 + b0 - x1;
            }
            else if (funcOne(x1) > funcOne(x2)) {

                a0 = x1;
                x1 = x2;
                x2 = a0 + b0 - x2;
            }
        }
        result = new double[] {(a0+b0) / 2, N};
        return result;
    }


    public static double[] fibonacci(double a0, double b0, double E) {
        double F = (Math.pow(5,0.5) + 1) / 2;
        double n = Math.ceil(Math.log(((b0 - a0) * Math.pow (5,0.5)) / E) / Math.log(F)) - 3;
        double f = (Math.pow(5,0.5) - 1) /2;
        double N = n + 1;
        double x1 = a0 + (1 - f) * (b0 - a0);
        double x2 = a0 + (f) * (b0 - a0);
        double[] result;
        int i = 0;

        for (;i < n;i++) {
            if (funcOne(x1) <= funcOne(x2)) {
                b0 = x2;
                x2 = x1;
                x1 = a0 + b0 - x2;
            }
            else {
                a0 = x1;
                x1 = x2;
                x2 = a0 + b0 - x1;
            }
        }
        result = new double[] {(a0 + b0) / 2, N};
        return result;
    }


    public static double[] parabolaMethod(double a0, double b0, double eps) {

        double x1 = a0;
        double x2 = (a0 + b0) / 2;
        double x3 = b0;
        double x;
        double N = 0;
        double[] result;

        while (funcOne(x1) <= funcOne(x2) && funcOne(x2) >= funcOne(x3)) {
            x2 = (a0 + x2) / 2;
            N += 3;
        }

        x = (x1 + x2) / 2 - (x3 - x2) / 2 * (
                (funcOne(x3) - funcOne(x1)) * (x2 - x1) / (x3 - x1) / Math.pow ((funcOne(x2) - funcOne(x1)),-1));

        while (Math.abs(x3 - x1) > eps) {
            x = (x1 + x2) / 2 - (x3 - x2) / 2 * (
                    Math.pow(((funcOne(x3) - funcOne(x1)) * (x2 - x1) / (x3 - x1) / (funcOne(x2) - funcOne(x1)) - 1) ,-1));
            N += 3;
            if (funcOne(x) < funcOne(x2)) {
                if (x > x2) {
                    x1 = x2;
                    x2 = x;
                }
                else{
                    x3 = x2;
                    x2 = x;
                }
            }
            else{
                if (x < x2) {
                    x1 = x;
                }
                else {
                    x3 = x;
                }
            }
        }
        result = new double[] {x,N};
        return result;
    }
}
