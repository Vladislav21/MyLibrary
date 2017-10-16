package Library.Model.MyExceptions;

public class WrongName extends Exception {
    public WrongName() {
    }

    public WrongName(String message) {
        super(message);
    }

    public WrongName(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongName(Throwable cause) {
        super(cause);
    }

    public WrongName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
