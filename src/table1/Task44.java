package table1;

public class Task44 {
    public static int findMaxAbsAtIndexMultipleOf7(int[] array) {
        // Перевірка аргументу
        if (array == null) {
            throw new NullPointerException("Масив не може бути null.");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім.");
        }

        // Індекс 0 кратний 7, тому беремо перший елемент як початкове значення
        int maxElement = array[0];

        // Цикл for з лічильником
        for (int i = 0; i < array.length; i++) {

            // Перевірка, чи індекс кратний 7
            if (i % 7 == 0) {

                // Порівняння модулів 
                if (Math.abs(array[i]) > Math.abs(maxElement)) {
                    maxElement = array[i];
                }
            }
        }

        return maxElement;
    }

    // Точка входу в програму
    public static void main(String[] args) {

        System.out.println("=== Тест 1: дозволена комбінація ===");

        int[] array1 = { 3, 1, 2, 3, 4, 5, 6, -9, 8, 9, 1, 2, 3, 4, 5, 6, 7 };

        try {
            int result = findMaxAbsAtIndexMultipleOf7(array1);

            System.out.println("Масив: {3, 1, 2, 3, 4, 5, 6, -9, 8, 9, 1, 2, 3, 4, 5, 6, 7}");
            System.out.println("Результат: " + result);

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Тест 2: заборонена комбінація (порожній масив) ===");

        int[] array2 = {};

        try {
            int result = findMaxAbsAtIndexMultipleOf7(array2);

            System.out.println("Результат: " + result);

        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
    }
}