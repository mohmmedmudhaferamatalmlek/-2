/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q11;
import java.util.Random;

public class lab3q11 {
    public static void shuffle(int[] A) {
        Random r = new Random();
        for (int i = A.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1); // اختيار فهرس عشوائي بين 0 و i
            // تبديل A[i] مع A[j]
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("قبل التبديل العشوائي:");
        printArray(A);

        shuffle(A);

        System.out.println("بعد التبديل العشوائي:");
        printArray(A);
    }

    public static void printArray(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
