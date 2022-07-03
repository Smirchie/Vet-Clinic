package main.enums;

public enum AppStatus {
    NEW("Новый"),
    IN_PROCESS("В процессе"),
    CANCELLED("Отменен"),
    AWAITING_PAYMENT("Ожидает оплаты"),
    COMPLETED("Завершен");

    private final String text;

    AppStatus(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
