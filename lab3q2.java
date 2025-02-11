
package com.mycompany.lab3q2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lab3q2{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // المصفوفة الأصلية
        removeRandomEntries(array);
    }

    public static void removeRandomEntries(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num); // تحويل المصفوفة إلى قائمة قابلة للتعديل
        }

        Random rand = new Random();
        while (!list.isEmpty()) {
            int randomIndex = rand.nextInt(list.size()); // اختيار فهرس عشوائي
            int removedElement = list.remove(randomIndex); // إزالة العنصر العشوائي
            System.out.println("Removed: " + removedElement);
        }
        System.out.println("All elements have been removed.");
    }
}

