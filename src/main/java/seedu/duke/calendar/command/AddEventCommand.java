//@@ kherlenbayasgalan & Cheezeblokz

package seedu.duke.calendar.command;

import seedu.duke.calendar.Event;
import seedu.duke.calendar.EventList;

import java.util.Scanner;
import java.time.LocalDateTime;

public class AddEventCommand extends DualEventCommand {

    public AddEventCommand(String input) {
        this.input = input;
        beginnerCommandLength = 2;
        expertCommandLength = 5;
        syntaxString = "add event EVENT_NAME EVENT_START_DATE (in format yyyy-mm-ddThh:mm:ss) EVENT_END_DATE (in format yyyy-mm-ddThh:mm:ss)";
    }

    @Override
    protected void executeBeginnerMode(Scanner scanner, EventList eventList) {
        System.out.print("What's the event?: ");
        String eventName = scanner.nextLine();
        System.out.print("When does it start? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
        LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());
        System.out.print("When does it end? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
        LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());

        Event event = new Event(eventName, startTime, endTime);

        eventList.addEvent(event);

        System.out.println(event + " has been added to your Calendar");
    }

    //@@author Cheezeblokz
    @Override
    protected void executeExpertMode(Scanner scanner, EventList eventList) {

        String[] commandParts = input.split(" ");
        String eventName = commandParts[2];
        LocalDateTime startTime = LocalDateTime.parse(commandParts[3]);
        LocalDateTime endTime = LocalDateTime.parse(commandParts[4]);

        Event event = new Event(eventName, startTime, endTime);

        eventList.addEvent(event);

        System.out.println(event + " has been added to your Calendar");
    }
}
