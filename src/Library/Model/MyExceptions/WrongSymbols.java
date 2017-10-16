package Library.Model.MyExceptions;

public class WrongSymbols extends Exception {
    public WrongSymbols() {
    }

    public WrongSymbols(String message) {
        super(message);
    }

    public WrongSymbols(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongSymbols(Throwable cause) {
        super(cause);
    }

    public WrongSymbols(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
