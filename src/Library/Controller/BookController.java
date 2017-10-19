package Library.Controller;

import Library.Interfaces.AbstractFabric;
import Library.Interfaces.Book;
import Library.Model.*;
import Library.Model.MyExceptions.Empty;
import Library.Model.MyExceptions.Samedata;
import Library.Model.MyExceptions.WrongName;
import Library.Model.MyExceptions.WrongSymbols;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class BookController {

    private final String FILE_NAME = "librarybook.dat";
    private AbstractFabric abstractfabricaudiobook;
    private AbstractFabric abstractfabrictextbook;
    private int IDgenre;
    private int IDbook;
    private LibraryBook libraryBook;
    private Pattern pattern;
    private Matcher matcher;

    public BookController() {    // Почему именно здесь надо создавать объекты
        abstractfabricaudiobook = new AbstractFabricAudioBook();
        abstractfabrictextbook = new AbstractFabricTextBook();
        IDgenre = 0;
        IDbook = 0;
        List<Book> b = new ArrayList<>();
        List<Genre> g = new ArrayList<>();
        libraryBook = new LibraryBook(b, g);

    }

    public String researchBooks(String name) {
        pattern = Pattern.compile(name);
        String findbook = new String();
        for (Book book : libraryBook.getBooks()) {
            matcher = pattern.matcher(book.getName());
            if (matcher.find()) {
                if (book.BookisAudio()) {
                    findbook += ((AudioBook) book).toString();
                } else
                    findbook += ((TextBook) book).toString();
            }

        }
        return findbook;
    }


    public String getGenreList() throws Empty {
        String str = new String();
        for (Genre genre : libraryBook.getGenres()) {
            str += genre.toString();
        }
        return str;
    }

    public List<Book> getBookList() throws Empty {
        return libraryBook.getBooks();
    }


    public boolean deleteBookbyID(int ID) {
        for (Book book : libraryBook.getBooks()) {
            if (book.getID() == ID) {
                libraryBook.getBooks().remove(book);
                return true;
            }
        }
        return false;
    }


    public boolean addGenre(String genreName, double age) {
        Genre genre = new Genre();
        genre.setName(genreName);
        genre.setAge(age);
        IDgenre++;
        genre.setID_GENRE(IDgenre);
        for (Genre oldGenre : libraryBook.getGenres()) {
            if (oldGenre.equals(genre)) {
                return false;
            }
        }
        libraryBook.getGenres().add(genre);
        return true;
    }

    public Genre getGenrebyID(int IDgenre) throws WrongSymbols {
        for (Genre genre : libraryBook.getGenres()) {
            if (genre.getID() == IDgenre) {
                return genre;
            }
        }
        throw new WrongSymbols();
    }


    public boolean deleteGenre(String name) {
        for (Genre genre : libraryBook.getGenres()) {
            if (genre.getName().equals(name)) {
                libraryBook.getGenres().remove(genre);
                return true;
            }
        }
        return false;
    }


    public boolean addBookAudio(String name, Author author, int GenreID, double duractionBook, double size) throws WrongSymbols {
        Book audiobook = ((AbstractFabricAudioBook) abstractfabricaudiobook).createBook(name, author, duractionBook, size);
        audiobook.setGenre(getGenrebyID(GenreID));
        IDbook++;
        audiobook.setID(IDbook);
        libraryBook.getBooks().add(audiobook);
        return true;
    }

    public boolean addBookText(String name, Author author, int GenreID, int pages) throws WrongSymbols {
        Book textbook = ((AbstractFabricTextBook) abstractfabrictextbook).createBook(name, author, pages);
        textbook.setGenre(getGenrebyID(GenreID));
        IDbook++;
        textbook.setID(IDbook);
        libraryBook.getBooks().add(textbook);
        return true;
    }


    public void saveData() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(libraryBook);
        oos.close();
    }

    public void readData() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        libraryBook = (LibraryBook) ois.readObject();
        ois.close();
    }

    public String getAuthors() {

       List<String> a = libraryBook.getBooks().stream()
                .map(book -> book.getAuthor().getName())
                .filter(s -> !s.isEmpty())
                .distinct().collect(toList());


        String str = new String();
        for (String author : a) {
            str += "\n" + author;
        }
        return str;

        /*String str = new String();
        for(Book book: libraryBook.getBooks()){
            str +="\n"+book.getAuthor();
        }
        return str;*/
    }

    public boolean getBookbyName(String name) throws WrongName {
        for (Book book : libraryBook.getBooks()) {
            if (book.getName().equals(name)) {
                System.out.println(book);
                return true;
            }
        }
        return false;
    }

    public Author getAuthor(String str) {
        return new Author(str);
    }
}




