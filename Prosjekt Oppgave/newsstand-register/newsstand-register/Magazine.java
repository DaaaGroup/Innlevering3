
/**
 * Write a description of class Magazine here.
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
     * @param numberPerWeek
     * @param releaseDate
     */
    public Magazine (String title, String publisher, int numberPerWeek, String releaseDate)
    {
        super(title, publisher, releaseDate);
        this.numberPerWeek = numberPerWeek;
   
    }

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
