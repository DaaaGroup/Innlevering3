/**
 * Stores the details of a newspaper.
 * Keeps track of how many releases there are per week.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class Newspaper extends Literature
{
    // Holds the number of how often the newspaper is released
    private final int numberPerWeek;

    /**
     * Creates a new Newspaper.
     * @param title Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param numberPerWeek How many releases there are per week.
     * @param releaseDate The release date
     */
    public Newspaper(String title, String publisher, int numberPerWeek, String releaseDate)
    {
        super(title, publisher, releaseDate);
        this.numberPerWeek = numberPerWeek;

    }

    /**
     * How often the newspaper is released.
     * @return How often the newspaper is released.
     */
    public int getNumberPerWeek()
    {
        return this.numberPerWeek;
    }

    /**
     * Gets all the information about the newspaper. The serial number, 
     * the title, the publisher, how many releases per week and the release date 
     * and stores it in a String.
     * 
     * @return newspaperDetails A String wirh all the information about the newspaper.
     */
    @Override
    public String getLongDescription()
    {
        String newspaperDetails ="";

        newspaperDetails += "\n### NEWSPAPER " + getSerialNumber() + " ###";
        newspaperDetails += "\nTitle: " + getTitle();
        newspaperDetails += "\nPublisher: " + getPublisher();
        newspaperDetails += "\nReleases " + numberPerWeek + " times per week";
        newspaperDetails += "\nIssue released: " + getReleaseDate() + "\n";
        return newspaperDetails;
    }
}
