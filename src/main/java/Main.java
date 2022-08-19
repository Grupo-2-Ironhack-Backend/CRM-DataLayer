import dbInteraction.GitHub;
import org.apache.commons.io.FileUtils;
import ui.MainMenu;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File dbPath = new File("./db/");
        FileUtils.deleteDirectory(dbPath);
        GitHub.cloneDatabase(); //La clonación necesita que el directorio db esté vacío o no exista.
        MainMenu menu = new MainMenu();
        menu.executeCommand();
    }
}
