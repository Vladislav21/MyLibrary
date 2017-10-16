package Library.Model;

import Library.Interfaces.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LibraryBook implements Serializable {

    List<Book> books;    // Почему нужны скобки Book
    List<Genre> genres; // Здесь нужно разобрать про область памяти конструктора

    public LibraryBook() {
        books = new ArrayList<>();
        genres = new ArrayList<>();
    }

    public LibraryBook(List<Book> book, List<Genre> genre) {
        this.books = book;
        this.genres = genre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


}

