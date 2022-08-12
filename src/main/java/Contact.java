public class Contact extends Lead{
    private int id;

    public Contact(int id, String name, String phoneNumber, String email, String companyName, int id1) {
        super(id, name, phoneNumber, email, companyName);
        this.id = id1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
