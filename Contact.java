package Module3;

public class Contact {
    private String name, phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }

    public String getPhone() { return phone; }

    public String toString() {
        return String.format("%s | %s", name, phone);
    }

}

