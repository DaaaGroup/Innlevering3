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
                    System.out.println(this.register.showNewspapers());
                    break;

                    case 2:
                    System.out.println("\nPlease enter the following details for the newspaper:"
                        + "\nTitle, Publisher, number of days/weeks/months between each release");
                    this.registerNewspaper();
                    break;

                    case 3:
                    System.out.println(this.register.showNewspapers());
                    System.out.println("\nPlease select which Newspaper you want to remove.");
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
                System.out.println("\nERROR: Please provide a number between 1 and 4..+n");
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

    /**
     * This method registers a new newspaper to the array list.
     * It has direct interaction with the user and will print our error messages accordingly.
     * If the user inputs correct values for: Title, publisher & time between each release,
     * it will add a new newspaper to the register.
     * 
     * If the user inputs invalid values for: Title, publisher or time between each release,
     * the method will print out error message's saying what the user did wrong.
     */
    private void registerNewspaper()
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
                    int releaseDate = getInputInt();
                    if(releaseDate > 0)
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
            System.out.println("LAWL");
            userInput = true;
            /*if(register.removeNewspaper(menuSelection))
            {
                System.out.println("\nYou have successfully removed the specified newspaper");
                userInput = true;
            }
            else
            {
                System.out.println("\nERROR: That newspaper doesn't exist, please enter a valid number.");
                userInput = true;
            }*/
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
        System.out.println("3. Remove newspaper");
        System.out.println("4. Exit\n");
        System.out.println("Please choose menu item (1-5): ");

        int menuSelection = inputReader();
        if ((menuSelection < 1) || (menuSelection > 5)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // NOT FOR YOU ARNE ;)... YET
    /*
    /**
     * Returns a string with info on books matching search. Checks both name as it is and as lowercase
     * to avoid case-sensitivity. Will also return partial matches.
     * @param input will search for title or author matching input
     * @return returns string with info on all books matching search. each book will be separated with linebreak.
     */
    /*
    public String searchForTitleAndAuthor(String input){
    String matchingBooksString = "";
    for(Book selectedBook : booksList){
    if(selectedBook.getTitle().contains(input)){
    matchingBooksString += selectedBook.getInfoString() + "\n";
    }
    else if(selectedBook.getPublisher().contains(input)){
    matchingBooksString += selectedBook.getInfoString() + "\n";
    }
    else if(selectedBook.getTitle().toLowerCase().contains(input)){
    matchingBooksString += selectedBook.getInfoString() + "\n";
    }
    else if(selectedBook.getAuthor().toLowerCase().contains(input)){
    matchingBooksString += selectedBook.getInfoString() + "\n";
    }
    }
    return matchingBooksString;
    }   
     */
}