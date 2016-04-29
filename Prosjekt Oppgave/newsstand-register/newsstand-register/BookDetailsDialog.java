import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * A dialog used to get the necessary information about a magazine from the
 * user, in order to be able to create a Magazine instance to be added
 * to the register.
 *
 * @author asty & Oscar Wika
 */

public class BookDetailsDialog extends Dialog<Book>
{

    private TextField title;
    private TextField publisher;
    private TextField author;
    private TextField releaseDate;
    private Node loginButton;
    
    
    /**
     * Creates an instance of the MagazineDetails dialog
     */
    public BookDetailsDialog()
    {
        super();
        setTitle("Periodical Details");
        
        ButtonType loginButtonType = ButtonType.OK;
        // Set the button types.
        getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
        loginButton = this.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        title = new TextField();
        title.setPromptText("Title");

        publisher = new TextField();
        publisher.setPromptText("Publisher");

        author = new TextField();
        author.setPromptText("Author");

        releaseDate = new TextField();
        releaseDate.setPromptText("DD/MM/YYYY");
        
        title.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setButtonDisable();
            }
        
        });
        publisher.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setButtonDisable();
            }
        });
        author.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setButtonDisable();
            }
        });
        releaseDate.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setButtonDisable();
            }
        });
        


        TextField totalNoOfIssuesTxt = new TextField();
        totalNoOfIssuesTxt.setPromptText("Total number of issues");
        // Prevent characters (non-integers) to be added
        totalNoOfIssuesTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    totalNoOfIssuesTxt.setText(oldValue);
                }
            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Author:"), 0, 2);
        grid.add(author, 1, 2);
        grid.add(new Label("Release date:"), 0, 3);
        grid.add(releaseDate, 1, 3);

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Book>()
        {
            @Override
            public Book call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    //int issueNo = Integer.parseInt(author.getText());
                    //int totalIssues = Integer.parseInt(totalNoOfIssuesTxt.getText());
                    return new Book(title.getText(), author.getText(), publisher.getText(), "Book");
                }
                return null;
            }
        });
    }
    private void setButtonDisable() {
        if(!checkOkButton()){
            loginButton.setDisable(true);
        } else{
            loginButton.setDisable(false);
        }
    }
    
    private boolean checkOkButton()
    {
        boolean isNotEmpty = true;
        if(title.getText().equals("") || publisher.getText().equals("") || author.getText().equals("") || releaseDate.getText().equals(""))
        {
            isNotEmpty = false;
        }
        return isNotEmpty;
    }
}

