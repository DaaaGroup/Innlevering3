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
     * and waits for a user to input a value between 1-5,
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
                    this.addNewItemMenu();
                    break;

                    case 3:
                    this.removeItemMenu();
                    break;
                    
                    /*case 4:
                    this.searchForTitleOrPublisher(); //TODO
                    break;*/

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
        System.out.println("3. Remove item");
        //System.out.println("4. Search for items"); TODO - needs implementation in UI-class
        System.out.println("4. Exit\n");
        System.out.println("Please choose menu item (1-4): ");

        int menuSelection = getInputInt();
        if ((menuSelection < 1) || (menuSelection > 4)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    /**
     * 
     */
    private void addNewItemMenu()
    {
        boolean back = false;
        while(!back)
        {
            int menuSelection = this.showNewItemMenu();
            switch(menuSelection)
            {
                case 1:
                    this.registerNewBook(false);
                break;

                case 2:
                    this.convertBookToBookSeries();
                break;

                case 3:
                    this.registerNewMagazine();
                break;

                case 4:
                    this.registerNewNewspaper();
                break;
                
                case 5:
                    this.registerNewPeriodical();
                break;
                
                case 6:
                    back = true;
                break;

                default:    
            }
        }
    }
    
    /**
     * 
     * @return
     * @throws InputMismatchException 
     */
    private int showNewItemMenu() throws InputMismatchException
    {
        System.out.println("\n**** Please choose which item you want to register ****\n");
        System.out.println("1. New book");
        System.out.println("2. Convert book into bookseries");
        System.out.println("3. New magazine");
        System.out.println("4. New newspaper");
        System.out.println("5. New periodical");
        System.out.println("6. Go back\n");
        System.out.println("Please choose menu item (1-6): ");

        int menuSelection = getInputInt();
        if ((menuSelection < 1) || (menuSelection > 6)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    /**
     * 
     */
    private void newBookSeriesMenu()
    {
        boolean back = false;
        while(!back) {
            int menuSelection = this.showNewBookSeriesMenu();
            switch(menuSelection) {
                
                case 1:
                    //this.registerNewBook();
                    //periodical.addNewBook(this.registerNewBook())
                    break;
                
                case 2:
                    //this.registerNewBookSeries();
                    break;
                
                case 3:
                    back = true;
                    break;
                
                default:
            }
        }
    }
    
    /**
     * 
     * @return
     * @throws InputMismatchException 
     */   
    private int showNewBookSeriesMenu() throws InputMismatchException
    {
        System.out.println("\n**** Add new books to bookseries ****\n");
        System.out.println("1. Add book");
        System.out.println("2. Finish");
        System.out.println("3. Go back");
        System.out.println("Please choose menu item (1-3): ");

        int menuSelection = getInputInt();
        if ((menuSelection < 1) || (menuSelection > 3)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    /**
     * 
     */
    private void removeItemMenu()
    {
        boolean back = false;
        while(!back)
        {
            int menuSelection = this.showRemoveItemMenu();
            switch(menuSelection)
            {
                case 1:
                    this.printAllFromOneClass("books");
                    removeItem();
                break;

                case 2:
                    this.printAllFromOneClass("bookseries");
                    removeItem();
                break;

                case 3:
                    this.printAllFromOneClass("magazines");
                    removeItem();
                break;

                case 4:
                    this.printAllFromOneClass("newspapers");
                    removeItem();
                break;

                case 5:
                    this.printAllFromOneClass("periodicals");
                    removeItem();
                break;
                
                case 6:
                    back = true;
                break;

                default:    
            }
        }
    }
    
    /**
     * 
     * @return
     * @throws InputMismatchException 
     */
    private int showRemoveItemMenu() throws InputMismatchException
    {
        System.out.println("\n**** Please choose which category you want to remove an item from ****\n");
        System.out.println("1. Book");
        System.out.println("2. Bookseries");
        System.out.println("3. Magazine");
        System.out.println("4. Newspaper");
        System.out.println("5. Periodical");
        System.out.println("6. Go back\n");
        System.out.println("Please choose menu item (1-6): ");

        int menuSelection = getInputInt();
        if ((menuSelection < 1) || (menuSelection > 6)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    /**
     * 
     */
    private void registerNewBook(boolean belongsToBookSeries)
    { 
        System.out.println("Please enter the title of the book");
        String title = getInputString();
        if(!title.equals(""))
        {
            System.out.println("Please enter the books author:");
            String author = getInputString();
            if(!author.equals(""))
            {
                System.out.println("Please enter the books publisher");
                String publisher = getInputString();
                if(!publisher.equals(""))
                {
                    System.out.println("Please enter release date of the book");
                    String releaseDate = getInputString();
                    if(!releaseDate.equals(""))
                    {
                        register.addBook(title, author, publisher, releaseDate, belongsToBookSeries);
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
     * 
     */
    private void registerNewMagazine()
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
                        register.addMagazine(title, publisher, numberPerWeek, releaseDate);
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
     * This method registers a new newspaper to the array list.
     * It has direct interaction with the user and will print our error messages accordingly.
     * If the user inputs correct values for: Title, publisher & time between each release,
     * it will add a new newspaper to the register.
     * 
     * If the user inputs invalid values for: Title, publisher or time between each release,
     * the method will print out error message's saying what the user did wrong.
     */
    private void registerNewPeriodical()
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
                        register.addPeriodical(title, publisher, numberPerWeek, releaseDate);
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
    
    private void convertBookToBookSeries()
    {
        printAllFromOneClass("books");
        System.out.println("Please select which book you want to convert to a bookseries");
        int menuSelection = getInputInt();
        register.convertBook(menuSelection);
        register.removeItem(menuSelection);
    }
    
    /**
     * Waits for the user to specify which newspaper he/she wants to remove from the registry.
     * Prints out a message if the newspaper was successfully removed.
     * Prints out an error message if the newspaper doesn't exist.
     */
    private void removeItem()
    {
        boolean userInput = false;
        int menuSelection = getInputInt();

        while(!userInput)
        {
            userInput = true;
            if(register.removeItem(menuSelection))
            {
                System.out.println("\nYou have successfully removed the specified item");
                userInput = true;
            }
            else
            {
                System.out.println("\nERROR: That item doesn't exist, please enter a valid number.");
                userInput = true;
            }
        }
    }
    
    private void printAllFromOneClass(String className)
    {
        String stringToPrint = "";
        if( className.equals("books") ) {
            for( Literature literature : register.returnListOfItems(className)) {
                stringToPrint += literature.getLongDescription();
            }
        }
        else if ( className.equals("bookseries") ) {
            for( Literature literature : register.returnListOfItems(className)) {
                stringToPrint += literature.getLongDescription();
            }
        }
        else if ( className.equals("magazines") ) {
            for( Literature literature : register.returnListOfItems(className)) {
                stringToPrint += literature.getLongDescription();
            }
        }
        else if ( className.equals("newspapers") ) {
            for( Literature literature : register.returnListOfItems(className)) {
                stringToPrint += literature.getLongDescription();
            }
        }
        else if ( className.equals("periodicals") ) {
            for( Literature literature : register.returnListOfItems(className)) {
                stringToPrint += literature.getLongDescription();
            }
        }
        System.out.println(stringToPrint);
    }

    /**
     * Reads the menu selection input from the user in form of a number.
     * @return menuSelection Returns the menu selection input from the user in the terminal window.
     */
    public int getInputInt()
    {
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        return menuSelection;
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
}