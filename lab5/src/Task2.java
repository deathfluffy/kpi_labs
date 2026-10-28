public class Task2 {
    public static String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Число не може бути від'ємним: " + i);
        }
        if (i == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int value = i;
        while (value > 0) {
            sb.append(value % 2); 
            value /= 2;
        }
        return sb.reverse().toString(); 
    }

    public static void main(String[] args) {
        System.out.println("=== Тест 1: дозволена комбінація ===");
        runTest(21);

        System.out.println("=== Тест 2: дозволена комбінація (нуль) ===");
        runTest(0);

        System.out.println("=== Тест 3: дозволена комбінація (степінь двійки) ===");
        runTest(1024);

        System.out.println("=== Тест 4: дозволена комбінація (максимальне int) ===");
        runTest(Integer.MAX_VALUE);

        System.out.println("=== Тест 5: заборонена комбінація (від'ємне число) ===");
        runTest(-5);
    }

    private static void runTest(int value) {
        System.out.println("Аргумент: " + value);
        try {
            System.out.println("Результат: \"" + intToBinaryString(value) + "\"");
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
        System.out.println();
    }
}