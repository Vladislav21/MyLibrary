import Library.Controller.BookController;
import Library.Interfaces.Book;
import Library.Model.MyExceptions.Empty;
import Library.Model.MyExceptions.Samedata;
import Library.Model.MyExceptions.WrongName;
import Library.Model.MyExceptions.WrongSymbols;
import Library.View.ViewBooks;

import javax.swing.text.View;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Samedata, Empty, ClassNotFoundException, WrongName, WrongSymbols, IOException {
        ViewBooks view = new ViewBooks();
        view.start();
    }
}
