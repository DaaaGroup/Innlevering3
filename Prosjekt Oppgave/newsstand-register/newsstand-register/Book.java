
/**
 * Represents the different Books.
 * Books has following information:
 * The author of the book.
 * The title of the book.
 * The publisher of the book.
 * The release date of the book.
 *
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland
 * @version 0.1,
 */
public class Book extends Literature {

    // Name of the author
    private final String author; 

    /**
     *
     * Uses the super call to get the fields from the super class: Literature.
     * Creates the information that the Book object needs. 
     * 
     * @param title The title of the book.
     * @param author The author of the book.
     * @param publisher The publisher of the book.
     * @param releaseDate The release date of the book.
     */
    public Book(String title, String author, String publisher, String releaseDate) {
        super(title, publisher, releaseDate);
        this.author = author;
        

    }
    
    /**
     * 
     * Prints out the information of the book.
     * 
     * @return Return the details of the book. Such as the serial number
     * ,the title, publisher and the release date.
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