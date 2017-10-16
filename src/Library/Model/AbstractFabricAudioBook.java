package Library.Model;

import Library.Interfaces.AbstractFabric;
import Library.Interfaces.Book;

public class AbstractFabricAudioBook implements AbstractFabric {




    public Book createBook(String name, Author author, double duractionBook, double size){
        return new AudioBook(name, author, duractionBook, size);
    }

    @Override
    public Book createBook(String name, Author author) {
        return new AudioBook(name, author);
    }}

