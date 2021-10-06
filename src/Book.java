import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends Item{
    ArrayList<String> authors;

    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors) {
        super(title, regularPrice, releaseDate, quantity);
        this.authors = authors;
    }

    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID, ArrayList<String> authors) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return new ArrayList<String>(authors);
    }

    @Override
    public String toString() {
        String authorNames = "";
        for(String name : authors) {
            authorNames += "\n\t\t" + name;
        }
        return super.toString() +
                "\n\tAuthors:" + authorNames;
    }
}
