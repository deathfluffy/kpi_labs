public class Task10 {
    public static String uppercaseWords(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("Речення не може бути null.");
        }
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("Речення не може бути порожнім.");
        }

        char[] chars = sentence.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            if (isLetterOrDigit(chars[i])) {
                int start = i;
                boolean hasDigit = false;
                while (i < chars.length && isLetterOrDigit(chars[i])) {
                    if (isDigit(chars[i])) {
                        hasDigit = true;
                    }
                    i++;
                }
                String token = sentence.substring(start, i);
                result.append(hasDigit ? token : token.toUpperCase());
            } else {
                if (!isAllowedSeparator(chars[i])) {
                    throw new IllegalArgumentException(
                            "Речення містить недопустимий символ: '" + chars[i] + "'.");
                }
                result.append(chars[i]);
                i++;
            }
        }
        return result.toString();
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isLatinLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isLetterOrDigit(char c) {
        return isLatinLetter(c) || isDigit(c);
    }

    private static boolean isAllowedSeparator(char c) {
        return c == ' ' || c == '\t' || (c >= '!' && c <= '~');
    }

    public static void main(String[] args) {
        System.out.println("=== Тест 1: дозволена комбінація ===");
        runTest("The user with the nickname koala757677 this month wrote 3 times more "
                + "comments than the user with the nickname croco181dile920 4 months ago");

        System.out.println("=== Тест 2: дозволена комбінація (розділові знаки) ===");
        runTest("Hello, World! Version 2 of Java17 is out.");

        System.out.println("=== Тест 3: заборонена комбінація (null) ===");
        runTest(null);

        System.out.println("=== Тест 4: заборонена комбінація (порожнє речення) ===");
        runTest("");

        System.out.println("=== Тест 5: заборонена комбінація (кириличні літери) ===");
        runTest("Hello Привіт world");
    }

    private static void runTest(String sentence) {
        System.out.println("Аргумент: " + (sentence == null ? "null" : "\"" + sentence + "\""));
        try {
            System.out.println("Результат: \"" + uppercaseWords(sentence) + "\"");
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Очікувана помилка: " + e.getMessage());
        }
        System.out.println();
    }
}