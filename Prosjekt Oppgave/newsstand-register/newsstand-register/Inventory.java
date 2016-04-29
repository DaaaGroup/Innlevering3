import java.util.ArrayList;

/**
 * This class handles all of the literature in the inventory.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @deprecated Kristoffer Martinsen
 * @version 0.1
 */
public class Inventory
{
    // List which contains all the inventory in one place.
    private ArrayList<Literature> literatureInStock;

    /**
     * Creates an object of class Inventory. Initializes the inventory list
     */
    public Inventory()
    {
        literatureInStock = new ArrayList<>();
    }
    
    /**
     * This method is responsible for creating an object of type BookSeries and
     * add it to the inventory list.
     * 
     * @param title Title of the BookSeries
     * @param publisher Name of publishing company.
     * @param releaseDate date of release.
     */
    public void addNewBookSeries(String title, String publisher, String releaseDate)
    {
        BookSeries newBookSeries = new BookSeries(title, "", publisher, releaseDate);
        literatureInStock.add(newBookSeries);
    }
    
    /**
     * This method is responsible for creating an object of type Book and
     * add it to the inventory list.
     * 
     * @param title Title of book
     * @param author Name of the Author
     * @param publisher Name of publishing company
     * @param releaseDate Date of release
     */
    public void addNewBook(String title, String author, String publisher, String releaseDate)
    {
        Book newBook = new Book(title, author, publisher, releaseDate);
        literatureInStock.add(newBook);
    }
    
    /**
     * This method is responsible for creating an object of type Magazine and
     * add it to the inventory list.
     * 
     * @param title Title of magazine
     * @param publisher name of publishing company
     * @param numberPerWeek number of releases per week
     * @param releaseDate date of release
     */
    public void addNewMagazine(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        Magazine newMagazine = new Magazine(title, publisher, numberPerWeek, releaseDate);
        literatureInStock.add(newMagazine);
    }
    
    /**
     * 
     * @param literature 
     */
    public void addLiterature(Literature literature)
    {
        literatureInStock.add(literature);
    }
    
    /**
     * This method is responsible for creating an object of type Newspaper and
     * add it to the inventory list.
     * 
     * @param title Title of Newspaper
     * @param publisher Name of publishing company
     * @param numberPerWeek Number of releases per week
     * @param releaseDate Date of release
     */
    public void addNewNewspaper(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        Newspaper newNewspaper = new Newspaper(title, publisher, numberPerWeek, releaseDate);
        literatureInStock.add(newNewspaper);
    }

    /**
     *This method is responsible for creating an object of type Periodical and
     * add it to the inventory list.
     * 
     * @param title Title of periodical
     * @param publisher Name of publishing company
     * @param numberPerWeek Number of releases per week
     * @param releaseDate Date of release
     */
    public void addNewPeriodical(String title, String publisher, int numberPerWeek, String releaseDate) 
    {
        Periodical newPeriodical = new Periodical(title, publisher, numberPerWeek, releaseDate);
        literatureInStock.add(newPeriodical);
    }
    
    /**
     * This method builds up a string that describes in detail every item
     * in the inventory
     * 
     * @return literatureDetails A string describing in detail every item in the inventory
     */
    public String listAllInventory()
    {
        String literatureDetails = "";
        for(Literature literature : literatureInStock)
        {
            literatureDetails += literature.getLongDescription();
        }
        return literatureDetails;
    }
    
    public ArrayList<Literature> returnAllInventory()
    {
        ArrayList<Literature> litList = new ArrayList<>();
        litList.addAll(literatureInStock);
        return litList;
    }
    
    /**
     * Takes the serial number of an item (which is unique) and uses that to
     * remove said item from the inventory.
     * 
     * @param serialNumber The unique serial number for each item
     * @return success Whether or not it was successful in removing the item.
     */
    public boolean removeItem(int serialNumber)
    {
        boolean success = false;
        if(-1 != itemIndex(serialNumber)) {
            literatureInStock.remove(itemIndex(serialNumber));
            success = true;
        }
        else {
            success = false;
        }
        return success;
    }

