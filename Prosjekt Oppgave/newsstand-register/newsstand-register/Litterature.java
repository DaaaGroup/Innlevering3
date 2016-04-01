
/**
 * Represents the different littatures.
 * The litteratures have following details:
 * The title, the publisher, the release date and the serial number.
 * 
 *@author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 *@version 0.1
 */
public class Litterature
{
    // The title of the paper.
    private String title;
    // The name of the publisher.
    private String publisher;
    // When released
    private int releaseDate;
    //The serial number of the product
    private final int NUMBER;
    // Number of the product
    private static int numberOfProduct = 1;

    /**
     * Constructor for objects of class Litterature
     */
    public Litterature(String title, String publisher, int releaseDate)
    {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        NUMBER=numberOfProduct;
        numberOfProduct++;
    }

    /**
     * Returns the newspaper's serial number.
     * @return Returns the newspaper's serial number.
     */
    public int getSerialNumber()
    {
        return NUMBER;
    }

    /**
     * Returns the title of the newspaper.
     * @return Returns the title of the newspaper.
     */
    public String getTitle()
    {
        return title;
    }
    
    
    /**
     * Returns the name of the publisher.
     * @return Returns the name of the publisher.
     */
    public String getPublisher()
    {
        return publisher;
    }    
}
