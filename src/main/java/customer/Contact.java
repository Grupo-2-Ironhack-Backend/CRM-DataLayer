package customer;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Contact extends Lead {


    public Contact(String id, String name, String phoneNumber, String email, String companyName) {
        super(id, name, phoneNumber, email, companyName);
    }

    public static List<Contact> loadContactsFromDatabase() {
        Contact[] contactArray;
        List<Contact> contactList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/contacts.json"));
            contactArray = new Gson().fromJson(reader, Contact[].class);
            contactList = Arrays.asList(contactArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contactList;
    }

    public static void updateContactsDatabase(List<Contact> contactList) {
        try {
            FileWriter writer = new FileWriter("db/contacts.json");
            Gson gson = new Gson();
            writer.write(gson.toJson(contactList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
