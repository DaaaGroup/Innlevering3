
import java.util.ArrayList;

/**
 * This class is a register that represents the offers of reading material that
 * the newsstand has available at any time. 
 *
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland
 * @version 0.1
 */
public class Register {

    private final Inventory inventory;

    /**
     * Creates a Inventory, which has the literatures.
     */
    public Register() {
        inventory = new Inventory();
    }

    /**
     * Creates a new Newspaper.
     *
     * @param title Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How often the newspaper is released.
     * @param releaseDate The release date of the newspaper. 
     */
    public void addNewspaper(String title, String publisher, int numberPerWeek, String releaseDate) {
        inventory.addNewNewspaper(title, publisher, numberPerWeek, releaseDate);
    }

    /**
     * Creates a new Magazine.
     *
     * @param title Title of the magazine.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How often the magazine is released.
     * @param releaseDate The release date of the magazine.
     */
    public void addMagazine(String title, String publisher, int numberPerWeek, String releaseDate) {
        inventory.addNewMagazine(title, publisher, numberPerWeek, releaseDate);
    }

    /**
     * Creates a new Periodical.
     *
     * @param title Title of the periodical.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How often the periodical is released.
     * @param releaseDate The release date of the periodical. 
     */
    public void addPeriodical(String title, String publisher, int numberPerWeek, String releaseDate) {
        inventory.addNewPeriodical(title, publisher, numberPerWeek, releaseDate);
    }

    /**
     * Creates a new Book.
     *
     * @param title Title of the book.
     * @param author The authors name.
     * @param publisher Name of the publisher.
     * @param releaseDate When the book is released. 
     */
    public void addBook(String title, String author, String publisher, String releaseDate) {
        inventory.addNewBook(title, author, publisher, releaseDate);
    }

    /**
     * An accessor method that returns relevant information about the inventory.
     * Such as: Title, publisher & amount of time between releases.
     *
     * @return returnString A String that describes all of the inventory.
     * 
     */
    public String listAllInventory() {
        String returnString = inventory.listAllInventory();
        if (returnString.equals("")) {
            returnString = "\nThere are no items in your inventory\n";
        }
        return returnString;
    }

    /**
     * Removes a specified literature from the register.
     *
     * @param serialNumber The number of the literature you wish to remove.
     * @return the removed product. 
     */
    public boolean removeItem(int serialNumber) {
        return inventory.removeItem(serialNumber);
    }

    /**
     *
     * Items which has the requirements of the searching result. 
     * 
     * @param className The name of the "class". 
     * @return matchingItems Returns the matched item.  
     */
    public ArrayList<Literature> returnListOfItems(String className) {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        switch (className) {
            case "books":
                for (Literature literature : inventory.returnListOfBooks()) {
                    matchingItems.add(literature);
                }
                break;
            case "bookseries":
                for (Literature literature : inventory.returnListOfBookSeries()) {
                    matchingItems.add(literature);
                }
                break;
            case "magazines":
                for (Literature literature : inventory.returnListOfMagazine()) {
                    matchingItems.add(literature);
                }
                break;
            case "newspapers":
                for (Literature literature : inventory.returnListOfNewspaper()) {
                    matchingItems.add(literature);
                }
                break;
            case "periodicals":
                for (Literature literature : inventory.returnListOfPeriodical()) {
                    matchingItems.add(literature);
                }
                break;
            default:
                break;
        }
        return matchingItems;
    }

    /**
     *
     * Convert book to a book series. 
     * 
     * @param menuSelection What kind of book is selected. 
     */
    public void convertBook(int menuSelection) {
        inventory.convertBook(menuSelection);
    }
}
