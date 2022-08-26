package CRMDataLayer.ui;

/**
 * @Author: TheBigFive {Kat, Paula, Jhon, Gerard & Alex}
 * @See: MainMenu.class
 * @Version: 1.0
 * @Param: String userCommand: a command entered by the user
 * @return: the command entered trimmed and whitespace removed,
 *          all in lowercase
 * Goal is to minimize malfunction due to invalid commands, this
 * permits the user to enter "showleads" "show LEADS" or "S h owLe ads"
 * and still getting the result, otherwise the program returns
 * "invalid option".
 */
public class CommandInterpreter {
    public static String InputToCommand(String userCommand) {
        return userCommand.toLowerCase().trim().replace(" ", "");
    }


}
