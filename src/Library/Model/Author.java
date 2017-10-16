package Library.Model;

import java.io.Serializable;

public class Author implements Serializable {

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}