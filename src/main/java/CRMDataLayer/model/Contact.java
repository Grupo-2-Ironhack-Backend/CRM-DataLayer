package CRMDataLayer.model;


/**
 * Definition of the ContactRepository Class
 */
public class Contact extends Lead {
    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
