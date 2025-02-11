/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q13;

public class lab3q13 {
    public static int[][][] add3DArrays(int[][][] A, int[][][] B) {
        // التحقق من أن المصفوفات لها نفس الأبعاد
        if (A.length != B.length || A[0].length != B[0].length || A[0][0].length != B[0][0].length) {
            throw new IllegalArgumentException("المصفوفات ليست بنفس الأبعاد!");
        }

        int x = A.length;
        int y = A[0].length;
        int z = A[0][0].length;

        int[][][] result = new int[x][y][z]; // مصفوفة ناتجة بنفس الأبعاد

        // جمع كل عنصر مع العنصر المقابل له في المصفوفة الثانية
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result[i][j][k] = A[i][j][k] + B[i][j][k];
                }
            }
        }

        return result;
    }

    // دالة لطباعة المصفوفة ثلاثية الأبعاد
    public static void print3DArray(int[][][] array) {
        for (int[][] matrix : array) {
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println("--------------");
        }
    }

    public static void main(String[] args) {
        // إنشاء مصفوفتين ثلاثية الأبعاد
        int[][][] A = {
            {{1, 2}, {3, 4}},
            {{5, 6}, {7, 8}}
        };

        int[][][] B = {
            {{9, 8}, {7, 6}},
            {{5, 4}, {3, 2}}
        };

        System.out.println("المصفوفة A:");
        print3DArray(A);

        System.out.println("المصفوفة B:");
        print3DArray(B);

        // جمع المصفوفتين
        int[][][] result = add3DArrays(A, B);

        System.out.println("المصفوفة الناتجة A + B:");
        print3DArray(result);
    }
}
