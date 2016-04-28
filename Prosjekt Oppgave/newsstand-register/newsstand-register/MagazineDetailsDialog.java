import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
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

public class MagazineDetailsDialog extends Dialog<Magazine>
{

    /**
     * Creates an instance of the MagazineDetails dialog
     */
    public MagazineDetailsDialog()
    {
        super();
        setTitle("Magazine Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField issueNoTxt = new TextField();
        issueNoTxt.setPromptText("Issue number");

        TextField releaseDate = new TextField();
        releaseDate.setPromptText("DD/MM/YYYY");
        
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
        setResultConverter(new Callback<ButtonType, Magazine>()
        {
            @Override
            public Magazine call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    int issueNo = Integer.parseInt(issueNoTxt.getText());
                    return new Magazine(title.getText(), publisher.getText(), issueNo, releaseDate.getText());
                }
                return null;
            }
        });
    }
}