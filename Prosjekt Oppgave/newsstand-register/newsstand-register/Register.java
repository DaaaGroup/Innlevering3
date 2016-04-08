
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
    private Inventory inventory;

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
     * @param daysWeeksMonths Specified how many days, weeks or months there is between 
     * each release.
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
     * @param daysWeeksMonths Specified how many days, weeks or months there is between 
     * each release.
     */
    public void addMagazine(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        inventory.addNewMagazine(title, publisher, numberPerWeek, releaseDate);
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
     */
    public boolean removeNewspaper(int serialNumber)
    {
        return inventory.removeItem(serialNumber);
    }
}
