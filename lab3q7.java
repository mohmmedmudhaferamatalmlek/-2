/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3q7;

public class lab3q7 {
    private GameEntry[] board;
    private int size; // عدد الإدخالات الحالية

    public lab3q7(int capacity) {
        board = new GameEntry[capacity];
        size = 0; // نبدأ بدون أي إدخالات
    }

    // إضافة إدخال جديد بدون ترتيب
    public void add(GameEntry e) {
        if (size < board.length) {
            board[size] = e; // نُضيف في الموضع المتاح
            size++; // نُحدّث الحجم
        }
    }

    // إزالة الإدخال عند الفهرس i بدون إعادة ترتيب
    public void remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("الفهرس غير صالح");
        }
        board[i] = board[size - 1]; // استبدال العنصر المحذوف بآخر عنصر
        board[size - 1] = null; // مسح آخر موضع
        size--; // تقليل العدد
    }

    // طباعة القائمة
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println(board[i]);
        }
    }

    public static void main(String[] args) {
        lab3q7 scoreboard = new lab3q7(5);
        scoreboard.add(new GameEntry("Alice", 50));
        scoreboard.add(new GameEntry("Bob", 40));
        scoreboard.add(new GameEntry("Charlie", 60));

        System.out.println("قبل الحذف:");
        scoreboard.printBoard();

        scoreboard.remove(1); // حذف العنصر في الفهرس 1

        System.out.println("بعد الحذف:");
        scoreboard.printBoard();
    }
}

// فئة GameEntry لتخزين الأسماء والنتائج
class GameEntry {
    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}
