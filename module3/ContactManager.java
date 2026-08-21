package module3;
import java.util.*; 
import module3.Contact;

public class ContactManager {
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Harrison Ford" , new Contact("Harrison Ford", "512 338 1318"));
        contacts.put("Mark Hamill" , new Contact("Mark Hamill", "512 432 7289"));
        contacts.put("Tom Holland" , new Contact("Tom Holland", "737 892 8088"));
        contacts.put("Zendaya" , new Contact("Zendaya", "737 892 8088"));
        contacts.put("Anne Hathaway" , new Contact("Anne Hathaway", "248 892 8088"));

        // Step 5: look up a contact 
        // Contact c = contacts.get("Matt Damon");

        Contact c = contacts.get("Zendaya");

        if (c == null) {
            System.out.println("Contact not found.\n");
        }
        else {
            System.out.println(c.toString() + "\n");
        }

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact con : sorted) {
            System.out.println(con.toString());
        }
    } 
}
