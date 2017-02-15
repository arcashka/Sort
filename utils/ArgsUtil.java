package utils;

import exceptions.WrongAmountOfArgsException;
import exceptions.WrongArgumentException;

public class ArgsUtil {
    public final static String STRINGS = "-s";
    public final static String INTS = "-i";
    public final static String ASCENDING = "-a";
    public final static String DESCENDING = "-d";

    // проверка на количество аргументов
    public static void checkArgs(String[] args)
            throws WrongAmountOfArgsException {
        if(args.length != 4) {
            throw new WrongAmountOfArgsException();
        }
    }

    public static String getInputFileName(String[] args) {
        return args[0];
    }

    public static String getOutputFileName(String[] args) {
        return args[1];
    }

    // осуществляется проверка подходит ли нам вообще такой аргумент
    public static String getElementsType(String[] args) throws WrongArgumentException {
        if((!args[2].equals(STRINGS)) && (!args[2].equals(INTS))) {
            WrongArgumentException e = new WrongArgumentException();
            e.setType(WrongArgumentException.Type.ElementType);
            throw e;
        }
        return args[2];
    }

    // осуществляется проверка подходит ли нам вообще такой аргумент
    public static String getSortingOrder(String[] args) throws WrongArgumentException {
        if((!args[3].equals(ASCENDING)) && (!args[3].equals(DESCENDING))) {
            WrongArgumentException e = new WrongArgumentException();
            e.setType(WrongArgumentException.Type.SortingOrder);
            throw e;
        }
        return args[3];
    }
}