import java.time.LocalDate;
import java.time.Period;

public abstract class Item {
    private String title;
    private double regularPrice;
    private int itemID;
    private double discount = 0;
    private LocalDate releaseDate;
    private int quantity;
    private static int currentItemID = 9000;

    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity) {
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.itemID = currentItemID;
        currentItemID += 100;
    }

    // for copying items
    public Item(String title, double regularPrice, LocalDate releaseDate, int quantity, int itemID) {
        this.title = title;
        this.regularPrice = regularPrice;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.itemID = itemID;
    }

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public double getDiscount() {
        return discount;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(LocalDate sellDate) {
        double price = getRegularPrice();
        Period difference = Period.between(releaseDate, sellDate);
        if(difference.getYears() >= 1) {
            price /= 2;
        }
        price = price - price * discount;
        return price;
    }


    //h.	setDiscount, a setter for discount, which takes a double called discount and returns a boolean.
    //      We can’t sell things for free and we don’t want to sell things for more than 50% of their
    //      regular price. Returns true if successful, false otherwise.
    public boolean setDiscount(double discount) {
        if(discount >= 0 && discount <= 0.5) {
            this.discount = discount;
            return true;
        } else {
            return false;
        }
    }

    //i.	sell, which returns a double and takes an int called amount and a LocalDate called sellDate.
    //      If sellDate is before releaseDate, the sale cannot be made so simply return 0.
    //      If amount > 0 and <= quantity, then we can sell some of this Item (reduce quantity accordingly,
    //      compute the total sales value and return it). Otherwise, we can’t make this sale
    //      so we return 0 and do nothing else.
    public double sell(int amount, LocalDate sellDate) {
        //If sellDate is before releaseDate, the sale cannot be made so simply return 0.
        Period difference = Period.between(releaseDate, sellDate);
        if(difference.getYears() < 0 || difference.getMonths() < 0 || difference.getDays() < 0) {
            return 0;
        }

        if(amount > 0 && amount <= quantity) {
            this.quantity -= amount;
            double totalSale = amount * getPrice(sellDate);
            return totalSale;
        }
        return 0;
    }


    //j.	addStock, which takes an int called amount, and increases quantity of the Item accordingly,
    //      provided we end up with at most 100 of the item.  Return true if successful, false otherwise.
    public boolean addStock(int amount) {
        if(amount > 0) {
            quantity += amount;
            return true;
        }
        return false;
    }

    //k.	A toString override, which creates a multiline string, which on the first line contains
    //      “ITEM” followed by its ID and “:”, and then “Title: ”, “Regular Price: ”, “Release Date: ”, “Discount: ”,
    //      and “Quantity: ”, each on a separate line and one tab over, each followed by their respective properties.

    @Override
    public String toString() {
        return "ITEM " + itemID +
                "\n\tTitle: " + title +
                "\n\tRegular Price: " + regularPrice +
                "\n\tRelease Date: " + releaseDate +
                "\n\tDiscount: " + discount +
                "\n\tQuantity: " + quantity ;
    }

    //l.	makeCopy, which returns a deep copy of the Item object (hint: should this be defined here?
    //      What is an Item, really? Maybe this should be deferred to concrete classes?).

    public abstract Item makeCopy();

}

