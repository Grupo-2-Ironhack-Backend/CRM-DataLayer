import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import customer.*;
import dbInteraction.CRUD;
import dbInteraction.Database;
import dbInteraction.GitHub;
import ui.MainMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws IOException {
        //pruebasIO(); //Debería imprimir las arrays en formato JSON
        MainMenu menu = new MainMenu();
        menu.executeCommand();
    }

    private static void pruebasIO(){ }
        /* Pruebas de importación / exportación de datos */



 }
