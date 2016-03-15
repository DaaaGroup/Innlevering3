/**
 * Stores the details of a newspaper.
 * The title, the publisher and how often it is released.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class Newspaper
{
    // The title of the paper.
    private String paperTitle ;
    // The name of the publisher.
    private String paperPublisher;
    // Holds the number of how often the newspaper is released
    private int releasedEvery;
    // Spesifies how many days, weeks, or months there is between each release.
    private String daysWeeksMonths;
    // Number of the newspaper
    private static int numberOfNewspapers = 1;
    // The serial number of the newspaper
    private final int NUMBER;
    
    /**
     * Creates a new Newspaper.
     * @param title Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param every How often the newspaper is released.
     * @param daysWeeksMonths Specified how many days, weeks or months there is between 
     * each release.
     */
    public Newspaper(String title, String publisher,int every, String daysWeeksMonths)
    {
        paperTitle = title;
        paperPublisher = publisher;
        releasedEvery = every;
        this.daysWeeksMonths = daysWeeksMonths;
        NUMBER=numberOfNewspapers;
        numberOfNewspapers++;
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
        return paperTitle;
    }
    
    /**
     * Returns the name of the publisher.
     * @return Returns the name of the publisher.
     */
    public String getPublisher()
    {
        return paperPublisher;
    }
    
    /**
     * How often the newspaper is released.
     * @return How often the newspaper is released.
     */
    public int getEvery()
    {
        return releasedEvery;
    }
    
    /**
     * Returns specifically how often the newspaper is released in days, weeks or months.
     * @return Spesifies how often the newspaper is released in days, weeks or months.
     */
    public String getDaysWeeksMonths()
    {
        return daysWeeksMonths;
    }
}
