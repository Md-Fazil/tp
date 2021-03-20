package seedu.storemando.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.storemando.commons.core.Messages;
import seedu.storemando.model.Model;
import seedu.storemando.model.item.ItemExpiringPredicate;

/**
 * Finds and lists all items in storemando whose item's expiry date is within a certain days from today.
 */
public class ReminderCommand extends Command {

    public static final String COMMAND_WORD = "reminder";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all items whose expiry date is within "
        + "the user-specified number of days from the current date and displays them as a list with index numbers.\n"
        + "Parameters: numOfDays (must be a positive integer) [timeUnit] (must either be days or weeks)\n"
        + "Example: \"" + COMMAND_WORD + " 3\" or \"" + COMMAND_WORD + " 2 weeks\"";

    private final ItemExpiringPredicate predicate;

    public ReminderCommand (ItemExpiringPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredItemList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_NUMBER_OF_ITEMS_EXPIRING, model.getFilteredItemList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ReminderCommand // instanceof handles nulls
            && predicate.equals(((ReminderCommand) other).predicate)); // state check
    }
}