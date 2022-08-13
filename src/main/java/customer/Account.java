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

public class Account {
    private String id;
    private Activity industry;
    private String city; // This could also be a very long string of cities
    private String country;
    private List<Opportunity> opportunities;

    public Account(String id, Activity industry, String city, String country, List<Opportunity> opportunities) {
        this.id = id;
        this.industry = industry;
        this.city = city;
        this.country = country;
        this.opportunities = opportunities;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", industry=" + industry +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", opportunities=" + opportunities +
                '}';
    }

    public static List<Account> loadAccountsFromDatabase() {
        Account[] accountArray;
        List<Account> accountList;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("db/accounts.json"));
            accountArray = new Gson().fromJson(reader, Account[].class);
            accountList = Arrays.asList(accountArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }

    public static void updateAccountsDatabase(List<Account> accountList) {
        try {
            FileWriter writer = new FileWriter("db/accounts.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(accountList));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
