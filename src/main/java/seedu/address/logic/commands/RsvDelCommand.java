package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.reservation.Reservation;

/**
 * Deletes a reservation identified using it's displayed index from the address book.
 */
public class RsvDelCommand extends Command {
    public static final String COMMAND_WORD = "rsvdel";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the reservation identified by the index number used in the displayed reservation list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";
    public static final String MESSAGE_DELETE_RESERVATION_SUCCESS = "Deleted reservation by %1$s";

    private final Index targetIndex;

    public RsvDelCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Reservation> lastShownList = model.getFilteredReservationList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_RESERVATION_DISPLAYED_INDEX);
        }

        Reservation reservationToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteReservation(reservationToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_RESERVATION_SUCCESS, Messages.format(reservationToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RsvDelCommand)) {
            return false;
        }

        RsvDelCommand otherRsvDelCommand = (RsvDelCommand) other;
        return targetIndex.equals(otherRsvDelCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
