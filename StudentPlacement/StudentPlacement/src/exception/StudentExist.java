package exception;

public class StudentExist extends Exception {
    public StudentExist() {
    }

    public StudentExist(String message) {
        super(message);
    }

    public StudentExist(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentExist(Throwable cause) {
        super(cause);
    }

    public StudentExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
