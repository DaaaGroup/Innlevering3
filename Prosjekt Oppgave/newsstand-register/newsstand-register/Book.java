
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
    private String author;
    private boolean belongsToPeriodical;

    /**
     *
     * @param title
     * @param publisher
     * @param every
     * @param releaseDate
     * @param daysWeeksMonths
     */
    public Book(String title, String author, String publisher, String releaseDate, boolean belongsToPeriodical) {
        super(title, publisher, releaseDate);
        this.author = author;
        this.belongsToPeriodical = belongsToPeriodical;
        

    }
    
    public boolean getBelongsToPeriodical() 
    {
        return belongsToPeriodical;
    }

    @Override
    public String getLongDescription()
    {
        String bookDetails = "";
        if(!belongsToPeriodical) {
            bookDetails += "\n### BOOK " + getSerialNumber() + " ###";
            bookDetails += "\nTitle: " + getTitle();
            bookDetails += "\nAuthor: " + author;
            bookDetails += "\nPublisher: " + getPublisher();
            bookDetails += "\nReleasedate: " + getReleaseDate() + "\n";
        }
        return bookDetails;
    }
    
    public String getLongDescriptionBookSeries() {
        String bookDetails = "";
        bookDetails += "\n### BOOK " + getSerialNumber() + " ###";
        bookDetails += "\nTitle: " + getTitle();
        bookDetails += "\nAuthor: " + author;
        bookDetails += "\nPublisher: " + getPublisher();
        bookDetails += "\nReleasedate: " + getReleaseDate() + "\n";
        return bookDetails;
    }
}