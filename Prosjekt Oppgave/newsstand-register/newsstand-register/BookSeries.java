import java.util.ArrayList; 

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
    //List of books in this series
    private ArrayList<Book> booksInBookSeries;
    
    
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
        bookSeriesDetails += "\nBooks in this series:";
        for( Book book : booksInBookSeries) {
            bookSeriesDetails += "\n" + book.getLongDescriptionBookSeries();
        }
        return bookSeriesDetails;
    }
    
    public void addNewBook(Book newBook)
    {
      //  do something!;
    }
}
