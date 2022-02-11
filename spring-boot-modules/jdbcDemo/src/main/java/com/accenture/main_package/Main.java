package com.accenture.main_package;

import com.accenture.entity.User;
import com.accenture.exception_handler.ExceptionHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.print(
                    "*****************************\n" +
                            "[1]Display Users\n" +
                            "[2]Add Users\n" +
                            "[3]Exit\n" +
                            "[4]Display User by ID\n" +//create this functionality
                            "[5]Delete\n" +//create this functionality
                            "Choose what you want to do: ");
            choice = scanner.nextInt();
            transaction(choice);
        }
        while (choice != 3);
    }

    static void transaction(int choice) {
        try {
            Scanner scanner = new Scanner(System.in);
            UsersComponent comp = new UsersComponent();
            switch (choice) {
                case 1:
                    System.out.println(comp.printUserList());//get users
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Birthday: ");
                    String bdayString = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                    LocalDate bday = LocalDate.parse(bdayString, formatter);
                    User userToAdd = new User(name, email, age, bday);
                    System.out.println(comp.addUser(userToAdd));
                    break;
                case 3:
                    System.out.println("Thank you, come again!");
                    break;

                default:
                    System.out.println("Invalid choice of transaction");
            }
        } catch (Exception exception) {
//            System.out.println("\n"+msg);
            ExceptionHandler.handleException(exception);
        }

    }
}
