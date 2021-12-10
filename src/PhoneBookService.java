import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookService {
    Scanner scanner = new Scanner(System.in);
    PhoneBookManager phoneBookManager = new PhoneBookManager();

    public void showAll() {
        phoneBookManager.showPhoneBooks();
    }

    public void formAdd() {
        boolean checkAdd = true;
        while (checkAdd) {
            System.out.println("Input phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Input group: (Family, Friends, Work");
            String group = scanner.nextLine();

            System.out.println("Input name: ");
            String name = scanner.nextLine();

            System.out.println("Input gender: ");
            String gender = scanner.nextLine();

            System.out.println("Input address: ");
            String address = scanner.nextLine();

            System.out.println("Input email: ");
            String email = scanner.nextLine();

            System.out.println("Enter Y to confirm / Enter any key to quit");
            String yes = scanner.next();
            if (yes.equalsIgnoreCase("y")) {
                PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, email);
                phoneBookManager.addNewBook(phoneBook);
                System.out.println("Added");
            } else {
                new MainMenu();
            }

            System.out.println("Enter any key to continue or QUIT to return to Menu");
            String continueOrQuit = scanner.next();
            if (continueOrQuit.equalsIgnoreCase("quit")) {
                new MainMenu();
            }
        }
    }

    public void formEdit() {
        boolean checkEdit = true;
        System.out.println("Enter name of contact you want to edit: ");
        String editName = scanner.nextLine();
        if (checkEdit && phoneBookManager.findByName(editName) != null) {

            System.out.println("Edit phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Edit group: ");
            String group = scanner.nextLine();

            System.out.println("Edit name: ");
            String name = scanner.nextLine();

            System.out.println("Edit gender: ");
            String gender = scanner.nextLine();

            System.out.println("Edit address: ");
            String address = scanner.nextLine();

            System.out.println("Edit email: ");
            String emailAddress = scanner.nextLine();

            System.out.println("Enter Y to confirm / Enter any key to quit");
            String yes = scanner.next();
            if (yes.equalsIgnoreCase("y")) {
                phoneBookManager.editByName(editName, phoneNumber, group, name, gender, address, emailAddress);
                System.out.println("Edited");
            } else {
                new MainMenu();
            }

            System.out.println("Enter any key to continue or QUIT to return to Menu");
            String continueOrQuit = scanner.next();
            if (continueOrQuit.equalsIgnoreCase("quit")) {
                new MainMenu();
            }
        } else {
            System.out.println("Name not found");
            formEdit();
        }
    }

    public void formDelete() {
        boolean checkDelete = true;
        System.out.println("Enter name to delete: ");
        String deleteName = scanner.nextLine();
        if (checkDelete && phoneBookManager.findByName(deleteName) != null) {
            System.out.println("Enter Y to confirm delete / Enter any key to quit");
            String yes = scanner.next();
            if (yes.equalsIgnoreCase("y")) {
                phoneBookManager.deleteByName(deleteName);
                System.out.println("Deleted");
            } else {
                new MainMenu();
            }
        } else {
            System.out.println("Name not found");
            formDelete();
        }
    }


    public void findByName() {
        boolean check = true;
        while (check) {
            System.out.println("Enter name to find: ");
            String name = scanner.nextLine();
            if (phoneBookManager.findByName(name) != null) {
                PhoneBook phoneBook = phoneBookManager.findByName(name);
                System.out.println(phoneBook);
            } else {
                System.out.println("Name not found");
            }

            System.out.println("Enter any key to continue or QUIT to return to Menu");
            String continueOrQuit = scanner.nextLine();
            if (continueOrQuit.equalsIgnoreCase("quit")) {
                new MainMenu();
            }
        }
    }

    public void formWriteToFile() {
        boolean check = true;
        while (check) {
            System.out.println("Enter Y to confirm write / Enter any key to quit");
            String yes = scanner.next();
            if (yes.equalsIgnoreCase("y")) {
                phoneBookManager.writeToFile();
                System.out.println("Done");
                new MainMenu();
            } else {
                new MainMenu();
            }
        }
    }

    public void readFromFile() {
        boolean check = true;
        while (check) {
            System.out.println("Enter Y to confirm read / Enter any key to quit");
            String yes = scanner.next();
            if (yes.equalsIgnoreCase("y")) {
                phoneBookManager.readFile();
                System.out.println("Done");
                new MainMenu();
            } else {
                new MainMenu();
            }
        }
    }
}

