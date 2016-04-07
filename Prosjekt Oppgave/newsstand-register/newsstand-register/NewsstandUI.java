import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class represents the user interface of our Newsstand register.
 * 
 * @author Oscar Wika, Thomas Todal, Kristoffer Martinsen & Siv Furland 
 * @version 0.1
 */
public class NewsstandUI
{
    //
    private Register register = null;

    /**
     * Creates a new Newsstand user interface of the class Register.
     */
    public NewsstandUI()
    {
        this.register = new Register();
    }

    /**
     * This method works together with the "showMenu()" method.
     * It holds the different cases which are specified in the menu,
     * and waits for a user to input a value between 1-4,
     * depending on what actions the user wants to take.
     */
    void start()
    {
        boolean quit = false;

        while(!quit)
        {
            try {
                int menuSelection = this.showMenu();
                switch(menuSelection)
                {
                    case 1:
                    System.out.println(this.register.listAllInventory());
                    break;

                    case 2:
                    System.out.println("\nPlease enter the following details for the newspaper:"
                        + "\nTitle, Publisher, number of days/weeks/months between each release");
                    this.addNewItemMenu();
                    break;

                    case 3:
                    System.out.println(this.register.listAllInventory());
                    System.out.println("\nPlease select which Item you want to remove.");
                    this.waitForInput();
                    break;

                    case 4:
                    System.out.println("\nThank you for using our Newsstand Application v0.1. \nGoodbye!\n");
                    quit = true;
                    break;

                    default:    
                }
            } 
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and 4");
            }
        }
    }

    /**
     * Reads the text input from the terminal window.
     * @return newLine Returns the string input from the user in the terminal window.
     */
    private String getInputString()
    {
        Scanner reader = new Scanner(System.in);
        String newLine = reader.nextLine();
        return newLine;
    }

    /**
     * Reads the number input from the terminal window.
     * @return newNumber Returns the number input from the user in the terminal window.
     */
    private int getInputInt()
    {
        Scanner reader = new Scanner(System.in);
        int newNumber = reader.nextInt();
        return newNumber;
    }
    
    private int showNewItemMenu() throws InputMismatchException
    {
        System.out.println("\n**** Choose which item you want to register ****\n");
        System.out.println("1. New book");
        System.out.println("2. New periodical");
        System.out.println("3. New magazine");
        System.out.println("4. New newspaper");
        System.out.println("5. Go back\n");
        System.out.println("Please choose menu item (1-5): ");

        int menuSelection = inputReader();
        if ((menuSelection < 1) || (menuSelection > 5)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    private void addNewItemMenu()
    {
        boolean back = false;
        while(!back)
        {
            int menuSelection = this.showNewItemMenu();
            switch(menuSelection)
            {
                case 1:
                    //this.registerNewBook();
                break;

                case 2:
                    //this.registerNewPeriodical();
                break;

                case 3:
                    //this.registerNewMagazine();
                break;

                case 4:
                    this.registerNewNewspaper();
                break;
                
                case 5:
                    back = true;
                break;

                default:    
            }
        }
    }
    
  /*  private void registerNewBook()
    { 
        System.out.println("Please enter title");
        String title = getInputString();
        if(!title.equals(""))
        {
            System.out.println("Please enter publisher:");
            String publisher = getInputString();
            if(!publisher.equals(""))
            {
                System.out.println("Please enter number of days/weeks/months between release");
                int releasedEvery = getInputInt();
                if(releasedEvery > 0)
                {
                    System.out.println("Please enter release date");
                    String releaseDate = getInputString();
                    if(!releaseDate.equals(""))
                    {
                        System.out.println("Days/Weeks/months");
                        String daysWeeksMonths = getInputString();
                        if(!daysWeeksMonths.equals(""))
                        {
                            register.addNewspaper(title, publisher, releasedEvery, releaseDate, daysWeeksMonths);
                        }
                        else
                        {
                            System.out.println("Try again, you forgot to specify how often it releases.");
                        }
                    }
                    else
                    {
                        System.out.println("Some shit");
                    }
                }
                else
                {
                    System.out.println("Try again, you tried to add a invalid or negative number.");
                }
            }
            else
            {
                System.out.println("Try again, you forgot to add a publisher!");
            }
        }
        else
        {
            System.out.println("Try again, you forgot to add a title!");
        }
    }*/
    
   /* private void registerNewPeriodical()
    { 
        System.out.println("Please enter title");
        String title = getInputString();
        if(!title.equals(""))
        {
            System.out.println("Please enter publisher:");
            String publisher = getInputString();
            if(!publisher.equals(""))
            {
                System.out.println("Please enter number of days/weeks/months between release");
                int releasedEvery = getInputInt();
                if(releasedEvery > 0)
                {
                    System.out.println("Please enter release date");
                    String releaseDate = getInputString();
                    if(!releaseDate.equals(""))
                    {
                        System.out.println("Days/Weeks/months");
                        String daysWeeksMonths = getInputString();
                        if(!daysWeeksMonths.equals(""))
                        {
                            register.addNewspaper(title, publisher, releasedEvery, releaseDate, daysWeeksMonths);
                        }
                        else
                        {
                            System.out.println("Try again, you forgot to specify how often it releases.");
                        }
                    }
                    else
                    {
                        System.out.println("Some shit");
                    }
                }
                else
                {
                    System.out.println("Try again, you tried to add a invalid or negative number.");
                }
            }
            else
            {
                System.out.println("Try again, you forgot to add a publisher!");
            }
        }
        else
        {
            System.out.println("Try again, you forgot to add a title!");
        }
    }*/
    
    /*private void registerNewMagazine()
    { 
        System.out.println("Please enter title");
        String title = getInputString();
        if(!title.equals(""))
        {
            System.out.println("Please enter publisher:");
            String publisher = getInputString();
            if(!publisher.equals(""))
            {
                System.out.println("Please enter number of days/weeks/months between release");
                int releasedEvery = getInputInt();
                if(releasedEvery > 0)
                {
                    System.out.println("Please enter release date");
                    String releaseDate = getInputString();
                    if(!releaseDate.equals(""))
                    {
                        System.out.println("Days/Weeks/months");
                        String daysWeeksMonths = getInputString();
                        if(!daysWeeksMonths.equals(""))
                        {
                            register.addNewspaper(title, publisher, releasedEvery, releaseDate, daysWeeksMonths);
                        }
                        else
                        {
                            System.out.println("Try again, you forgot to specify how often it releases.");
                        }
                    }
                    else
                    {
                        System.out.println("Some shit");
                    }
                }
                else
                {
                    System.out.println("Try again, you tried to add a invalid or negative number.");
                }
            }
            else
            {
                System.out.println("Try again, you forgot to add a publisher!");
            }
        }
        else
        {
            System.out.println("Try again, you forgot to add a title!");
        }
    }*/

    /**
     * This method registers a new newspaper to the array list.
     * It has direct interaction with the user and will print our error messages accordingly.
     * If the user inputs correct values for: Title, publisher & time between each release,
     * it will add a new newspaper to the register.
     * 
     * If the user inputs invalid values for: Title, publisher or time between each release,
     * the method will print out error message's saying what the user did wrong.
     */
    private void registerNewNewspaper()
    { 
        System.out.println("Please enter title");
        String title = getInputString();
        if(!title.equals(""))
        {
            System.out.println("Please enter publisher:");
            String publisher = getInputString();
            if(!publisher.equals(""))
            {
                System.out.println("Please enter how many times per week this newspaper releases:");
                int numberPerWeek = getInputInt();
                if(numberPerWeek > 0)
                {
                    System.out.println("Please enter release date:");
                    String releaseDate = getInputString();
                    if(!releaseDate.equals(""))
                    {
                        register.addNewspaper(title, publisher, numberPerWeek, releaseDate);
                    }
                    else
                    {
                        System.out.println("Some shit");
                    }
                }
                else
                {
                    System.out.println("Try again, you tried to add a invalid or negative number.");
                }
            }
            else
            {
                System.out.println("Try again, you forgot to add a publisher!");
            }
        }
        else
        {
            System.out.println("Try again, you forgot to add a title!");
        }
    }
    
    /**
     * Waits for the user to specify which newspaper he/she wants to remove from the registry.
     * Prints out a message if the newspaper was successfully removed.
     * Prints out an error message if the newspaper doesn't exist.
     */
    private void waitForInput()
    {
        boolean userInput = false;
        int menuSelection = inputReader();

        while(!userInput)
        {
//            System.out.println("LAWL");
            userInput = true;
            if(register.removeNewspaper(menuSelection))
            {
                System.out.println("\nYou have successfully removed the specified newspaper");
                userInput = true;
            }
            else
            {
                System.out.println("\nERROR: That newspaper doesn't exist, please enter a valid number.");
                userInput = true;
            }
        }
    }

    /**
     * Reads the menu selection input from the user in form of a number.
     * @return menuSelection Returns the menu selection input from the user in the terminal window.
     */
    public int inputReader()
    {
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        return menuSelection;
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and 5. If the user inputs anything
     * else, an InputMismatchException is thrown. The method returns the valid
     * input from the user.
     *
     * @return the menu number (between 1 and 5) provided by the user.
     * @throws InputMismatchException
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Newsstand Application v0.1 ****\n");
        System.out.println("1. List all products");
        System.out.println("2. Register new product");
        System.out.println("3. Sell item");
        System.out.println("4. Exit\n");
        System.out.println("Please choose menu item (1-4): ");

        int menuSelection = inputReader();
        if ((menuSelection < 1) || (menuSelection > 4)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
}