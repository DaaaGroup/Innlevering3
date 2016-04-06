
/**
 * Represents the different Books.
 * Books has following information:
 * The author of the book. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1, 
 */
public class Book extends Literature
{
    // Name of the author
    private String author;

    /**
     * 
     * @param title
     * @param publisher
     * @param every
     * @param releaseDate
     * @param daysWeeksMonths 
     */
    public Book(String title, String publisher,int every, int releaseDate, String daysWeeksMonths)
    {
        super(title, publisher, releaseDate);

    }
    
    @Override
    public String getLongDescription()
    {
        String newspaperDetails ="";/*
        for(Literature litterature : literatureInStock)
        {
            if(litterature instanceof Newspaper)
            {
                Newspaper newspaper = (Newspaper) litterature;
                newspaperDetails += "\n### NEWSPAPER " + newspaper.getSerialNumber() + " ###";
                newspaperDetails += "\nTitle: " + newspaper.getTitle();
                newspaperDetails += "\nPublisher: " + newspaper.getPublisher();
                newspaperDetails += "\nReleases every: " + newspaper.getEvery() + " " + newspaper.getDaysWeeksMonths();
            }
            if(litterature instanceof Magazine) {
                System.out.println("lol");
            }

        }*/
        return newspaperDetails;
    }
}
