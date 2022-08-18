package customer;

import dbInteraction.Database;

public class QueryCommands extends Command{
    Database db = new Database();
    public void lookupLeadId(){

    }

    public void showLeads(){
        db.getLeadList();
    }
}
