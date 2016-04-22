import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
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
        ToolBar toolBar = createToolBar();
        
        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(toolBar);
        
        // Set the topContainer in the top of the borderpane
        borderPane.setTop(topContainer);
        borderPane.setLeft(toolBar);
        toolBar.setOrientation(Orientation.VERTICAL);
        
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
        
        // Add event handler
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
     * Creates the ToolBar to be displayed below the Menus.
     *
     * @return the tool bar to be displayed
     */
    private ToolBar createToolBar()
    {
        ToolBar toolBar = new ToolBar();
        //Create some Buttons.
        //Button listItem = new Button("List");
        Button registerItem = new Button("Register");
        Button removeItem = new Button("Remove");
        //Button exitApp = new Button("Exit");

        // Event Handling for buttons        
        //sexitApp.setOnAction(e -> closeProgram());

        //Add the Buttons to the ToolBar.
        toolBar.getItems().addAll(registerItem, removeItem);
        return toolBar;
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
        tableView.setItems(register.returnAllInventory());
        tableView.getColumns().addAll(titleColumn, publisherColumn);

        vbox.getChildren().add(tableView);
        return vbox;
    }
}