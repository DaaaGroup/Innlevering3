
import java.util.ArrayList;


/**
 * This class is a register that represents the offers of reading material that the
 * newsstand has available at any time.
 * Currently it only contains newspapers. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */

public class Register
{
    private final Inventory inventory;

    /**
     * Creates a new register object with an array list of newspapers.
     */
    public Register()
    {
        inventory = new Inventory();
    }

    /**
     * Creates a new Newspaper.
     * @param title     Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param numberPerWeek     How often the newspaper is released.
     * @param releaseDate
     */
    public void addNewspaper(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        inventory.addNewNewspaper(title, publisher, numberPerWeek, releaseDate);
    }
    
    /**
     * Creates a new Magazine.
     * @param title     Title of the magazine.
     * @param publisher Name of the publisher.
     * @param numberPerWeek     How often the magazine is released.
     * @param releaseDate
     */
    public void addMagazine(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        inventory.addNewMagazine(title, publisher, numberPerWeek, releaseDate);
    }
    
        /**
     * Creates a new Magazine.
     * @param title     Title of the magazine.
     * @param publisher Name of the publisher.
     * @param numberPerWeek     How often the magazine is released.
     * @param releaseDate
     */
    public void addPeriodical(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        inventory.addNewPeriodical(title, publisher, numberPerWeek, releaseDate);
    }
    
    /**
     * Creates a new Book.
     * @param title     Title of the magazine.
     * @param author
     * @param publisher Name of the publisher.
     * @param belongsToBookSeries
     * @param releaseDate
     */
    public void addBook(String title, String author, String publisher, String releaseDate, boolean belongsToBookSeries)
    {
        inventory.addNewBook(title, author, publisher, releaseDate, belongsToBookSeries);
    }

    /**
     * An accessor method that returns relevant information about the inventory.
     * Such as: Title, publisher & amount of time between releases.
     * @return 
     */
    public String listAllInventory()
    {
        String returnString = inventory.listAllInventory();
        if(returnString.equals("")) {
            returnString = "\nThere are no items in your inventory\n"; 
        }
        return returnString;
    }

    /**
     * Removes a specified newspaper from the register.
     * @param serialNumber The number of the newspaper you wish to remove.
     * @return 
     */
    public boolean removeItem(int serialNumber)
    {
        return inventory.removeItem(serialNumber);
    }
    
    /**
     * 
     * @param className
     * @return 
     */
    public ArrayList<Literature> returnListOfItems(String className)
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        switch (className) {
            case "books":
                for( Literature literature : inventory.returnListOfBooks()) {
                    matchingItems.add(literature);
                }   break;
            case "bookseries":
                for( Literature literature : inventory.returnListOfBookSeries()) {
                    matchingItems.add(literature);
                }   break;
            case "magazines":
                for( Literature literature : inventory.returnListOfMagazine()) {
                    matchingItems.add(literature);
                }   break;
            case "newspapers":
                for( Literature literature : inventory.returnListOfNewspaper()) {
                    matchingItems.add(literature);
                }   break;
            case "periodicals":
                for( Literature literature : inventory.returnListOfPeriodical()) {
                    matchingItems.add(literature);
                }   break;
            default:
                break;
        }
        return matchingItems;
    }
    
    /**
     * 
     * @param menuSelection 
     */
    public void convertBook(int menuSelection)
    {
        inventory.convertBook(menuSelection);
    }
}
