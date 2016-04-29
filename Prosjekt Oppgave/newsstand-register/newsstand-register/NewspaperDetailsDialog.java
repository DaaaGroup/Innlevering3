import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.DepthTest;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 * A dialog used to get the necessary information about a newspaper from the
 * user, in order to be able to create a Newspaper instance to be added
 * to the register.
 *
 * @author asty & Oscar Wika
 */

public class NewspaperDetailsDialog extends Dialog<Newspaper>
{

    private TextField title;
    private TextField publisher;
    private TextField issueNoTxt;
    private TextField releaseDate;
    private Node okayButton;
    
    /**
     * Creates an instance of the NewspaperDetails dialog
     */
    public NewspaperDetailsDialog()
    {
        super();
        setTitle("Newspaper Details");
        
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

        issueNoTxt = new TextField();
        issueNoTxt.setPromptText("Issue number");

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
        issueNoTxt.textProperty().addListener(new ChangeListener<String>() {
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
        // Prevent characters (non-integers) to be added
        issueNoTxt.textProperty().addListener(new ChangeListener<String>()
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
                    issueNoTxt.setText(oldValue);
                }
            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("Issue number:"), 0, 2);
        grid.add(issueNoTxt, 1, 2);
        grid.add(new Label("Release date:"), 0, 3);
        grid.add(releaseDate, 1, 3);
        
        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Newspaper>()
        {
            @Override
            public Newspaper call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    int issueNo = Integer.parseInt(issueNoTxt.getText());
                    return new Newspaper(title.getText(), publisher.getText(), issueNo, releaseDate.getText(), "Newspaper");
                }
                return null;
            }
        });
    }

    private void setButtonDisable() {
        if(!checkOkButton()){
            okayButton.setDisable(true);
        } else{
            okayButton.setDisable(false);
        }
    }
    
    private boolean checkOkButton()
    {
        boolean isNotEmpty = true;
        if(title.getText().equals("") || publisher.getText().equals("") || issueNoTxt.getText().equals("") || releaseDate.getText().equals(""))
        {
            isNotEmpty = false;
        }
        return isNotEmpty;
    }
}