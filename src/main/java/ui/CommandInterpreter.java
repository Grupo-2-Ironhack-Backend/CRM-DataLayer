package ui;

public class CommandInterpreter {
    public static String InputToCommand(String userCommand) {
        return userCommand.toLowerCase().trim().replace(" ", "");
    }
}
