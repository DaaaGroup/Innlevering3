import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Write a description of class Main here.
 * 
 * @author Oscar Wika
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
    
    TextField txt;
    
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
     * 
     * @param primaryStage
     * @throws Exception 
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
        
        txt = new TextField();
        borderPane.setCenter(borderPane2);
        borderPane2.setCenter(createCentreContent());
        borderPane2.setTop(txt);
        txt.setPromptText("Search...");
        
        
        txt.textProperty().addListener((v, oldValue, newValue) -> {
            
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
 
        
        // Status bar
        //borderPane.setBottom(createStatusBar());
        
        Scene scene = new Scene(borderPane, 717, 350);
        scene.getStylesheets().add("Stylesheet.css");
        primaryStage.setTitle("Newsstand Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private MenuBar createMenus() 
    {
        MenuBar menuBar = new MenuBar();
    
        // First Menu Option
        Menu optionMenu = new Menu("Options");
        MenuItem testItem1 = new MenuItem("insertOption1");
        MenuItem testItem2 = new MenuItem("insertOption2");
        MenuItem testItem3 = new MenuItem("Exit");
        optionMenu.getItems().addAll(testItem1, testItem2);
        optionMenu.getItems().add(new SeparatorMenuItem());
        optionMenu.getItems().add(testItem3);
        
        // Event handler
        testItem1.setOnAction((ActionEvent event) -> {
            System.out.println("insertOption1 was selected...");
        });
        
        testItem2.setOnAction((ActionEvent event) -> {
            System.out.println("insertOption2 was selected...");
        });
        
        testItem3.setOnAction((ActionEvent event) -> {
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
            doShowAboutDialog();
        });

        menuBar.getMenus().addAll(optionMenu, helpMenu);

        return menuBar;
    }
    
    /**
     * 
     * @return 
     */
    private TreeView createTree() {
        TreeItem<String> root, registerProduct, removeProduct;
        
        // Main
        root = new TreeItem<>();
        root.setExpanded(true);
        
        // Register branch 
        registerProduct = makeBranch("Register", root);
        makeBranch("Newspaper", registerProduct);
        makeBranch("Magazine", registerProduct);
        makeBranch("Periodical", registerProduct);
        makeBranch("Book", registerProduct);
        makeBranch("Book Series", registerProduct);
        
        // Remove branch 
        removeProduct = makeBranch("Features", root);
        
        makeBranch("Remove", removeProduct);
        makeBranch("Convert book\nto series", removeProduct);
        
            
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
     * 
     * @param selectedItem 
     */
    private void addLiterature(TreeItem<String> selectedItem){
        // NEWSPAPER
        if(selectedItem.getValue().equals("Newspaper")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Remove newspaper");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register newspaper");
                doAddNewspaper();
            }}
        // MAGAZINE
        if(selectedItem.getValue().equals("Magazine")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Remove Magazine");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Magazine");
                doAddMagazine();
            }}
        // PERIODICAL
        if(selectedItem.getValue().equals("Periodical")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Remove Periodical");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Periodical");
                doAddPeriodical();
            }}
        // BOOK
        if(selectedItem.getValue().equals("Book")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Remove Book");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book");
                doAddBook();
            }}
        // BOOK SERIES
        if(selectedItem.getValue().equals("Book Series")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Remove Book Series");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book Series");
                doAddBookSeries();
            }}
        updateObservableList();
    }
    
    /**
     * Create Branches
     * @param title
     * @param parent
     * @return 
     */
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }
    

     /**
     * Creates the StatusBar to be displayed at the bottom of the window.
     *
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
     *
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
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        
        
        // The releaseDate-column
        /*TableColumn<Literature, String> releaseDateColumn = new TableColumn<>("Release Date");
        categoryColumn.setMinWidth(170);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));*/

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
       Literature registerProduct. Call this method whenever changes are made to the
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
     * Remove method 
     * @param selectedItem 
     */
    private void removeLiterature(TreeItem<String> selectedItem) {
       // NEWSPAPER
        if(selectedItem.getValue().equals("Remove")){
            if(selectedItem.getParent().getValue().equals("Features")){
                System.out.println("Spesified literature removed");
                litReg.removeItem(tableView.getSelectionModel().getSelectedItem());
            }
        updateObservableList();
    }}
    
    
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
            //updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
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
            //updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
    
    /**
     * Method for adding periodicals
     */
    private void doAddPeriodical()
    {
        PeriodicalDetailsDialog perDialog = new PeriodicalDetailsDialog();

        Optional<Periodical> result = perDialog.showAndWait();

        if (result.isPresent())
        {
            Periodical periodical = result.get();
            litReg.addLiterature(periodical);
            //updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }    
    
    /**
     * Method for adding periodicals
     */
    private void doAddBook()
    {
        BookDetailsDialog bookDialog = new BookDetailsDialog();

        Optional<Book> result = bookDialog.showAndWait();

        if (result.isPresent())
        {
            Book book = result.get();
            litReg.addLiterature(book);
            //updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
        }
    }
        
    /**
     * Method for adding periodicals
     */
    private void doAddBookSeries()
    {
        BookSeriesDetailsDialog bookSeriesDialog = new BookSeriesDetailsDialog();

        Optional<BookSeries> result = bookSeriesDialog.showAndWait();

        if (result.isPresent())
        {
            BookSeries bookSeries = result.get();
            litReg.addLiterature(bookSeries);
            //updateObservableList();
            System.out.println("Number of items in litReg: " + litReg.getSize());
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
     * Exit the application. Displays a confirmation dialog.
     */
    private void doExitApplication()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Unsaved files");
        alert.setContentText("Are you sure you want to exit this application?");
        
        /*alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        //Deactivate Defaultbehavior for yes-Button:
        Button yesButton = (Button) alert.getDialogPane().lookupButton( ButtonType.OK );
        yesButton.setDefaultButton( false );

        //Activate Defaultbehavior for no-Button:
        Button noButton = (Button) alert.getDialogPane().lookupButton( ButtonType.CANCEL );
        noButton.setDefaultButton( false );*/

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK)
        {
            // ... user chose OK
            System.exit(0);
        } else
        {
            // ... user chose CANCEL or closed the dialog
            // then do nothing.
        }
    }
}