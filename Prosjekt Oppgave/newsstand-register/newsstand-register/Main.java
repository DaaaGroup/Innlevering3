import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class represents the GUI(User Interface) of our Newsstand Register application.
 * 
 * @author Oscar Wika, Thomas Todal, Siv Furland & Kristoffer Martinsen.
 * @version innlevering 5
 */
public class Main extends Application 
{
    Button button;
    Button button2;
    Stage window;
    //Register register = new Register();
    TableView<Literature> tableView;
    private ObservableList<Literature> literatures;
    TreeView<String> tree;
    TextField searchField;
    
    private Register litReg;
    
    @Override
    public void init()
    {
        litReg = new Register();
    }
    
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args){
        launch(args);
    }
    
    /**
     * Method to exit the application.
     */
    @Override
    public void stop(){
        System.exit(0);
    }
    
    /**
     * Method that starts the program and sets it up the user interface.
     * @param primaryStage The main window, the stage of the GUI.
     * @throws Exception Throws any exception that might occur.
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        literatures = FXCollections.observableArrayList();
        // Close window confirmation
            primaryStage.setOnCloseRequest(e -> {
            e.consume();
            doExitApplication();
        });
        
        // Window
        BorderPane borderPane = new BorderPane();
        BorderPane borderPane2 = new BorderPane();
        VBox topContainer = new VBox();
        MenuBar mainMenu = createMenus();
        VBox scaryVBox = new VBox (createTree());
        
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(scaryVBox);
        
        // Set the topContainer in the top of the borderpane
        borderPane.setTop(topContainer);
        borderPane.setLeft(scaryVBox);
        
        searchField = new TextField();
        borderPane.setCenter(borderPane2);
        borderPane2.setCenter(createCentreContent());
        borderPane2.setTop(searchField);
        searchField.setPromptText("Search...");
        
        
        searchField.textProperty().addListener((v, oldValue, newValue) -> {
            
            ArrayList<Literature> searchResult = litReg.searchForLiterature(newValue);
            if(newValue.length() > 0)
            {
            literatures.clear();
            literatures.addAll(searchResult);
            } else {
                literatures.clear();
                literatures.addAll(litReg.returnAllInventory());
            }
            
        });
        
        Scene scene = new Scene(borderPane, 717, 350);
        scene.getStylesheets().add("Stylesheet.css");
        primaryStage.setTitle("Newsstand Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Creates the top Menu.
     * @return menuBar Returns the menuBar. 
     */
    private MenuBar createMenus() 
    {
        MenuBar menuBar = new MenuBar();
    
        // First Menu Option
        Menu optionMenu = new Menu("Options");
        MenuItem removeItem = new MenuItem("Remove");
        MenuItem convertItem = new MenuItem("Convert");
        MenuItem exitItem = new MenuItem("Exit");
        optionMenu.getItems().addAll(removeItem, convertItem);
        optionMenu.getItems().add(new SeparatorMenuItem());
        optionMenu.getItems().add(exitItem);
        
        // Event handler
        removeItem.setOnAction((ActionEvent event) -> {
            litReg.removeItem(tableView.getSelectionModel().getSelectedItem());
            updateObservableList();
        });
        
        convertItem.setOnAction((ActionEvent event) -> {
            litReg.addBookSeries(tableView.getSelectionModel().getSelectedItem());
            updateObservableList();
        });
        
        exitItem.setOnAction((ActionEvent event) -> {
            doExitApplication();
        });

        // Second Menu Option
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        MenuItem helpContentItem = new MenuItem("Help Contents");
        helpMenu.getItems().addAll(aboutItem, helpContentItem);
        
        aboutItem.setOnAction((ActionEvent event) -> {
            doShowAboutDialog();
        });
        
        helpContentItem.setOnAction((ActionEvent event) -> {
            doManualDialog();
        });

        menuBar.getMenus().addAll(optionMenu, helpMenu);

        return menuBar;
    }
    
    /**
     * Creates the a TreeView "menu" which is located on the left in our application.
     * @return Returns the treeView menu.
     */
    private TreeView createTree() {
        TreeItem<String> root, registerBranch, featuresBranch;
        
        // Main
        root = new TreeItem<>();
        root.setExpanded(true);
        
        // Register branch 
        registerBranch = makeBranch("Register", root);
        makeBranch("Newspaper", registerBranch);
        makeBranch("Magazine", registerBranch);
        makeBranch("Periodical", registerBranch);
        makeBranch("Book", registerBranch);
        makeBranch("Book Series", registerBranch);
        
        // Remove branch 
        featuresBranch = makeBranch("Features", root);
        
        makeBranch("Remove", featuresBranch);
        makeBranch("Convert book\nto series", featuresBranch);
        
            
        // Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.setPrefWidth(115);
        
        // ENTER KEY
        tree.setOnKeyPressed((KeyEvent ke) -> {
            if(ke.getCode().equals(KeyCode.ENTER))
            {
                if(tree.getSelectionModel().getSelectedItem().getParent().getValue() == null)
                {}
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Register")){
                addLiterature(tree.getSelectionModel().getSelectedItem());
                }
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Features")){
                removeLiterature(tree.getSelectionModel().getSelectedItem());
            }
            }
            
        });
        
        // DOUBLE CLICK
        tree.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2)
                {
                if(tree.getSelectionModel().getSelectedItem().getParent().getValue() == null){
                    
                }
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Register")){
                addLiterature(tree.getSelectionModel().getSelectedItem());
                }
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Features")){
                removeLiterature(tree.getSelectionModel().getSelectedItem());
            }
            }
            }
        });
        return tree;
    }
    
    /**
     * Method for adding different types of litterature
     * @param selectedItem The item the user selects in the tree.
     */
    private void addLiterature(TreeItem<String> selectedItem){
        // NEWSPAPER
        if(selectedItem.getValue().equals("Newspaper")){
            if(selectedItem.getParent().getValue().equals("Register"))
            {
                //System.out.println("Register newspaper");
                doAddNewspaper();
            }}
        // MAGAZINE
        if(selectedItem.getValue().equals("Magazine")){
            if(selectedItem.getParent().getValue().equals("Register"))
            {
                //System.out.println("Register Magazine");
                doAddMagazine();
            }}
        // PERIODICAL
        if(selectedItem.getValue().equals("Periodical")){
            if(selectedItem.getParent().getValue().equals("Register"))
            {
                //System.out.println("Register Periodical");
                doAddPeriodical();
            }}
        // BOOK
        if(selectedItem.getValue().equals("Book")){
            if(selectedItem.getParent().getValue().equals("Register"))
            {
                //System.out.println("Register Book");
                doAddBook();
            }}
        // BOOK SERIES
        if(selectedItem.getValue().equals("Book Series")){
            if(selectedItem.getParent().getValue().equals("Register"))
            {
                //System.out.println("Register Book Series");
                doAddBookSeries();
            }}
        updateObservableList();
    }
    
    /**
     * Create Branches in the tree menu.
     * @param title The title of the branch item.
     * @param parent The parent of the branch item.
     * @return item 
     */
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }
    
     /**
     * Creates the StatusBar to be displayed at the bottom of the window.
     * @return the StatusBar as a Node
     */
    private Node createStatusBar()
    {
        HBox statusBar = new HBox();
        statusBar.setStyle("-fx-background-color: #999999;");
        statusBar.getChildren().add(new Text("OPTIONAL STATUS BAR"));

        return statusBar;
    }
    
    /**
     * Creates the content of the center section of the GUI.
     * @return the node to be placed in the center of the BorderPane
     */
    private Node createCentreContent()
    {
        VBox vbox = new VBox();
        
        // Define the columns
        // The Title-column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
 
        // The Category-column
        TableColumn<Literature, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setMinWidth(200);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        tableView = new TableView();
        tableView.setItems(literatures);
        tableView.getColumns().addAll(titleColumn, publisherColumn, categoryColumn);
        
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        vbox.getChildren().add(tableView);
        return vbox;
    }
    
    /**
     * Returns an ObservableList holding the literatures to display.
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLiteratureList()
    {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures
                = FXCollections.observableArrayList();
        return literatures;
    }

    /**
     * Updates the ObservableArray wrapper with the current content in the
       Literature registerBranch. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    private void updateObservableList()
    {
        literatures.clear();
        for(Literature literature : litReg.returnAllInventory()){
            literatures.add(literature);
        }
    }

    /**
     * Method for removing literature.
     * @param selectedItem The item the user selects in the tree.
     */
    private void removeLiterature(TreeItem<String> selectedItem) {
        if(selectedItem.getValue().equals("Remove")){
            if(selectedItem.getParent().getValue().equals("Features")){
                //System.out.println("Spesified literature removed");
                litReg.removeItem(tableView.getSelectionModel().getSelectedItem());
            }}
        if(selectedItem.getValue().equals("Convert book\nto series")){
            if(selectedItem.getParent().getValue().equals("Features")){
                //System.out.println("Book converted to Book Series");
                litReg.addBookSeries(tableView.getSelectionModel().getSelectedItem());
            }}
        updateObservableList();
    }
    
    
    /**
     * Method for adding newspapers.
     */
    private void doAddNewspaper()
    {
        NewspaperDetailsDialog npDialog = new NewspaperDetailsDialog();

        Optional<Newspaper> result = npDialog.showAndWait();

        if (result.isPresent())
        {
            Newspaper newspaper = result.get();
            litReg.addLiterature(newspaper);
            //System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
    
    /**
     * Method for adding magazine.
     */
    private void doAddMagazine()
    {
        MagazineDetailsDialog mgDialog = new MagazineDetailsDialog();

        Optional<Magazine> result = mgDialog.showAndWait();

        if (result.isPresent())
        {
            Magazine magazine = result.get();
            litReg.addLiterature(magazine);
            //System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
    
    /**
     * Method for adding periodicals.
     */
    private void doAddPeriodical()
    {
        PeriodicalDetailsDialog perDialog = new PeriodicalDetailsDialog();

        Optional<Periodical> result = perDialog.showAndWait();

        if (result.isPresent())
        {
            Periodical periodical = result.get();
            litReg.addLiterature(periodical);
            //System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }    
    
    /**
     * Method for adding books.
     */
    private void doAddBook()
    {
        BookDetailsDialog bookDialog = new BookDetailsDialog();

        Optional<Book> result = bookDialog.showAndWait();

        if (result.isPresent())
        {
            Book book = result.get();
            litReg.addLiterature(book);
            //System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
        
    /**
     * Method for adding book series.
     */
    private void doAddBookSeries()
    {
        BookSeriesDetailsDialog bookSeriesDialog = new BookSeriesDetailsDialog();

        Optional<BookSeries> result = bookSeriesDialog.showAndWait();

        if (result.isPresent())
        {
            BookSeries bookSeries = result.get();
            litReg.addLiterature(bookSeries);
            //System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
    
    /**
     * Displays an example of an alert (info) dialog. In this case an "about"
     * type of dialog.
     */
    private void doShowAboutDialog()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Newsstand Register");
        alert.setContentText("Authors:"
                + "\nOscar Wika, Siv Furland, Thomas Todal & Kristoffer Martinsen\n"
                + "\nSubject:\nObjektorientert Programmering (ID101912)\n"
                + "\nVersion: \n0.1 2016-04-29");
        alert.showAndWait();
    }
    
    /**
     * Displays an example of an alert (info) dialog. In this case an "about"
     * type of dialog.
     */
    private void doManualDialog()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Manual");
        alert.setHeaderText("User Manual");
        alert.setContentText("How to register a product:"
                    + "\n1. Open the \"Register\" menu on the left." 
                    + "\n2. Select the product type you wish to register."
                    + "\n3. Press enter or double click the product type.\n"
                    + "\n How to remove a product:"
                    + "\n 1. Open the \"Features\" menu on the left."
                    + "\n 2. Select a product in the table."
                    + "\n 3. Select \"Remove\" in the menu on the left."
                    + "\n 4. Press enter or double click on \"Remove\".\n"
                    + "\n How to convert a Book to Book Series:"
                    + "\n 1. Select the book you wish to convert in the table:"
                    + "\n 2. Open the \"Features\" menu on the left."
                    + "\n 3. Select \"Convert\" in the menu on the left."
                    + "\n 3. Press enter or double click on \"Convert\"."
                    + "\n\n If you encounter any issues while using our program,"
                    + "\n please contact us at: oscar_wika@hotmail.com");
        alert.showAndWait();
        alert.setHeaderText("halo");
    }
    
    /**
     * Exit the application. Displays a confirmation dialog.
     */
    private void doExitApplication()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Exit");
        alert.setHeaderText("Unsaved files");
        alert.setContentText("Our program doesn't support file saving at the moment."
                        + "\nDo you still wish to exit the application?");

        
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        
        //Deactivate Defaultbehavior for yes-Button:
        Button yesButton = (Button) alert.getDialogPane().lookupButton( ButtonType.YES );
        yesButton.setDefaultButton( true );

        //Activate Defaultbehavior for no-Button:
        Button noButton = (Button) alert.getDialogPane().lookupButton( ButtonType.NO );
        noButton.setDefaultButton( false );
        
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.YES)
        {
            System.exit(0);
        } else
        {
            // ... user chose CANCEL or closed the dialog
            // then do nothing.
        }
    }
}