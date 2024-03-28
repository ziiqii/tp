package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RsvDelCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new RsvDelCommand object
 */
public class RsvDelCommandParser implements Parser<RsvDelCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the RsvDelCommand
     * and returns a RsvDelCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RsvDelCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new RsvDelCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, RsvDelCommand.MESSAGE_USAGE), pe);
        }
    }
}
