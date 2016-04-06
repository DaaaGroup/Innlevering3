

/**
 * Represents the different littatures.
 * The litteratures have following details:
 * The title, the publisher, the release date and the serial number.
 * 
 *@author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 *@version 0.1
 */
public abstract class Literature
{
    // The title of the paper.
    private String title;
    // The name of the publisher.
    private String publisher;
    // When released
    private String releaseDate;
    //The serial number of the product
    private final int NUMBER;
    // Number of the product
    private static int numberOfProduct = 1;

    /**
     * Constructor for objects of class Literature
     * @param title
     * @param publisher
     * @param releaseDate
     */
    public Literature(String title, String publisher, String releaseDate)
    {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.NUMBER = numberOfProduct;
        numberOfProduct++;
    }

    /**
     * Returns the newspaper's serial number.
     * @return Returns the newspaper's serial number.
     */
    public int getSerialNumber()
    {
        return this.NUMBER;
    }

    /**
     * Returns the title of the newspaper.
     * @return Returns the title of the newspaper.
     */
    public String getTitle()
    {
        return this.title;
    }
    
    
    /**
     * Returns the name of the publisher.
     * @return Returns the name of the publisher.
     */
    public String getPublisher()
    {
        return this.publisher;
    }
    
    public String getReleaseDate()
    {
        return this.releaseDate;
    }
    
    public abstract String getLongDescription();
}
