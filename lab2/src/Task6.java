public class Task6 {

    public static double calculate(double t, int i) {

        if (i < 1) {
            throw new IllegalArgumentException(
                    "Параметр i повинен бути >= 1."
            );
        }

        if (i == 1) {

            if (t < 0) {
                throw new IllegalArgumentException(
                        "Для i = 1 параметр t повинен бути >= 0."
                );
            }

            return Math.sqrt(t);
        }

        if (i == 2) {

            if (t <= 0) {
                throw new IllegalArgumentException(
                        "Для i = 2 параметр t повинен бути > 0."
                );
            }

            return 1 / Math.sqrt(t);
        }

        return t * i * (i + 1) / 2.0;
    }

    public static void main(String[] args) {

        // i = 1, t >= 0
        try {
            double result = calculate(9, 1);
            System.out.println("t=9, i=1 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // i = 1, t = 0
        try {
            double result = calculate(0, 1);
            System.out.println("t=0, i=1 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // i = 2, t > 0
        try {
            double result = calculate(4, 2);
            System.out.println("t=4, i=2 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // i = 4
        try {
            double result = calculate(2, 4);
            System.out.println("t=2, i=4 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // i = 5
        try {
            double result = calculate(-2, 5);
            System.out.println("t=-2, i=5 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            double result = calculate(-4, 1);
            System.out.println("t=-4, i=1 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Заборонений випадок t=-4, i=1: "
                            + e.getMessage()
            );
        }

        try {
            double result = calculate(0, 2);
            System.out.println("t=0, i=2 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Заборонений випадок t=0, i=2: "
                            + e.getMessage()
            );
        }

        try {
            double result = calculate(-4, 2);
            System.out.println("t=-4, i=2 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Заборонений випадок t=-4, i=2: "
                            + e.getMessage()
            );
        }

        try {
            double result = calculate(5, 0);
            System.out.println("t=5, i=0 -> " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Заборонений випадок t=5, i=0: "
                            + e.getMessage()
            );
        }
    }
}