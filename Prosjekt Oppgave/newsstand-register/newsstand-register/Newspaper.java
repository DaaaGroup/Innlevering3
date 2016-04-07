/**
 * Stores the details of a newspaper.
 * The title, the publisher and how often it is released.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class Newspaper extends Literature
{
    // Holds the number of how often the newspaper is released
    private int numberPerWeek;
    // Spesifies how many days, weeks, or months there is between each release.
    private String daysWeeksMonths;

    /**
     * Creates a new Newspaper.
     * @param title Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param numberPerWeek
     * @param releaseDate
     * each release.
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
    public int getEvery()
    {
        return this.numberPerWeek;
    }

    /**
     * Returns specifically how often the newspaper is released in days, weeks or months.
     * @return Specifies how often the newspaper is released in days, weeks or months.
     */
    public String getDaysWeeksMonths()
    {
        return this.daysWeeksMonths;
    }

    @Override
    public String getLongDescription()
    {
        String newspaperDetails ="";

        newspaperDetails += "\n### NEWSPAPER " + getSerialNumber() + " ###";
        newspaperDetails += "\nTitle: " + getTitle();
        newspaperDetails += "\nPublisher: " + getPublisher();
        newspaperDetails += "\nReleases every: " + getEvery() + " " + getDaysWeeksMonths();
        return newspaperDetails;
    }
}
