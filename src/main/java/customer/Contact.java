package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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



}
