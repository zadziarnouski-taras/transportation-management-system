package by.zadziarnouski.tms.exception;

public enum ValidationCode implements ErrorCode{
    //Может error сообщение вместе с кодом связать
    INCORRECT_DATA_ENTRY(101);

    private final int number;

    ValidationCode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
