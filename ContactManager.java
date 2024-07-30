import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        File file;
        
        file = new File("file path here...");
        boolean run = true;
        while(run) {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addContact(file);
                    break;

                case 2:
                    viewContacts(file);
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Enter a valid choice!");
            }

        }

        sc.close();
    }

    static void addContact(File file) throws IOException {
        FileWriter writer = new FileWriter(file,true);
        System.out.println("enter name");
        sc.nextLine(); 
        String name = sc.nextLine();
        System.out.println("Enter number");
        String number = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        writer.write(name + "::" + number + "::" + email + "\n");
        writer.close();
    }

    static void viewContacts(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println("Printing contacts");
        String st;
        while((st = reader.readLine()) != null) {
            String[] arr = st.split("::");
            System.out.println("---------------------------");
            System.out.println("Name : " + arr[0]);
            System.out.println("Number : " + arr[1]);
            System.out.println("Email : " + arr[2]);
            System.out.println("---------------------------");
        }
        reader.close();
    }

    public static void displayMenu() {
        System.out.println("Enter Your choice :");
        System.out.println("1.Add a new Contact");
        System.out.println("2.View contacts");
        System.out.println("3.Delete a contact");
        System.out.println("4.Exit");
    }
}