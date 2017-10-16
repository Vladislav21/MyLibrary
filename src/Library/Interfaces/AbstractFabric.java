package Library.Interfaces;

import Library.Model.Author;
import Library.Model.Genre;

public interface AbstractFabric {

    Book createBook(String name, Author author);
}
