
import java.util.ArrayList;


/**
 * Write a description of class Inventory here.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class Inventory
{
    private ArrayList<Literature> literatureInStock;
            

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory()
    {
        literatureInStock = new ArrayList<>();
    }
    
    public void addNewBookSeries(String title, String publisher, String releaseDate)
    {
        BookSeries newBookSeries = new BookSeries(title, publisher, releaseDate);
        literatureInStock.add(newBookSeries);
    }
    
    public void addNewBook(String title, String publisher, String releaseDate, boolean belongsToPeriodical)
    {
        Book newBook = new Book(title, null, publisher, releaseDate, belongsToPeriodical);
        literatureInStock.add(newBook);
    }
    
    public void addNewMagazine(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        Magazine newMagazine = new Magazine(title, publisher, numberPerWeek, releaseDate);
        literatureInStock.add(newMagazine);
    }
    
    public void addNewNewspaper(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        Newspaper newNewspaper = new Newspaper(title, publisher, numberPerWeek, releaseDate);
        literatureInStock.add(newNewspaper);
    }
    
    public String listAllInventory()
    {
        String literatureDetails = "";
        for(Literature literature : literatureInStock)
        {
            literatureDetails += literature.getLongDescription();
        }
        return literatureDetails;
    }
    
    public boolean removeItem(int serialNumber)
    {
        boolean success = false;
        if(-1 != itemIndex(serialNumber))
        {
        literatureInStock.remove(itemIndex(serialNumber));
        success = true;
        }
        else
        {
        success = false;
        }
        return success;
    }

    /**
     * Returns the index of the newspaper.
     * @param serialNumber The serial number of the newspaper. 
     * @return index Returns the index of the newspaper.
     */
    public int itemIndex(int serialNumber)
    {
        int index = -1;
        for(Literature literature : literatureInStock)
        {
            if( serialNumber == literature.getSerialNumber() )
            {
                index = this.literatureInStock.indexOf(literature);
            }
        }
        return index;
    }
    
    /**
     * Returns a string with info on books matching search. Checks both name as it is and as lowercase
     * to avoid case-sensitivity. Will also return partial matches.
     * @param input will search for title or author matching input
     * @return returns string with info on all books matching search. each book will be separated with linebreak.
     */
    public ArrayList<Literature> searchForTitleAndAuthor(String input){
    ArrayList<Literature> matchingItems = new ArrayList<>();
    for(Literature literature : literatureInStock){
    if(literature.getTitle().toLowerCase().contains(input.toLowerCase())){
    matchingItems.add(literature);
    }
    else if(literature.getPublisher().toLowerCase().contains(input.toLowerCase())){
    matchingItems.add(literature);
    }
    }
    return matchingItems;
    }
}
