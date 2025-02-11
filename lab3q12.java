/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q12;
import java.util.*;

public class lab3q12 {
    private int n; // عدد اللاعبين
    private Map<Integer, Set<Integer>> meetings; // تخزين الاجتماعات لكل لاعب
    private int winner = -1; // الفائز (عندما يصبح ≠ -1)

    public lab3q12(int n) {
        this.n = n;
        this.meetings = new HashMap<>();
        // تهيئة المصفوفة بحيث يكون لكل لاعب مجموعة فارغة من اللقاءات
        for (int i = 1; i <= n; i++) {
            meetings.put(i, new HashSet<>());
        }
    }

    public void meet(int i, int j) {
        if (i == j) return; // اللاعب لا يلتقي بنفسه
        
        // تسجيل اللقاء
        meetings.get(i).add(j);
        meetings.get(j).add(i);

        // التحقق إن كان أحدهما فاز
        if (winner == -1) { // فقط نبحث عن الفائز إذا لم يتم تحديده بعد
            if (meetings.get(i).size() == n - 1) {
                winner = i;
                System.out.println("اللاعب " + i + " هو الفائز!");
            } else if (meetings.get(j).size() == n - 1) {
                winner = j;
                System.out.println("اللاعب " + j + " هو الفائز!");
            }
        }
    }

    public int getWinner() {
        return winner;
    }

    public static void main(String[] args) {
        lab3q12 game = new lab3q12(1000);

        // محاكاة بعض الاجتماعات العشوائية
        game.meet(1, 2);
        game.meet(1, 3);
        game.meet(2, 3);
        game.meet(1, 500);
        game.meet(1, 999);

        // (يتم استدعاء meet() داخل نظام اللعبة بشكل متكرر)
    }
}
