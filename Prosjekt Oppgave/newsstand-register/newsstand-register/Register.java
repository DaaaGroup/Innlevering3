import java.util.ArrayList;
/**
 * This class is a register that represents the offers of reading material that the
 * newsstand has available at any time.
 * Currently it only contains newspapers. 
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */

public class Register
{
    // The list of Newspapers in this register
    private ArrayList<Newspaper> newspapers;

    /**
     * Creates a new register object with an array list of newspapers.
     */
    public Register()
    {
        newspapers = new ArrayList<Newspaper>();
    }

    /**
     * Creates a new Newspaper.
     * @param title     Title of the newspaper.
     * @param publisher Name of the publisher.
     * @param every     How often the newspaper is released.
     * @param daysWeeksMonths Specified how many days, weeks or months there is between 
     * each release.
     */
    public void addNewspaper(String title, String publisher, int every, String daysWeeksMonths)
    {
        newspapers.add(new Newspaper(title, publisher, every, daysWeeksMonths));
    }

    /**
     * An acessor method that prints out relevant information about all the newpapers.
     * Such as: Title, publisher & amount of time between releases.
     */
    public String showNewspapers()
    {
        String newspaperDetails ="";
        for(Newspaper newspaper : newspapers)
        {
            newspaperDetails += "\n### NEWSPAPER " + newspaper.getSerialNumber() + " ###";
            newspaperDetails += "\nTitle: " + newspaper.getTitle();
            newspaperDetails += "\nPublisher: " + newspaper.getPublisher();
            newspaperDetails += "\nReleases every: " + newspaper.getEvery() + " " + newspaper.getDaysWeeksMonths();
        }
        return newspaperDetails;
    }

    /**
     * Removes a spesified newspaper from the register.
     * @param serialNumber The number of the newspaper you wish to remove.
     */
    public boolean removeNewspaper(int serialNumber)
    {
        boolean success = false;
        if(-1 != newspaperIndex(serialNumber))
        {
            newspapers.remove(newspaperIndex(serialNumber));
            success = true;
        }
        else
        {
            success = false;
        }
        return success;
    }
    
    /**
     * Returns the index of the newspaper.
     * @param serialNumber The serial number of the newspaper. 
     * @return index Returns the index of the newspaper.
     */
    public int newspaperIndex(int serialNumber)
    {
        //
        int index = -1;
        for( Newspaper newspaper : newspapers)
        {
            if( serialNumber == newspaper.getSerialNumber() )
            {
                index = this.newspapers.indexOf(newspaper);
            }
        }
        return index;
    }

    /*/**
     * Dummy for newspaper objects to test if the register works.
     */
    /*public void addDummyObjects()
    {
        addNewspaper("VG", "VG", 3, "days");
        addNewspaper("Sunnmørsposten", "smp.no", 5, "years");
        addNewspaper("Brønnøysund Avis", "banett.no", 3, "weeks");
        System.out.println("Dummy objects sucessfully added.");
    }*/
}
