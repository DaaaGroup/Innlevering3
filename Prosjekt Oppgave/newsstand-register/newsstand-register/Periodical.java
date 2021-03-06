import java.util.ArrayList; 

/**
 * Represents the different Periodical.
 * Periodical has following information:
 The author and the list of the Books. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1, 
 */
public class Periodical extends Literature
{
    // Name of the author
    private String author;
    //List of books in this series
    private ArrayList<Book> booksInPeriodical;
    
    
    /**
     * 
     * @param title
     * @param publisher
     * @param every
     * @param releaseDate
     * @param daysWeeksMonths 
     */
    public Periodical(String title, String publisher,int every, String releaseDate, String daysWeeksMonths)
    {
            super(title, publisher, releaseDate);
    }
    
    @Override
    public String getLongDescription()
    {
        String newspaperDetails ="";
        newspaperDetails += "\n### PERIODICAL " + getSerialNumber() + " ###";
        newspaperDetails += "\nTitle: " + getTitle();
        newspaperDetails += "\nPublisher: " + getPublisher();
        return newspaperDetails;
    }
}
