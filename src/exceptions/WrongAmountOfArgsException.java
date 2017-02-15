package exceptions;

public class WrongAmountOfArgsException extends Exception {
    public String getMessage() {
        return "Недопустимое количество аргументов.\r\n";
    }
}
