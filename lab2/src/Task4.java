public class Task4 {

    public static double calculate(double a, double b, int k) {

        // Перевірка параметра a
        if (a < 0) {
            throw new IllegalArgumentException(
                    "Параметр a не може бути від'ємним."
            );
        }

        // Перевірка параметра b
        if (b < 0) {
            throw new IllegalArgumentException(
                    "Параметр b не може бути від'ємним."
            );
        }

        // Перевірка параметра k
        if (k < 1 || k > 30) {
            throw new IllegalArgumentException(
                    "Параметр k повинен бути в межах від 1 до 30."
            );
        }

        return k * Math.sqrt(a * b);
    }

    public static void main(String[] args) {

        try {
            double result = calculate(4, 9, 5);
            System.out.println("a=4, b=9, k=5 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            double result = calculate(2.5, 4, 30);
            System.out.println("a=2.5, b=4, k=30 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            double result = calculate(0, 10, 3);
            System.out.println("a=0, b=10, k=3 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            double result = calculate(-4, 9, 5);
            System.out.println("a=-4, b=9, k=5 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Заборонений випадок a=-4: "
                    + e.getMessage());
        }

        try {
            double result = calculate(4, -9, 5);
            System.out.println("a=4, b=-9, k=5 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Заборонений випадок b=-9: "
                    + e.getMessage());
        }

        try {
            double result = calculate(4, 9, 31);
            System.out.println("a=4, b=9, k=31 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Заборонений випадок k=31: "
                    + e.getMessage());
        }
    }
}