package seedu.address.ui;

import javafx.beans.property.SimpleStringProperty;

/**
 * A command summary in the table of HelpWindow.
 */
public class CommandSummary {
    private final SimpleStringProperty command;
    private final SimpleStringProperty usage;

    /**
     * Constructs an item in the user guide table.
     *
     * @param command
     * @param usage
     */
    public CommandSummary(String command, String usage) {
        this.command = new SimpleStringProperty(command);
        this.usage = new SimpleStringProperty(usage);
    }

    public String getCommand() {
        return command.get();
    }

    public String getUsage() {
        return usage.get();
    }
}
