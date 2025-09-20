package com.example.test.LR1;

import java.util.Scanner;

import java.util.Scanner;//0

public class Program1 {//1

    static int sum(int[] x, int N) {//2
        int s = 0;//3
        for (int i = 0; i < N; i++) {//4
            s += x[i];//5
        }//6
        return s;//7
    }//8

    static int ReadInt(String prompt) {//9
        System.out.print(prompt);//10
        Scanner scanner = new Scanner(System.in);//11
        int x = scanner.nextInt();//12
        return x;//13
    }//14

    public static void main(String[] args) {//15
        final int N = 10;//16
        int[] a = {1, 3, -5, 0, 4, 6, -1, 9, 3, 2};//17

        int m = a[0];//18
        for (int i = 1; i < N; i++) {//19
            if (m < a[i]) {//20
                m = a[i];//21
            }//22
        }//23
        System.out.println(m);//24

        int s;//25
        s = sum(a, N);//26
        System.out.println(s);//27

        int z = s / m;//28
        int k = 0;//29
        for (int i = 0; i < N; i++) {//30
            if (a[i] > z) {//31
                k += a[i];//32
            } else {//33
                k -= a[i];//34
            }//35
        }//36
        System.out.println(k);//37

        int x, y;//38
        x = ReadInt("");//39
        y = ReadInt("");//40
        s = 0;//41

        while ((x != 0) && (y != 0)) {//42
            x--;//43
            y--;//44
            s += x + y;//45
        }//46
        System.out.println(s);//47
    }//48
}//49