import java.util.ArrayList; 

/**
 * Represents the different BookSeries.
 * BookSeries has following information:
 * The author and the list of the Books. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1, 
 */
public class BookSeries extends Literature
{
    // Name of the author
    private String author;
    //List of books in this series
    private ArrayList<Book> booksInSeries;
    
    
    /**
     * 
     * @param title
     * @param publisher
     * @param every
     * @param releaseDate
     * @param daysWeeksMonths 
     */
    public BookSeries(String title, String publisher,int every, int releaseDate, String daysWeeksMonths)
    {
        super(title, publisher, releaseDate);
    }

}
