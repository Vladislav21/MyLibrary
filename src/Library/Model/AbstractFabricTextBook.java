package Library.Model;

import Library.Interfaces.AbstractFabric;
import Library.Interfaces.Book;

public class AbstractFabricTextBook implements AbstractFabric {



    public Book createBook(String name, Author author, int pages){
        return new TextBook(name, author, pages);
    }

    @Override
    public Book createBook(String name, Author author) {
        return new TextBook(name, author);
    }

}
