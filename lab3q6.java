/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q6;

import java.util.*;

public class lab3q6 {
    public static List<Integer> findDuplicates(int[] B) {
        Set<Integer> seen = new HashSet<>(); // مجموعة للعناصر الفريدة
        List<Integer> duplicates = new ArrayList<>(); // قائمة لتخزين العناصر المكررة

        for (int num : B) {
            if (seen.contains(num)) {
                if (!duplicates.contains(num)) { // تجنب إضافة نفس الرقم المكرر أكثر من مرة
                    duplicates.add(num);
                }
            } else {
                seen.add(num);
            }
            if (duplicates.size() == 5) { // بمجرد العثور على 5 أرقام مكررة، نتوقف
                break;
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] B = {1, 2, 3, 4, 5, 6, 3, 7, 8, 9, 2, 10, 4, 11, 5, 12, 6}; // 5 أرقام مكررة: {3, 2, 4, 5, 6}
        List<Integer> result = findDuplicates(B);
        System.out.println("الأعداد المكررة هي: " + result);
    }
}
