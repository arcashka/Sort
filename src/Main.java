import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import utils.*;
import exceptions.*;


public class Main {
    public static void main(String[] args) {
        try {
            // Проверка на количество переданных аргументов
            ArgsUtil.checkArgs(args);
            // Запись аргументов из массива строк в отдельные переменные
            String inputFileName = ArgsUtil.getInputFileName(args);
            String outputFileName = ArgsUtil.getOutputFileName(args);
            String elementsType = ArgsUtil.getElementsType(args);
            String sortingOrder = ArgsUtil.getSortingOrder(args);


            List elements = null;

            // используется разный ввод, для целых чисел и строк
            if (elementsType.equals(ArgsUtil.STRINGS))
                elements = InputOutputUtil.readStringsFromFile(inputFileName);
            if (elementsType.equals(ArgsUtil.INTS))
                elements = InputOutputUtil.readIntegersFromFile(inputFileName);

            // в переменной ascending лежит true если мы сортируем по возрастанию
            // и false, если по убыванию
            boolean ascending = sortingOrder.equals(ArgsUtil.ASCENDING);

            // сортировка контейнера elements по возрастанию или по убыванию в зависимости
            // от значения ascending
            SortUtil.insertionSort(elements, ascending);

            // вывод отсортированного контейнера в файл
            InputOutputUtil.saveToFile(elements, outputFileName);
        }

        // обработка возможных ошибок
        catch (FileNotFoundException e) {
            System.out.println("Не существует файла с таким именем.\r\n");
        }

        // Отсутствие файла и пустой файл обрабатываются отдельно,
        // но остальные исключения, которые относятся к IO не будут выноситься на обработку отдельно
        //
        catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }

        catch (IOException e) {
            System.out.println("Ошибка ввода / вывода\r\n");
        }

        catch (WrongAmountOfArgsException e) {
            System.out.println(e.getMessage());
        }

        catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
        }

        catch (NumberFormatException e) {
            System.out.println("Недопустимые символы во входном файле.\r\n");
        }
    }
}
