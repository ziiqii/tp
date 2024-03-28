package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(this::createTagLabel);
    }

    /**
     * Creates orange Label for customer, blue Label for employee, green Label for supplier,
     * and grey Label for everything else. The created Label is then added to the tag FlowPane.
     *
     * @param tag The tag object for which a label is to be created.
     */
    public void createTagLabel(Tag tag) {
        Label tagLabel = new Label(tag.tagName);
        switch (tag.tagName) {
        case "customer":
            tagLabel.setStyle("-fx-background-color: #F5B041;");
            break;
        case "employee":
            tagLabel.setStyle("-fx-background-color: #5DADE2;");
            break;
        case "supplier":
            tagLabel.setStyle("-fx-background-color: #52BE80;");
            break;
        default:
            tagLabel.setStyle("-fx-background-color: #EAECEE;");
        }
        tags.getChildren().add(tagLabel);
    }
}
