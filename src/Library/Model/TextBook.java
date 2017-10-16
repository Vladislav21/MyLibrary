package Library.Model;

import Library.Interfaces.Book;

import java.io.Serializable;

public class TextBook implements Book, Serializable {

    private String name;
    private Author author;
    private Genre genre_TEXT;
    private int ID_TEXT;
    private int pages;

    public TextBook() {
    }

    public TextBook(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public TextBook(String name, Author author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override

    public String getName() {
        return name;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public Genre getGenre() {
        return genre_TEXT;
    }

    @Override
    public boolean BookisAudio() {
        return false;
    }

    @Override
    public int getID() {
        return ID_TEXT;
    }

    @Override
    public void setID(int ID) {
        this.ID_TEXT = ID;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre_TEXT = genre;
    }


    @Override
    public String toString() {
        return "\t" + "Назваение книги:" + name + "  Автор:" + author + "  Жанр:" + genre_TEXT.getName() + "  ID текстовой книги:" + ID_TEXT +" Количество страниц:"+ pages +"\n";
    }
}


