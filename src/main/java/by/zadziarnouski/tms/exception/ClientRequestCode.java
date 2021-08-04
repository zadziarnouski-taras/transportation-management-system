package by.zadziarnouski.tms.exception;

public enum ClientRequestCode implements ErrorCode{
    NOT_FOUND(201);

    private final int number;

    ClientRequestCode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
