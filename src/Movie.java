import java.time.LocalDate;

public class Movie extends Item {
    private String director;
    private String producer;

    public Movie(String title, double regularPrice, LocalDate releaseDate,
                 int quantity, String director, String producer) {
        super(title, regularPrice, releaseDate, quantity);
        this.director = director;
        this.producer = producer;
    }

    public Movie(String title, double regularPrice, LocalDate releaseDate,
                 int quantity, int itemID, String director, String producer) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.director = director;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tDirector: " + director +
                "\n\tProducer: " + producer;
    }

    @Override
    public Item makeCopy() {
        return new Movie(getTitle(), getRegularPrice(), getReleaseDate(),
                getQuantity(), getItemID(), director, producer);
    }
}
