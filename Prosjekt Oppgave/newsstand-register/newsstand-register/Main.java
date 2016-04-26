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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    Register register = new Register();
    private ObservableList<Literature> literatures;
    
    private ComboBox<Object> comboBox;
    private ComboBox<Object> comboBox2;
    
    TreeView<String> tree;
    
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
        // Close window confirmation
            primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        // Window
        BorderPane borderPane = new BorderPane();
        VBox topContainer = new VBox();
        MenuBar mainMenu = createMenus();
        VBox scaryVBox = new VBox (createTree());
        
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(scaryVBox);
        
        // Set the topContainer in the top of the borderpane
        borderPane.setTop(topContainer);
        borderPane.setLeft(scaryVBox);
        //toolBar.setOrientation(Orientation.VERTICAL);
        
        
        borderPane.setCenter(createCentreContent());
        
        // Status bar
        borderPane.setBottom(createStatusBar());
        
        Scene scene = new Scene(borderPane, 550, 350);
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
            closeProgram();
        });

        // Second Menu Option
        Menu aboutMenu = new Menu("About");
        
        /*// Third Menu Option
        Menu menuView = new Menu("3rd Menu");*/

        menuBar.getMenus().addAll(optionMenu, aboutMenu);

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
        removeProduct = makeBranch("Remove", root);
        makeBranch("Newspaper", removeProduct);
        makeBranch("Magazine", removeProduct);
        makeBranch("Periodical", removeProduct);
        makeBranch("Book", removeProduct);
        makeBranch("Book Series", removeProduct);
            
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
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Remove")){
                removeLiterature(tree.getSelectionModel().getSelectedItem());
            }
            }
            
        });
        
        // DOUBLE CLICK
        tree.setOnMouseClicked((MouseEvent mouseEvent) -> {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                if(mouseEvent.getClickCount() == 2)
                {
                if(tree.getSelectionModel().getSelectedItem().getParent().getValue() == null)
                {}
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Register")){
                addLiterature(tree.getSelectionModel().getSelectedItem());
                }
                else if(tree.getSelectionModel().getSelectedItem().getParent().getValue().equals("Remove")){
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
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove newspaper");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register newspaper");
            }}
        // MAGAZINE
        if(selectedItem.getValue().equals("Magazine")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Magazine");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Magazine");
            }}
        // PERIODICAL
        if(selectedItem.getValue().equals("Periodical")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Periodical");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Periodical");
            }}
        // BOOK
        if(selectedItem.getValue().equals("Book")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Book");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book");
            }}
        // BOOK SERIES
        if(selectedItem.getValue().equals("Book Series")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Book Series");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book Series");
            }}
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

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Unsaved files", "Are you sure you want to Exit?");
        if(answer)
            System.exit(0);
    }
    
    /**
     * Creates the content of the center section of the GUI.
     *
     * @return the node to be placed in the center of the BorderPane
     */
    private Node createCentreContent()
    {
        VBox vbox = new VBox();
        TableView tableView;

        // Define the columns
        // The Title-column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        tableView = new TableView();
        tableView.setItems(this.getLiteratureList());
        tableView.getColumns().addAll(titleColumn, publisherColumn);

        vbox.getChildren().add(tableView);
        return vbox;
    }
    
    /**
     * Returns an ObservableList holding the literatures to display.
     *
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLiteratureList()
    {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures
                = FXCollections.observableArrayList(this.register.returnAllInventory());
        return literatures;
    }

    /**
     * Updates the ObservableArray wrapper with the current content in the
 Literature registerProduct. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    private void updateObservableList()
    {
        this.literatures.setAll(this.register.returnAllInventory());
    }

    private void removeLiterature(TreeItem<String> selectedItem) {
       // NEWSPAPER
        if(selectedItem.getValue().equals("Newspaper")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove newspaper");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register newspaper");
            }}
        // MAGAZINE
        if(selectedItem.getValue().equals("Magazine")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Magazine");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Magazine");
            }}
        // PERIODICAL
        if(selectedItem.getValue().equals("Periodical")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Periodical");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Periodical");
            }}
        // BOOK
        if(selectedItem.getValue().equals("Book")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Book");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book");
            }}
        // BOOK SERIES
        if(selectedItem.getValue().equals("Book Series")){
            if(selectedItem.getParent().getValue().equals("Remove")){
                System.out.println("Remove Book Series");
            }
            else if(selectedItem.getParent().getValue().equals("Register"))
            {
                System.out.println("Register Book Series");
            }}
    }
}