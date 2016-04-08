import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * A test class with the purpose of testing the Newspaper class,
 * and if it adds the different information for the newspaper properly.
 * Such as: title, publisher & how often it is released.
 *
 * Note: We havn't come up with any negative tests at this point,
 * but we hope to acheive that in the future.
 *
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class NewspaperTest
{
    /**
     * Default constructor for test class NewspaperTest
     */
    public NewspaperTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    
    
    /**
     * Positive test.
     * Tests that the title of the newspaper is added correctly.
     */
    /*
    @Test
    public void getTitleTest()
    {
        Newspaper newspape1 = new Newspaper("nettavisen", "nettavisen.no", 2, 1, "days");
        assertEquals("nettavisen", newspape1.getTitle());
    }
    */
    /**
     * Positive test.
     * Tests that the publisher of the newspaper is added correctly.
     */
    /*
    @Test
    public void getPublisherTest()
    {
        Newspaper newspape1 = new Newspaper("nettavisen", "nettavisen.no", 2, 1, "days");
        assertEquals("nettavisen.no", newspape1.getPublisher());
    }
*/
    /**
     * Positive test.
     * Tests that the amount of days between release days is added correctly.
     */
    /*
    @Test
    public void getEveryTest()
    {
        Newspaper newspape1 = new Newspaper("nettavisen", "nettavisen.no", 2, 1, "days");
        assertEquals(1, newspape1.getEvery());
    }
*/
    /**
     * Positive test.
     * Tests that the specified time between each release in days/months/weeks is added correctly.
     */
    /*
    @Test
    public void getDaysWeeksMonthsTest()
    {
        Newspaper newspape1 = new Newspaper("nettavisen", "nettavisen.no", 2, 1, "days");
        assertSame("days", newspape1.getDaysWeeksMonths());
    }
    */
}