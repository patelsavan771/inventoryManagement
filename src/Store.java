import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
    private ArrayList<Item> inventory;
    private double totalSalesValue = 0.0;
    private int totalNumberOfSales = 0;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item i) {
        this.inventory.add(i);
    }

    public boolean makeSale(int itemID, int quantity, LocalDate sellDate) {
        Item foundItem = getItemByID(itemID);
        if(foundItem == null) {
            return false;
        }
        double value = foundItem.sell(quantity, sellDate);
        if(value > 0) {
            this.totalNumberOfSales++;
            this.totalSalesValue += value;
            return true;
        }
        return false;
    }

    public String getInventoryString() {
        String result = "";
        for(Item i : this.inventory) {
            result = result + "\n" + i.toString() + "\n";
        }
        return result;
    }

    public void listInventory() {
        System.out.println("Here are all the inventory items : ");
        System.out.println(getInventoryString());
    }

    public Item checkForItem(int itemID) {
        for(Item i : this.inventory) {
            if(i.getItemID() == itemID) {
                return i.makeCopy(); //copy of item
            }
        }
        return null;
    }

    private Item getItemByID(int itemID) {
        for(Item i : this.inventory) {
            if(i.getItemID() == itemID) {
                return i;
            }
        }
        return null;
    }

    public double getTotalSalesValue() {
        return totalSalesValue;
    }

    public int getTotalNumberOfSales() {
        return totalNumberOfSales;
    }

    @Override
    public String toString() {
        return "Total sales value : " + getTotalSalesValue() +
                "\nTotal number of sales : " + getTotalNumberOfSales() +
                "\nCurrent inventory : " + getInventoryString();
    }

}
