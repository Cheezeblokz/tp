//@@ kherlenbayasgalan & jingxizhu

package seedu.duke.calendar.command;

import seedu.duke.calendar.Event;
import seedu.duke.calendar.EventList;

import java.util.Scanner;
import java.time.LocalDateTime;

public class AddEventCommand extends EventCommand {
    public void execute(Scanner scanner, EventList eventList) {
        System.out.print("What's the event?: ");
        String eventName = scanner.nextLine();
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;

        //@@author Cheezeblokz
        while (startTime == null) {
            try {
                System.out.print("When does it start? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
                startTime = LocalDateTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Date Input!");
            }
        }

        while (endTime == null) {
            try {
                System.out.print("When does it end? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
                endTime = LocalDateTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Date Input!");
            }
        }

        //@@author Bayasgalan Kherlen
        Event event = new Event(eventName, startTime, endTime);

        eventList.addEvent(event);

        System.out.println(event + " has been added to you calendar.");
    }
}
