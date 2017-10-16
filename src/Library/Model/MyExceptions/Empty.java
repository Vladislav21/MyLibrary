package Library.Model.MyExceptions;

public class Empty extends Exception {
    public Empty() {
    }

    public Empty(String message) {
        super(message);
    }

    public Empty(String message, Throwable cause) {
        super(message, cause);
    }

    public Empty(Throwable cause) {
        super(cause);
    }

    public Empty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
