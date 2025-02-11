/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q8;
public class lab3q8 {
    private int a, b, n;
    private int current;

    public lab3q8(int a, int b, int n, int seed) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.current = seed;
    }

    public int next() {
        current = (a * current + b) % n;
        return current;
    }

    public static void main(String[] args) {
        int n = 1000;
        
        // أمثلة على قيم غير عشوائية
        int[][] badCases = {
            {0, 5},     // جميع القيم ستكون 5
            {1, 1},     // أرقام خطية: 1, 2, 3, 4, ...
            {1000, 0},  // دائمًا 0
            {500, 500}  // دورة صغيرة جدًا
        };

        for (int[] badCase : badCases) {
            System.out.println("تجربة مع a = " + badCase[0] + ", b = " + badCase[1]);
            lab3q8 generator = new lab3q8(badCase[0], badCase[1], n, 1);
            for (int i = 0; i < 10; i++) {
                System.out.print(generator.next() + " ");
            }
            System.out.println("\n--------------------------");
        }
    }
}

