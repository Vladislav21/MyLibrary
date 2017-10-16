package Library.Model.MyExceptions;

public class Samedata extends Exception {

    public Samedata() {
    }

    public Samedata(String message) {
        super(message);
    }

    public Samedata(String message, Throwable cause) {
        super(message, cause);
    }

    public Samedata(Throwable cause) {
        super(cause);
    }

    public Samedata(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
