import java.util.Arrays;


interface SortStrategy {
    void sort(float[] array);
    String getName();
}

class SelectionSort implements SortStrategy {
    @Override
    public void sort(float[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                float tmp = a[i];
                a[i] = a[maxIndex];
                a[maxIndex] = tmp;
            }
        }
    }

    @Override
    public String getName() {
        return "Selection sort";
    }
}

class InsertionSort implements SortStrategy {
    @Override
    public void sort(float[] a) {
        for (int i = 1; i < a.length; i++) {
            float key = a[i];
            int j = i - 1;
            // зсуваємо елементи, що менші за key, праворуч
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}

class Sorter {
    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public String getStrategyName() {
        return strategy.getName();
    }

    public void sort(float[] array) {
        strategy.sort(array);
    }
}


public class Main {
    public static void main(String[] args) {
        float[] original = {3.5f, -1.2f, 8.0f, 0.0f, 4.75f, 8.0f, -7.3f, 2.1f};
        System.out.println("Вихідний масив: " + Arrays.toString(original));

        // Сортування вибором
        Sorter sorter = new Sorter(new SelectionSort());
        float[] data = original.clone();
        sorter.sort(data);
        System.out.println(sorter.getStrategyName() + ": " + Arrays.toString(data));

        // Заміна алгоритму
        sorter.setStrategy(new InsertionSort());
        data = original.clone();
        sorter.sort(data);
        System.out.println(sorter.getStrategyName() + ": " + Arrays.toString(data));
    }
}