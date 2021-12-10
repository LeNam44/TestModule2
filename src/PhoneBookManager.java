import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {
    Scanner scanner = new Scanner(System.in);

    public static ArrayList<PhoneBook> phoneBooks = new ArrayList<>();

    static {
        phoneBooks.add(new PhoneBook("0989787032", "Family", "Tuan Anh", "Male", "My Dinh Ha Noi", "tuananh123@gmail.com"));
        phoneBooks.add(new PhoneBook("0385668796", "Work", "Huu Nhan", "Male", "Thanh Xuan Ha Noi", "nhannguyen421@gmail.com"));
        phoneBooks.add(new PhoneBook("0123546792", "Friends", "Quang Huy", "Male", "Ho Tay Ha Noi", "vuquanghuy4214@gmail.com"));
    }

    public ArrayList<PhoneBook> findAll() {
        return phoneBooks;
    }

    public void addNewBook(PhoneBook phoneBook) {
        phoneBooks.add(phoneBook);
    }

    public void showPhoneBooks() {
        System.out.println(phoneBooks);
    }

    public void deleteByName(String name) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equalsIgnoreCase(name)) {
                phoneBooks.remove(i);
            }
        }
    }

    public PhoneBook findByName(String name) {
        PhoneBook phoneBook = null;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equalsIgnoreCase(name)) {
                phoneBook = phoneBooks.get(i);
            }
        }
        return phoneBook;
    }

    public void editByName(String editName, String phoneNumber, String group, String name, String gender, String address, String emailAddress) {
        PhoneBook phoneBook = findByName(editName);
        phoneBook.setName(name);
        phoneBook.setPhoneNumber(phoneNumber);
        phoneBook.setGroup(group);
        phoneBook.setGender(gender);
        phoneBook.setAddress(address);
        phoneBook.setEmailAddress(emailAddress);
    }

    public String FILE_PATH = "C:\\Users\\Nam Le\\Desktop\\CODE\\Thi Module 2\\phonebook.csv";

    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for (PhoneBook phoneBook : phoneBooks) {
                fileWriter.write(phoneBook.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String contactsLine[] = line.split(",");
                String phoneNumber = contactsLine[0];
                String group = contactsLine[1];
                String name = contactsLine[2];
                String gender = contactsLine[3];
                String address = contactsLine[4];
                String emailAddress = contactsLine[5];
                PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, emailAddress);
                addNewBook(phoneBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}