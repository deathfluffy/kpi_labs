package table2;
public class Task10{
    public static boolean isUnbalanced(int[][] results) {

        // Перевірка аргументу
        if (results == null) {
            throw new NullPointerException("Таблиця не може бути null.");
        }

        if (results.length == 0) {
            throw new IllegalArgumentException("Таблиця не може бути порожньою.");
        }

        int n = results.length;

        for (int i = 0; i < n; i++) {

            if (results[i] == null) {
                throw new NullPointerException("Рядок " + i + " не може бути null.");
            }

            if (results[i].length != n) {
                throw new IllegalArgumentException("Матриця має бути квадратною.");
            }

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (results[i][j] != 0) {
                        throw new IllegalArgumentException(
                                "Елементи головної діагоналі мають дорівнювати 0.");
                    }
                } else {
                    if (results[i][j] < 0 || results[i][j] > 2) {
                        throw new IllegalArgumentException(
                                "Недопустиме значення: " + results[i][j]
                                        + ". Дозволено лише 0, 1 або 2.");
                    }
                }
            }
        }
        for (int[] row : results) {

            int wins = 0;

            for (int points : row) {
                if (points == 2) {
                    wins++;
                }
            }
            if (wins > (n - 1) / 2.0) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        System.out.println("=== Тест 1: дозволена комбінація (є команда, що виграла більше половини) ===");

        int[][] table1 = {
                {0, 2, 2, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {2, 1, 2, 0}
        };

        try {
            System.out.println("Результат: " + isUnbalanced(table1));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }


        System.out.println();
        System.out.println("=== Тест 2: заборонена комбінація (ненульова діагональ) ===");

        int[][] table2 = {
                {1, 2},
                {0, 0}
        };

        try {
            System.out.println("Результат: " + isUnbalanced(table2));

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }

    }
}