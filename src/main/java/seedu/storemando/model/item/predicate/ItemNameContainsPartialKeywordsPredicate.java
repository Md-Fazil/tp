package seedu.storemando.model.item.predicate;

import java.util.List;
import java.util.function.Predicate;

import seedu.storemando.commons.util.StringUtil;
import seedu.storemando.model.item.Item;

/**
 * Tests that a {@code Item}'s {@code Name} matches any of the keywords given.
 */
public class ItemNameContainsPartialKeywordsPredicate implements Predicate<Item> {
    /**
     * The list of keyword that is use to be filter on.
     */
    private final List<String> keywords;

    /**
     * @param keywords a list of words to check.
     */
    public ItemNameContainsPartialKeywordsPredicate(List<String> keywords) {
        assert !keywords.isEmpty();
        this.keywords = keywords;
    }

    @Override
    public boolean test(Item item) {
        return keywords.stream()
            .anyMatch(keyword -> StringUtil.containsPartialWordIgnoreCase(item.getItemName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ItemNameContainsPartialKeywordsPredicate // instanceof handles nulls
            && keywords.equals(((ItemNameContainsPartialKeywordsPredicate) other).keywords)); // state check
    }

}



