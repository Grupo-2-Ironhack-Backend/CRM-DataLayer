import dbInteraction.GitHub;
import org.apache.commons.io.FileUtils;
import ui.MainMenu;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //pruebasIO(); //Debería imprimir las arrays en formato JSON
        File dbPath = new File("./db/");
        FileUtils.deleteDirectory(dbPath);

        GitHub.cloneDatabase(); //La clonación necesita que el directorio db esté vacío o no exista.
        MainMenu menu = new MainMenu();
        menu.executeCommand();
    }

    private static void pruebasIO(){ }
        /* Pruebas de importación / exportación de datos */
 }
