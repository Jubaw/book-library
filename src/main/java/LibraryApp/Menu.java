package LibraryApp;

import javax.xml.crypto.Data;
import java.util.Scanner;


public class Menu {
    Database database = new Database();

    static Scanner scanner = new Scanner(System.in);

    public void menuDisplay() {
        String input;
        do {


            System.out.println("""
                    Welcome to Library, select from menu\s
                    1.List Books\s
                    2.Add Books\s
                    3.Borrow Books\s
                    4.Search Authors\s
                    5.Search Books\s
                    0.Exit""");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    database.listBooks();
                    break;
                case "2":
                    database.addBooks();
                    break;
                case "3":
                    database.borrowBooks();
                    break;
                case "4":
                    database.searchAuthor();
                    break;
                case "5":
                    database.searchBooks();
                    break;
                case "0":
                    slowPrint("Exiting",100);
                    break;
                default:
                    System.out.println("\s\s!!!!!!!! Invalid entry !!!!!!!!");
                    break;

            }
        } while (exitStatus(input));
    }

    private boolean exitStatus(String input) {
        return !input.equalsIgnoreCase("0");  // Returns false if input is "0", true otherwise
    }



    public String inputHandle(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    private static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }





}