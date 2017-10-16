package Library.Model;

import Library.Interfaces.Book;

import java.io.Serializable;

public class AudioBook implements Book, Serializable {

    private String name;
    private Author author;
    private Genre genre_AUDIO;
    private int ID_AUDIO;
    private double duractionBook;
    private double size;

    public AudioBook() {
    }

    public AudioBook(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public AudioBook(String name, Author author, double duractionBook, double size){
        this.name = name;
        this.author = author;
        this.duractionBook = duractionBook;
        this.size = size;
    }
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDuraction() {
        return duractionBook;
    }

    public void setDuraction(double duraction) {
        this.duractionBook = duraction;
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
        return genre_AUDIO;
    }

    @Override
    public boolean BookisAudio() {
        return true;

    }

    @Override
    public int getID() {
        return ID_AUDIO;
    }

    @Override
    public void setID(int ID) {
        this.ID_AUDIO = ID;

    }

    @Override
    public void setGenre(Genre genre) {
        this.genre_AUDIO = genre;
    }


    @Override
    public String toString() {
        return "\t" + "Назваение книги:" + name + "  Автор:" + author + "  Жанр:" + genre_AUDIO.getName() + "  ID аудиокниги:" + ID_AUDIO +" Длительность книги:"+duractionBook+" min"+" Размер книги:"+size +" MB"+"\n";
    }
}

