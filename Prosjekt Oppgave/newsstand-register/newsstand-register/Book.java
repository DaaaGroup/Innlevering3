
/**
 * Represents the different Books.
 * Books has following information:
 * The author of the book.
 *
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland
 * @version 0.1,
 */
public class Book extends Literature {

    // Name of the author
    private final String author;

    /**
     *
     * @param title
     * @param author
     * @param publisher
     * @param releaseDate
     */
    public Book(String title, String author, String publisher, String releaseDate) {
        super(title, publisher, releaseDate);
        this.author = author;
        

    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getLongDescription()
    {
        String bookDetails = "";
        bookDetails += "\n### BOOK " + getSerialNumber() + " ###";
        bookDetails += "\nTitle: " + getTitle();
        bookDetails += "\nAuthor: " + author;
        bookDetails += "\nPublisher: " + getPublisher();
        bookDetails += "\nReleasedate: " + getReleaseDate() + "\n";
        return bookDetails;
    }
}