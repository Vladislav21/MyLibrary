package Library.Model.MyExceptions;

public class WrongGenre extends Exception {

    public WrongGenre() {
    }
    public WrongGenre(String message) {
        super(message);
    }

    public WrongGenre(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongGenre(Throwable cause) {
        super(cause);
    }
}
