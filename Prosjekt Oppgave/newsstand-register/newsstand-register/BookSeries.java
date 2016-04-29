/**
 * Represents the different BookSeries.
 * BookSeries has following information:
 * The author, the title, the publisher and the release date. 
 * 
 *
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland
 * @version 0.1
 */
public class BookSeries extends Literature {

    /**
     * Uses the super call to get the fields from the super class: Literature.
     * Creates the information that the BookSeries object needs. 
     *
     * @param title The title of the book series.
     * @param publisher The publisher of the book series.
     * @param type The type(category) of the product (book series).
     * @param releaseDate The date when the book series is released.
     */
    public BookSeries(String title, String publisher, String releaseDate, String type) {
        super(title, publisher, releaseDate, type);
    }

    /**
     * Prints out the information of the book series.
     * This method was used in the previous version of out text based UI.
     * @return Return the details of the book series. 
     * Such as the serial number, the title, publisher and the release date.
     */
    @Override
    public String getLongDescription() {
        String bookSeriesDetails = "";
        bookSeriesDetails += "\n### BOOKSERIES " + getSerialNumber() + " ###";
        bookSeriesDetails += "\nTitle: " + getTitle();
        bookSeriesDetails += "\nPublisher: " + getPublisher();
        bookSeriesDetails += "\nFirst book released: " + getReleaseDate() + "\n";
        return bookSeriesDetails;
    }
}