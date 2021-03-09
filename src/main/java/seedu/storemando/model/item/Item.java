package seedu.storemando.model.item;

import static seedu.storemando.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.storemando.model.tag.Tag;

/**
 * Represents a Item in the storemando.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Item {

    // Identity fields
    private final ItemName name;
    private final Quantity quantity;
    private final ExpiryDate expiryDate;

    // Data fields
    private final Location location;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Item(ItemName name, Quantity quantity, ExpiryDate expiryDate, Location location, Set<Tag> tags) {
        requireAllNonNull(name, quantity, expiryDate, location, tags);
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.location = location;
        this.tags.addAll(tags);
    }

    public ItemName getItemName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both items have the same name.
     * This defines a weaker notion of equality between two items.
     */
    public boolean isSameItem(Item otherItem) {
        if (otherItem == this) {
            return true;
        }

        return otherItem != null
            && otherItem.getItemName().equals(getItemName());
    }

    /**
     * Returns true if both items have the same identity and data fields.
     * This defines a stronger notion of equality between two items.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Item)) {
            return false;
        }

        Item otherItem = (Item) other;
        return otherItem.getItemName().equals(getItemName())
            && otherItem.getQuantity().equals(getQuantity())
            && otherItem.getExpiryDate().equals(getExpiryDate())
            && otherItem.getLocation().equals(getLocation())
            && otherItem.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, quantity, expiryDate, location, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getItemName())
            .append("; Quantity: ")
            .append(getQuantity())
            .append("; ExpiryDate: ")
            .append(getExpiryDate())
            .append("; Location: ")
            .append(getLocation());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}