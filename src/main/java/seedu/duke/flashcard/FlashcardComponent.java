//@@author wendelinwemhoener

package seedu.duke.flashcard;

import seedu.duke.flashcard.command.FlashcardCommand;
import seedu.duke.flashcard.command.UnknownCommand;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FlashcardComponent {
    private FlashcardCommandParser parser;
    private FlashcardList flashcardList;
    private FlashcardUi ui;
    private FlashcardStorage storage;


    public FlashcardComponent() {
        parser = new FlashcardCommandParser();

        //@@author junhyeong0411
        FlashcardDirectory flashcarddirectory = new FlashcardDirectory();
        flashcarddirectory.listFlashcardFiles();

        storage = new FlashcardStorage(flashcarddirectory.defaultDirectory());
        try {
            flashcardList = storage.loadFlashcards();
        } catch (FileNotFoundException e){
            //System.out.println("Making New file for Flashcards");
            flashcardList = new FlashcardList(new ArrayList<>());
        }

        //@@author wendelinwemhoener
        Flashcard.calculateAndUpdateGlobalMaxId(flashcardList);
        ui = new FlashcardUi(flashcardList);
    }

    //@@author junhyeong0411
    public FlashcardStorage getStorage(){
        return this.storage;
    }

    public FlashcardList getFlashcardList(){
        return this.flashcardList;
    }

    /**
     * get FlashcardUi method
     * for test
     * @return
     */
    public FlashcardUi getUi(){
        return ui;
    }

    //@@author wendelinwemhoener
    public boolean isResponsible(String input) {
        FlashcardCommand command = parser.parseInput(input);

        if (command instanceof UnknownCommand) {
            return false;
        } else {
            return true;
        }
    }

    public void processInput(String input) {
        FlashcardCommand command = parser.parseInput(input);
        assert !(command instanceof UnknownCommand) : "Command cannot be " +
                "unknown";

        ui.executeCommand(command);

        //@@author junhyeong0411
        // save after every commands
        storage.saveFlashcards(flashcardList.getFlashcards());

        //@@author wendelinwemhoener
    }
}
