package utils;
import java.util.List;

// класс предоставляющий услуги по сортировке
public class SortUtil {

    // сортировка вставками
    public static <T extends Comparable<T>> void insertionSort(List<T> values, boolean ascending) {
        int valuePosition = 1;
        while (valuePosition < values.size()) {
            T valueForInsert = values.get(valuePosition);
            int previousValuePosition = valuePosition - 1;
            boolean foundCorrectPosition = false;
            while (previousValuePosition >= 0 && !foundCorrectPosition) {
                T previousValue = values.get(previousValuePosition);

                if (needToSwap(valueForInsert, previousValue, ascending)) {
                    swap(values, previousValuePosition + 1, previousValuePosition);
                } else {
                    foundCorrectPosition = true;
                }
                previousValuePosition--;
            }
            valuePosition++;
        }
    }

    // проверка нужно ли менять эти два объекта в сортировке
    // учитывается то, как они относятся друг к другу (больше / меньше) и то, как мы сортируем
    // по убыванию или возрастанию
    private static <T extends Comparable> boolean needToSwap(T valueOne, T valueTwo, boolean ascending) {
        boolean temp = (valueOne.compareTo(valueTwo) < 0);
        if(ascending)
            return temp;
        else return !temp;
    }

    // замена
    private static <T extends Comparable<T>> void swap(List<T> values, int firstPosition, int secondPosition) {
        T firstValue = values.get(firstPosition);
        T secondValue = values.get(secondPosition);

        values.set(firstPosition, secondValue);
        values.set(secondPosition, firstValue);
    }
}

