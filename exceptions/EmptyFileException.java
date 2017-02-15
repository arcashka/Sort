package exceptions;

public class EmptyFileException extends Exception {
    // храним файл, к которому относится это исключение
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getMessage() {
        return "Файл " + fileName + " пуст.\r\n";
    }
}
