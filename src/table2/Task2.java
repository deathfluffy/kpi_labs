package table2;

import java.util.Arrays;

public class Task2 {
    public static void lolSwap(int[][] matrix) {

        if (matrix == null) {
            throw new NullPointerException("Матриця не може бути null.");
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою.");
        }

        int[] temp = matrix[0];
        matrix[0] = matrix[matrix.length - 1];
        matrix[matrix.length - 1] = temp;
    }

    public static void main(String[] args) {

        System.out.println("=== Тест 1: дозволена комбінація (квадратна матриця) ===");

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        try {
            System.out.println("До:    " + Arrays.deepToString(matrix1));
            lolSwap(matrix1);
            System.out.println("Після: " + Arrays.deepToString(matrix1));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }


        System.out.println();
        System.out.println("=== Тест 2: дозволена комбінація (один рядок) ===");

        int[][] matrix2 = {
                {1, 2, 3}
        };

        try {
            System.out.println("До:    " + Arrays.deepToString(matrix2));
            lolSwap(matrix2);
            System.out.println("Після: " + Arrays.deepToString(matrix2));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}