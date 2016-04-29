/**
 * This class represents a Newspaper in our newsstand application.
 * Stores the details of a newspaper.
 * The title, the publisher and how often it is released.
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
     * @param numberPerWeek How many times a week it is released.
     * @param releaseDate The release date.
     * @param type
     */
    public Newspaper(String title, String publisher, int numberPerWeek, String releaseDate, String type)
    {
        super(title, publisher, releaseDate, type);
        this.numberPerWeek = numberPerWeek;

    }

    /**
     * Returns how often the newspaper is released.
     * @return Returns how often the newspaper is released.
     */
    public int getNumberPerWeek()
    {
        return this.numberPerWeek;
    }

    /**
     * Buids up a string that describes each newspaper.
     * @return Returns all the details of the newspapers.
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