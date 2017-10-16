package Library.Interfaces;

import Library.Model.AudioBook;
import Library.Model.Author;
import Library.Model.Genre;

public interface Book {


    String getName();

    Author getAuthor();

    int getID();

    void setID(int ID);

    void setGenre(Genre genre);

    Genre getGenre();

    boolean BookisAudio();

}
