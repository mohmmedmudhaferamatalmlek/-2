
package com.mycompany.lab3q4;
public class lab3q4 {
    private static final int X = 1, O = -1, EMPTY = 0;
    private int[][] board = new int[3][3]; // مصفوفة 3×3 تمثل اللوحة
    private int currentPlayer = X; // يبدأ اللاعب X
    private int winner = EMPTY; // حالة الفائز (لم يفز أحد في البداية)
    private int moves = 0; // عدد الحركات التي تمت

    public void putMark(int row, int col) {
        if (winner != EMPTY) {
            throw new IllegalStateException("اللعبة انتهت بالفعل، لا يمكنك اللعب بعد الفوز!");
        }
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("إحداثيات غير صالحة! يجب أن تكون بين 0 و 2.");
        }
        if (board[row][col] != EMPTY) {
            throw new IllegalArgumentException("هذه الخانة مشغولة بالفعل!");
        }

        board[row][col] = currentPlayer; // ضع العلامة في الخانة
        moves++; // زيادة عدد الحركات
        
        // التحقق من الفوز بعد كل حركة
        if (checkWin(row, col)) {
            winner = currentPlayer; // تحديد الفائز
        } else if (moves == 9) {
            winner = 0; // تعادل
        }

        currentPlayer = -currentPlayer; // تبديل الدور
    }

    private boolean checkWin(int row, int col) {
        // التحقق من الصف
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }
        // التحقق من العمود
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true;
        }
        // التحقق من القطر الرئيسي
        if (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        // التحقق من القطر الثانوي
        if (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public int getWinner() {
        return winner;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char symbol = (board[i][j] == X) ? 'X' : (board[i][j] == O) ? 'O' : '-';
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        lab3q4 game = new lab3q4();

        try {
            game.putMark(0, 0);
            game.putMark(1, 1);
            game.putMark(0, 1);
            game.putMark(2, 2);
            game.putMark(0, 2); // اللاعب X يفوز هنا
            game.printBoard();
            System.out.println("الفائز: " + (game.getWinner() == 1 ? "X" : game.getWinner() == -1 ? "O" : "تعادل"));

            // محاولة لعب حركة بعد الفوز
            game.putMark(2, 0); // سيؤدي إلى IllegalStateException
        } catch (Exception e) {
            System.out.println("خطأ: " + e.getMessage());
        }
    }
}
