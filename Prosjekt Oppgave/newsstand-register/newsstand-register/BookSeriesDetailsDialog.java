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
 * @author asty & Oscar Wika, Thomas Todal, Siv Furland, Kristoffer Martinsen.
 */

public class BookSeriesDetailsDialog extends Dialog<BookSeries>
{
    private TextField title;
    private TextField publisher;
    private TextField releaseDate;
    private Node okayButton;
    
    /**
     * Creates an instance of the MagazineDetails dialog
     */
    public BookSeriesDetailsDialog()
    {
        super();
        setTitle("Periodical Details");
        
        ButtonType okayButtonType = ButtonType.OK;
        // Set the button types.
        getDialogPane().getButtonTypes().addAll(okayButtonType, ButtonType.CANCEL);
        okayButton = this.getDialogPane().lookupButton(okayButtonType);
        okayButton.setDisable(true);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        title = new TextField();
        title.setPromptText("Title");

        publisher = new TextField();
        publisher.setPromptText("Publisher");

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
        releaseDate.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setButtonDisable();
            }
        });
        

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Release date:"), 0, 2);
        grid.add(releaseDate, 1, 2);

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, BookSeries>()
        {
            @Override
            public BookSeries call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    return new BookSeries(title.getText(), publisher.getText(), releaseDate.getText(), "Book Series");
                }
                return null;
            }
        });
    }
    
    /**
     * 
     */
    private void setButtonDisable() {
        if(!checkOkButton()){
            okayButton.setDisable(true);
        } else{
            okayButton.setDisable(false);
        }
    }
    
    /**
     * 
     * @return 
     */
    private boolean checkOkButton()
    {
        boolean isNotEmpty = true;
        if(title.getText().equals("") || publisher.getText().equals("") ||  releaseDate.getText().equals(""))
        {
            isNotEmpty = false;
        }
        return isNotEmpty;
    }
}