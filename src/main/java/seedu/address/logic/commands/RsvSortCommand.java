package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RESERVATIONS;

import seedu.address.model.Model;
import seedu.address.model.reservation.Reservation;

import java.util.Comparator;
import java.util.List;

/**
 * Sorts all reservations from earliest to latest.
 */
public class RsvSortCommand extends Command {
    public static final String COMMAND_WORD = "rsvsort";

    public static final String MESSAGE_SUCCESS = "Sorted all reservations";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        Comparator<Reservation> comparator = Comparator
                .comparing(Reservation::getDateValue)
                .thenComparing(Reservation::getTimeValue);

        model.sortReservation(comparator);

        model.updateFilteredReservationList(PREDICATE_SHOW_ALL_RESERVATIONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
