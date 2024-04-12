package LibraryApp;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.print.Book;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Database {
    static List<Books> booksList = new ArrayList<>();

    public Database() {
        booksList.add(new Books("Les Miserables", "Victor Hugo", "1872", "Historical Fiction", 1500));
        booksList.add(new Books("War and Peace", "Lev Tolstoy", "1867", "Historical Fiction", 2000));
        booksList.add(new Books("Crime and Punishment", "Fyodor Dostoyevski", "1866", "Philosophical Fiction", 2500));
    }


    public void listBooks() {
        for (Books w : booksList) {
            System.out.println("Book name: " + w.getBookName()
                    + "\nBook Author: " + w.getBookAuthor()
                    + "\nYear: " + w.getBookYear()
                    + "\nGenre: " + w.getBookGenre()
                    + "\nPrice: " + w.getBookPrice());
            System.out.println("***************");

        }
    }

    public void addBooks() {
        Books newBook = new Books();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book name");
        newBook.setBookName(scanner.nextLine());
        System.out.println("Enter the book author");
        newBook.setBookAuthor(scanner.nextLine());
        System.out.println("Enter the book year");
        newBook.setBookYear(scanner.nextLine());
        System.out.println("Enter the book genre");
        newBook.setBookGenre(scanner.nextLine());
        System.out.println("Enter the book price");
        newBook.setBookPrice(scanner.nextInt());
        scanner.nextLine();
        booksList.add(newBook);

        System.out.println("Book added" + newBook);

        listBooks();

    }


    public void borrowBooks() {
        boolean isFound = false;

        List<Books> booksToRemove = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name you want to borrow");
        String input = scanner.nextLine();

        for (Books book : booksList) {
            if (book.getBookName().equalsIgnoreCase(input)) {
                booksToRemove.add(book);
                isFound = true;
            }
        }

        if (isFound) {
            booksList.removeAll(booksToRemove);
        } else {
            System.out.println("Could not find the book" + input);
        }

        System.out.println("Remaining books are: ");
        listBooks();
    }


    public void searchAuthor() {
        boolean foundFlag = false;
        do {
            System.out.println("Enter the author name");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();


            for (Books books : booksList) {
                if (books.getBookAuthor().equalsIgnoreCase(input)) {
                    System.out.println("Author's books:");
                    System.out.println(books);
                    foundFlag = true;
                }
            }
            if (!foundFlag) {
                System.out.println("Could not find the book related with" + input);
            }

            System.out.println("Search another author ? Y/N");

        } while (shouldContinue());


    }


    public void searchBooks() {

        boolean foundFlag = false;
        do {


            System.out.println("Enter the book name");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            for (Books books : booksList) {
                if (books.getBookName().equalsIgnoreCase(input)) {
                    System.out.println("Books listed: ");
                    System.out.println(books);
                    foundFlag = true;
                }
            }

            if (!foundFlag) {
                System.out.println("Could not find the book");
            }
            System.out.println("Search another book ?");
        } while (shouldContinue());

    }

    private boolean shouldContinue() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("n")) {
            return false; // Set isExit to true if the user wants to exit

        } else if (input.equalsIgnoreCase("y")) {
            return true; // Continue searching if the user inputs anything other than 'N'
        }
        return true;


    }


}
