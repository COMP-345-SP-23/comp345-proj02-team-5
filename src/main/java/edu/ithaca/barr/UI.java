package edu.ithaca.barr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean loggedIn = false;
        String currentUser = "";

        System.out.println("Welcome to the Online Library\n");
        do {
            System.out.println("Type c if you would like to log in as a customer, a if you would like to log in as an admin, or q to quit\n");
            String ans = reader.readLine();//need to error check

            if (ans.equalsIgnoreCase("c")) {
                if (loggedIn) {
                    System.out.println("You are already logged in as " + currentUser + "\n");
                    continue;
                }

                boolean flag = false;
                do {
                    System.out.println("Please enter your username\n");
                    String user = reader.readLine();
                    System.out.println("Please enter your password\n");
                    String pass = reader.readLine();
                    boolean confirmed = Library.confirmCredentials(user, pass);
                    if (confirmed) {
                        currentUser = user;
                        loggedIn = true;
                        System.out.println("You are now logged in as " + currentUser + "\n");
                        flag = false;
                        //other menu
                        System.out.println("balls");
                        System.out.println("Type 'logout' to log out or 'quit' to exit the program\n");
                        String input = reader.readLine();
                        if (input.equalsIgnoreCase("logout")) {
                            loggedIn = false;
                            currentUser = "";
                            System.out.println("You have been logged out successfully.\n");
                        } else if (input.equalsIgnoreCase("quit")) {
                            System.out.println("Thanks for visiting the online library!\n");
                            System.exit(0);
                        } else {
                            System.out.println("Invalid input. Please enter again.\n");
                        }
                    } else {
                        System.out.println("Username/password not found. To enter again, type e, or to quit, type q\n");
                        String incorrect = reader.readLine();
                        while ((!incorrect.equalsIgnoreCase("e")) && (!incorrect.equalsIgnoreCase("q"))) {
                            System.out.println("Incorrect input. Try again\n");
                            incorrect = reader.readLine();
                        }
                        if (incorrect.equalsIgnoreCase("q")) {
                            System.out.println("Thanks for visiting the online library!\n");
                            System.exit(0);
                        } else {
                            flag = true;
                        }
                    }
                } while (flag);
            } else if (ans.equalsIgnoreCase("a")) {
                System.out.println("Please enter your admin username");
                String user = reader.readLine();
                System.out.println("Please enter your admin password");
                String pass = reader.readLine();
                //boolean confirmed = Library.confirmCredentials(user,pass)
                break;
            } else if (ans.equalsIgnoreCase("q")) {
                System.out.println("Thanks for visiting the online library!\n");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter again\n");
            }
        } while (true);
    }
}
