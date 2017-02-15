package exceptions;

public class WrongArgumentException extends Exception {
    public enum Type {
        ElementType, SortingOrder
    }
    private Type type;

    public String getMessage() {
        String argType = null;
        if(type == Type.ElementType)
            argType = "тип сортируемых данных";
        if(type == Type.SortingOrder)
            argType = "направление сортировки";
        return "Введёный аргумент, отвечающий за " + argType
                + ", не является допустимым.\r\n";
    }

    public Type getType() {
        return type;
    }

    public void setType(Type a) {
        type = a;
    }
}