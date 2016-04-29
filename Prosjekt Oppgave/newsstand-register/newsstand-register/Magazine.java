/**
 * This class represents a Magazine in our newsstand application.
 * Stores the details of a magazine.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class Magazine extends Literature
{
    // Holds the number of how often the newspaper is released
    private final int numberPerWeek;
    
    /**
     * Creates a new magazine.
     * @param title Title of the magazine.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How many times a week it is released.
     * @param releaseDate The release date.
     * @param type The type(category) of the product.
     */
    public Magazine (String title, String publisher, int numberPerWeek, String releaseDate, String type)
    {
        super(title, publisher, releaseDate, type);
        this.numberPerWeek = numberPerWeek;
    }

    /**
     * Buids up a string that describes each magazine.
     * This method was used in the previous version of out text based UI.
     * @return Returns all the details of the magazines.
     */
    @Override
    public String getLongDescription()
    {
        String magazineDetails ="";
        magazineDetails += "\n### MAGAZINE " + getSerialNumber() + " ###";
        magazineDetails += "\nTitle: " + getTitle();
        magazineDetails += "\nPublisher: " + getPublisher();
        magazineDetails += "\nReleases " + numberPerWeek + " times per week";
        magazineDetails += "\nIssue released: " + getReleaseDate() + "\n";
        return magazineDetails;
    }
}
