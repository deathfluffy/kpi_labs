package table1;

public class Task14 {
    public static int findAbsArray(int[] array) {

        // Перевірка аргументу
        if (array == null) {
            throw new IllegalArgumentException("Масив не може бути null.");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        int maxNegative = 0;
        int minEven = 0;

        boolean hasNegative = false;
        boolean hasEven = false;

        for (int x : array) {

            // Пошук найбільшого від'ємного елемента
            if (x < 0) {
                if (!hasNegative || x > maxNegative) {
                    maxNegative = x;
                    hasNegative = true;
                }
            }

            // Пошук найменшого парного елемента
            if (x % 2 == 0) {
                if (!hasEven || x < minEven) {
                    minEven = x;
                    hasEven = true;
                }
            }
        }

        // Якщо від'ємних елементів немає
        if (!hasNegative) {
            throw new IllegalArgumentException(
                    "У масиві немає від'ємних елементів."
            );
        }

        // Якщо парних елементів немає
        if (!hasEven) {
            throw new IllegalArgumentException(
                    "У масиві немає парних елементів."
            );
        }

        return Math.abs(maxNegative) * Math.abs(minEven);
    }


    public static void main(String[] args) {

        System.out.println("=== Тест 1: дозволена комбінація ===");

        int[] array1 = {-8, 5, -3, 10, -6, 4, -1};

        try {
            int result = findAbsArray(array1);

            System.out.println("Масив: {-8, 5, -3, 10, -6, 4, -1}");
            System.out.println("Результат: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Тест 2: заборонена комбінація ===");

        int[] array2 = {1, 3, 5, 7, 9};

        try {
            int result = findAbsArray(array2);

            System.out.println("Результат: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Масив: {1, 3, 5, 7, 9}");
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
    }
}