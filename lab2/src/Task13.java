
public class Task13 {

    public static void main(String[] args) {

        helper(0.1);
        helper(0.01);
        helper(1e-6);
        helper(1e-12);

        helper(0.0);     // ε = 0 — недопустимо (умова точності ε > 0)
        helper(-0.001);  // ε < 0 — недопустимо
    }

    private static void helper(double x) {
        try {
            double result = sumSeries(x);
            System.out.printf("ε=%s  ->  сума = %.10f%n", x, result);
        } catch (IllegalArgumentException e) {
            System.out.printf("ε=%s  ->  ПОМИЛКА: %s%n", x, e.getMessage());
        }
    }
    /*
        Перевірка аргументу: ε має бути строго додатним (ε > 0)
     */
    public static double sumSeries(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Точність 'ε' має бути додатною (ε > 0), отримано: " + x);
        }

        double sum = 0.0;
        double term = -1.0; // доданок для i = 1: (-1)^1 / 1! = -1
        int i = 1;

        while (Math.abs(term) >= x) {
            sum += term;
            i++;
            term = term * (-1.0 / i); // перехід від доданка i-1 до доданка i
        }

        return sum;
    }
}