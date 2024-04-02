package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.reservation.Pax;
import seedu.address.model.reservation.Reservation;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    private static final Person CUSTOMER_DAVID = new Person(new Name("David Lee"), new Phone("91031282"),
            new Email("lidavid@example.com"),
            new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
            getTagSet("customer"));
    private static final Person CUSTOMER_CHARLOTTE = new Person(new Name("Charlotte Tan"), new Phone("93210283"),
            new Email("charlotte@example.com"),
            new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
            getTagSet("customer"));

    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #01-40"),
                getTagSet("supplier", "durian")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #08-18"),
                getTagSet("parttime", "waiter", "employee")),
            CUSTOMER_DAVID,
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #01-31"),
                    getTagSet("supplier", "durian")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #01-35"),
                    getTagSet("supplier", "mango")),
            CUSTOMER_CHARLOTTE
        };
    }

    public static Reservation[] getSampleReservations() throws ParseException {
        return new Reservation[] {
            new Reservation(CUSTOMER_CHARLOTTE, ParserUtil.parseDate("2024-05-31"), ParserUtil.parseTime("1700"),
                    new Pax("3")),
            new Reservation(CUSTOMER_DAVID, ParserUtil.parseDate("2024-05-31"), ParserUtil.parseTime("1800"),
                    new Pax("4")),
            new Reservation(CUSTOMER_CHARLOTTE, ParserUtil.parseDate("2024-03-24"), ParserUtil.parseTime("1900"),
                    new Pax("6")),
            new Reservation(CUSTOMER_DAVID, ParserUtil.parseDate("2024-03-30"), ParserUtil.parseTime("1200"),
                    new Pax("4")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        try {
            for (Reservation sampleReservation : getSampleReservations()) {
                sampleAb.addReservation(sampleReservation);
            }
        } catch (ParseException pe) {
            // there should not be any ParseException
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
