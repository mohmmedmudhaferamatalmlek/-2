/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q10;
public class lab3q10 {
    public static void main(String[] args) {
        int n = 100; // عدد الأرقام في المصفوفة
        double p_nonZero = 9.0 / 10.0; // احتمال أن يكون الرقم ≠ 0
        double probability_x_is_zero = 1 - Math.pow(p_nonZero, n); // P(x = 0)

        System.out.println("احتمال أن يكون x = 0 هو: " + probability_x_is_zero);
    }
}
