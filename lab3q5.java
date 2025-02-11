
package com.mycompany.lab3q5;
import java.util.HashSet;
import java.util.Set;

public class lab3q5 {
    public static int findDuplicate(int[] A) {
        Set<Integer> seen = new HashSet<>();

        for (int num : A) {
            if (seen.contains(num)) {
                return num; // العدد المكرر
            }
            seen.add(num);
        }

        return -1; // في حالة لم يكن هناك تكرار (لكن نظريًا لا يحدث ذلك وفقًا للفرضية)
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 2, 5, 3}; // الرقم 3 مكرر
        System.out.println("العنصر المكرر هو: " + findDuplicate(A));
    }
}

