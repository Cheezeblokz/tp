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
        System.out.print("When does it start? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
        LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());
        System.out.print("When does it end? (yyyy-mm-ddThh:mm:ss) (eg. 2023-12-20T12:30:30): ");
        LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());

        Event event = new Event(eventName, startTime, endTime);

        eventList.addEvent(event);

        System.out.println(event + " has been added to you calendar.");
    }
}
