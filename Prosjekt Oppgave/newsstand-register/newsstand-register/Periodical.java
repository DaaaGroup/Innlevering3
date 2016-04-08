/**
 * This class represents a Periodical in our newsstand application.
 * Stores the details of a Periodical.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */

public class Periodical extends Literature
{
    // Holds the number of how often the Periodical is released
    private final int numberPerWeek;
    

    /**
     * Creates a new periodical.
     * @param title Title of the periodical.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How many times a week it is released.
     * @param releaseDate The release date.
     */
    public Periodical (String title, String publisher, int numberPerWeek, String releaseDate)
    {
        super(title, publisher, releaseDate);
        this.numberPerWeek = numberPerWeek;
   
    }

    /**
     * Buids up a string that describes each periodical.
     * @return Returns all the details of the periodicals.
     */
    @Override
    public String getLongDescription()
    {
        String periodicalDetails ="";
        periodicalDetails += "\n### PERIODICAL " + getSerialNumber() + " ###";
        periodicalDetails += "\nTitle: " + getTitle();
        periodicalDetails += "\nPublisher: " + getPublisher();
        periodicalDetails += "\nReleases " + numberPerWeek + " times per week";
        periodicalDetails += "\nIssue released: " + getReleaseDate() + "\n";
        return periodicalDetails;
    }
}