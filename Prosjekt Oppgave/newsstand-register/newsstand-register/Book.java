
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

    /**
     *
     * @param title
     * @param publisher
     * @param every
     * @param releaseDate
     * @param daysWeeksMonths
     */
    public Book(String title, String publisher, String releaseDate) {
        super(title, publisher, releaseDate);

    }

    @Override
    public String getLongDescription() {
        String newspaperDetails = "";
        newspaperDetails += "\n### BOOK " + getSerialNumber() + " ###";
        newspaperDetails += "\nTitle: " + getTitle();
        newspaperDetails += "\nPublisher: " + getPublisher();
        return newspaperDetails;
    }
}