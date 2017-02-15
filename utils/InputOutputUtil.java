package utils;

import exceptions.EmptyFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutputUtil {
    // считывание, если целые числа
    public static List<Integer> readIntegersFromFile(String path)
    throws java.io.IOException, FileNotFoundException, NumberFormatException, EmptyFileException{
        List<Integer> elements = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                elements.add(Integer.parseInt(line));
            }
        }
        if(elements.isEmpty()) {
            EmptyFileException e = new EmptyFileException();
            e.setFileName(path);
            throw e;
        }
        return elements;
    }

    // считывание, если строки
    public static List<String> readStringsFromFile(String path)
    throws java.io.IOException, FileNotFoundException, EmptyFileException {
        List<String> elements = new ArrayList<>();
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                elements.add(line);
            }
        }
        if(elements.isEmpty()) {
            EmptyFileException e = new EmptyFileException();
            e.setFileName(path);
            throw e;
        }
        return elements;
    }


    // запись в файл
    //
    public static <T extends Comparable<T>> void saveToFile(List<T> elements, String path)
    throws java.io.IOException {
        try (FileWriter writer =
                     new FileWriter(path)) {
            for (T element : elements) {
                writer.write(element.toString() + "\r\n");
            }
        }
    }
}

