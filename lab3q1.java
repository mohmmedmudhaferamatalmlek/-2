
package com.mycompany.lab3q1;
public class lab3q1 {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;
        int n = 100;
        int cur = 92; // Seed

        // طباعة الأعداد العشوائية الخمسة التالية
        for (int i = 0; i < 5; i++) {
            cur = (a * cur + b) % n;
            System.out.println(cur);
        }
    }
}


