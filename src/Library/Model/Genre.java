package Library.Model;

import java.io.Serializable;

public class Genre implements Serializable {

    private String name;
    private double age;
    private int ID_GENRE;

    public Genre() {
    }

    public Genre(String name, double age, int ID_GENRE) {
        this.name = name;
        this.age = age;
        this.ID_GENRE = ID_GENRE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (Double.compare(genre.age, age) != 0) return false;
        return name != null ? name.equals(genre.name) : genre.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(age);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setID_GENRE(int ID_GENRE) {
        this.ID_GENRE = ID_GENRE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getID() {
        return ID_GENRE;
    }

    @Override
    public String toString() {
        return "Жанр:" + name + ", Возраст жанра:" + age +" лет" +", ID жанра:" + ID_GENRE + "\n";
    }
}
