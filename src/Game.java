import java.time.LocalDate;

public class Game extends Item {
    String studio;
    boolean discontinued;

    public Game(String title, double regularPrice, LocalDate releaseDate,
                int quantity, String studio, boolean discontinued) {
        super(title, regularPrice, releaseDate, quantity);
        this.studio = studio;
        this.discontinued = discontinued;
    }

    public Game(String title, double regularPrice, LocalDate releaseDate,
                int quantity, int itemID, String studio, boolean discontinued) {
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.studio = studio;
        this.discontinued = discontinued;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tStudio: " + studio +
                "\n\tDiscontinued: " + discontinued;
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        double price = getRegularPrice();
        if(isDiscontinued()) {
            price *= 20;
        }
        return price;
    }

    @Override
    public Item makeCopy() {
        return new Game(getTitle(), getRegularPrice(), getReleaseDate(), getQuantity(),
                getItemID(), studio, discontinued);
    }
}
