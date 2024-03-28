package seedu.address.ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.reservation.Reservation;

/**
 * An UI component that displays information of a {@code Reservation}.
 */
public class ReservationCard extends UiPart<Region> {
    private static final String FXML = "ReservationListCard.fxml";

    public final Reservation reservation;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label pax;

    /**
     * Creates a {@code reservationCode} with the given {@code reservation} and index to display.
     */
    public ReservationCard(Reservation reservation, int displayedIndex) {
        super(FXML);
        this.reservation = reservation;
        id.setText(displayedIndex + ". ");
        name.setText(reservation.getPerson().getName().fullName);
        phone.setText(reservation.getPerson().getPhone().value);
        date.setText(this.formatDate(reservation.getDate().value));
        time.setText(this.formatTime(reservation.getTime().value));
        pax.setText(reservation.getPax().value + " people");
    }

    /**
     * Formats the given LocalDate object into a string representing the date in the format "dd/MM/yyyy".
     *
     * @param date The LocalDate object to be formatted.
     * @return A string representing the formatted date.
     */
    public String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * Parses the given twenty-four hour time string and formats it into a twelve-hour time string with AM/PM indicator.
     *
     * @param twentyFourHourTime A string representing the time in twenty-four hour format.
     * @return A string representing the formatted twelve-hour time with AM/PM indicator.
     */
    public String formatTime(String twentyFourHourTime) {
        LocalTime twelveHourTime = LocalTime.parse(twentyFourHourTime, DateTimeFormatter.ofPattern("HHmm"));
        return twelveHourTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

}
