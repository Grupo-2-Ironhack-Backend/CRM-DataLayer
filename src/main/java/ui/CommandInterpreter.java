package ui;

/**
 * Management of the command line interface.
 */
public class CommandInterpreter {
    public static String InputToCommand(String userCommand) {
        return userCommand.toLowerCase().trim().replace(" ", "");
    }
}
