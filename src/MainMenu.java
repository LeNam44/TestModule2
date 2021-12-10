import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        Scanner scanner = new Scanner(System.in);
        PhoneBookService phoneBookService = new PhoneBookService();
        boolean menuCheck = true;
        while (menuCheck) {
            System.out.println("PhoneBook Manager Menu");
            System.out.println("1.Show All");
            System.out.println("2.Add");
            System.out.println("3.Edit");
            System.out.println("4.Delete");
            System.out.println("5.Search");
            System.out.println("6.Read from file");
            System.out.println("7.Write to file");
            System.out.println("8.Exit");
            System.out.println("Choose an option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    phoneBookService.showAll();
                    break;
                case 2:
                    phoneBookService.formAdd();
                    break;
                case 3:
                    phoneBookService.formEdit();
                    break;
                case 4:
                    phoneBookService.formDelete();
                    break;
                case 5:
                    phoneBookService.findByName();
                    break;
                case 6:
                    phoneBookService.readFromFile();
                    break;
                case 7:
                    phoneBookService.formWriteToFile();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
