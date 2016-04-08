
/**
 * Represents the different BookSeries.
 * BookSeries has following information:
 The author and the list of the Books. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1, 
 */
public class BookSeries extends Literature
{
    // Name of the author
    private String author;
    
    
    /**
     * 
     * @param title
     * @param publisher
     * @param releaseDate
     */
    public BookSeries(String title, String publisher, String releaseDate)
    {
        super(title, publisher, releaseDate);
    }
    
    @Override
    public String getLongDescription()
    {
        String bookSeriesDetails ="";
        bookSeriesDetails += "\n### BOOKSERIES " + getSerialNumber() + " ###";
        bookSeriesDetails += "\nTitle: " + getTitle();
        bookSeriesDetails += "\nPublisher: " + getPublisher();
        bookSeriesDetails += "\nFirst book released: " + getReleaseDate() + "\n";
        return bookSeriesDetails;
    }
    
    public void addNewBook(Book newBook)
    {
      //  do something!;
    }
}