    /**
     * Returns the index of the item.
     * 
     * @param serialNumber The serial number of the item. 
     * @return index Returns the index of the item.
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
     * Returns a string with info on items matching search string. Checks both title
     * and publisher. Will also return partial matches.
     * 
     * @param input The string it should use to find matching items.
     * @return matchingItems A list of items matching the search string.
     */
public ArrayList<Literature> searchForTitleAndPublisher(String input) {
        input = input.trim().toLowerCase();
        ArrayList<Literature> foundLiterature = new ArrayList<>();
        for (Literature literature : literatureInStock) {
            if (literature.getTitle().toLowerCase().contains(input)) {
                foundLiterature.add(literature);
            } else if (literature.getPublisher().toLowerCase().contains(input)) {
                foundLiterature.add(literature);
            }
        }

        return foundLiterature;
    }
    
    /**
     * Picks out all the books from the inventory and puts them in an list
     * of their own
     * 
     * @return matchingItems A list of all the books in the inventory
     */
    public ArrayList<Literature> returnListOfBooks()
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        
        for( Literature literature : literatureInStock) {
            if( literature instanceof Book ) {
                matchingItems.add(literature);
            }
        }
        return matchingItems;
    }
    
    /**
     * Picks out all the bookseries from the inventory and puts them in an list
     * of their own
     * 
     * @return matchingItems A list of all the bookseries in the inventory 
     */
    public ArrayList<Literature> returnListOfBookSeries()
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        
        for( Literature literature : literatureInStock) {
            if( literature instanceof BookSeries ) {
                matchingItems.add(literature);
            }
        }
        return matchingItems;
    }
    
    /**
     * Picks out all the magazines from the inventory and puts them in an list
     * of their own
     * 
     * @return matchingItems A list of all the magazines in the inventory
     */
    public ArrayList<Literature> returnListOfMagazine()
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        
        for( Literature literature : literatureInStock) {
            if( literature instanceof Magazine ) {
                matchingItems.add(literature);
            }
        }
        return matchingItems;
    }
    
    /**
     * Picks out all the newspapers from the inventory and puts them in an list
     * of their own
     * 
     * @return matchingItems A list of all the newspapers in the inventory
     */
    public ArrayList<Literature> returnListOfNewspaper()
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        
        for( Literature literature : literatureInStock) {
            if( literature instanceof Newspaper ) {
                matchingItems.add(literature);
            }
        }
        return matchingItems;
    }
    
    /**
     * Picks out all the periodicals from the inventory and puts them in an list
     * of their own
     * 
     * @return matchingItems A list of all the periodicals in the inventory
     */
    public ArrayList<Literature> returnListOfPeriodical()
    {
        ArrayList<Literature> matchingItems = new ArrayList<>();
        
        for( Literature literature : literatureInStock) {
            if( literature instanceof Periodical ) {
                matchingItems.add(literature);
            }
        }
        return matchingItems;
    }
    
    /**
     * Picks out from the inventory a book and takes its fields and
     * transfers them into a new bookseries object, which is in turn added to
     * the inventory. Effectively converting a book into a book series.
     * 
     * @param menuSelection the book which should be converted.
     */
    void convertBook(int menuSelection)
    {
        String title = literatureInStock.get(menuSelection - 1).getTitle();
        String publisher = literatureInStock.get(menuSelection - 1).getPublisher();
        String releaseDate = literatureInStock.get(menuSelection - 1).getReleaseDate();
        addNewBookSeries(title, publisher, releaseDate);
    }
    
    /**
     * 
     * @return 
     */
    public int getSize()
    {
        return this.literatureInStock.size();
    }
    
    public void removeItem(Literature literature){
        literatureInStock.remove(literature);
    }
}
