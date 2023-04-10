package Tema5.boletin2t5;

public class FormasException extends Exception{

    public FormasException() {
    }

    public FormasException(String message) {
        super(message);
    }

    public FormasException(Throwable cause) {
        super(cause);
    }

    public FormasException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
