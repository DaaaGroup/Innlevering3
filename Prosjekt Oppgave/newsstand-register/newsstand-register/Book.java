
/**
 * Represents the different Books.
 * Books has following information:
 * The author of the book. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1, 
 */
public class Book extends Litterature
{
    // Name of the author
    private String author;

    /**
     * Constructor for objects of class Book
     */
    public Book(String title, String publisher,int every, int releaseDate, String daysWeeksMonths)
    {
        super(title, publisher, releaseDate);

    }
}
