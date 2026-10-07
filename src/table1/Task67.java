package table1;
import java.util.Arrays;

public class Task67 {

    // Метод реалізує основне завдання
    public static int[] createArray(int[] a, int[] b) {

        if (a == null) {
            throw new IllegalArgumentException(
                    "Масив A не може бути null."
            );
        }

        if (b == null) {
            throw new IllegalArgumentException(
                    "Масив B не може бути null."
            );
        }

        if (a.length != b.length) {
            throw new IllegalArgumentException(
                    "Масиви A та B повинні мати однакову кількість елементів."
            );
        }

        if (a.length == 0) {
            throw new IllegalArgumentException(
                    "Масиви A та B не можуть бути порожніми."
            );
        }

        int[] c = new int[a.length * 2];
        int i = 0;

        for (int elementA : a) {

            c[2 * i] = elementA;

            c[2 * i + 1] = b[i];

            i++;
        }

        return c;
    }


    public static void main(String[] args) {
        System.out.println("=== Тест 1: дозволена комбінація ===");

        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {10, 20, 30, 40};

        try {
            int[] result1 = createArray(a1, b1);

            System.out.println("A = " + Arrays.toString(a1));
            System.out.println("B = " + Arrays.toString(b1));
            System.out.println("C = " + Arrays.toString(result1));

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Тест 2: заборонена комбінація ===");

        int[] a2 = {};
        int[] b2 = {};

        try {
            int[] result2 = createArray(a2, b2);

            System.out.println("C = " + Arrays.toString(result2));

        } catch (IllegalArgumentException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
        System.out.println();
        System.out.println("=== Тест 3: заборонена комбінація ===");

        int[] a3 = {1, 2, 3};
        int[] b3 = null;

        try {
            int[] result3 = createArray(a3, b3);

            System.out.println("C = " + Arrays.toString(result3));

        } catch (IllegalArgumentException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }

    }
}