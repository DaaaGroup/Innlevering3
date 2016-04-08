
/**
 * Write a description of class Magazine here.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */

public class Periodical extends Literature
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
    public Periodical (String title, String publisher, int numberPerWeek, String releaseDate)
    {
        super(title, publisher, releaseDate);
        this.numberPerWeek = numberPerWeek;
   
    }

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