package edu.ithaca.barr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UI{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the Online Library\n");
        System.out.println("Type c if you would like to log in as a customer, a if you would like to log in as an admin, or q to quit\n");
        String ans = reader.readLine();//need to error check
        do{
            if (ans.equalsIgnoreCase("c")){
                boolean flag = false;
                do{
                    System.out.println("Please enter your username\n");
                    String user = reader.readLine();
                    System.out.println("Please enter your password\n");
                    String pass = reader.readLine();
                    boolean confirmed = Library.confirmCredentials(user,pass);
                    if (confirmed){
                        //customer menu
                        System.out.println("Enter the corresponding number for which action you would like to take");
                        System.out.println("(1) Search Title");
                        System.out.println("(2) Search Author");
                        System.out.println("(3) Return Book");
                        System.out.println("(4) Checkout Book");
                        System.out.println("(5) Checked Out Books List");
                        System.out.println("(6) Sign Out");
                        String ansMenu  = reader.readLine();
                        boolean flag2=true;
                        //need to continue error checking
                        do{
                        flag2=true;
                        if (ansMenu=="1"){
                            //search title
                        }
                        else if (ansMenu=="2"){
                            //search author
                        }
                        else if (ansMenu=="3"){
                            //return book
                        }
                        else if (ansMenu=="4"){
                            //checkout book
                        }
                        else if (ansMenu=="5"){
                            //checked out books list
                        }
                        else if (ansMenu=="6"){
                            //sign out
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                            flag2=false;
                            ansMenu  = reader.readLine();
                        }
                    }
                    while(flag2==false);
                    }
                    
                    else{
                        System.out.println("Username/password not found. To enter again, type e, or to quit, type q\n");
                        String incorrect = reader.readLine();
                        while ((!incorrect.equalsIgnoreCase("e")) && (!incorrect.equalsIgnoreCase("q"))) {
                            System.out.println("Incorrect input. Try again\n");
                            incorrect = reader.readLine();
                        }
                        if (incorrect.equalsIgnoreCase("q")){
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
                        }
                        else{
                            flag = true;
                        }
                    }
                } while(flag);
                break;
            }
            else if (ans.equalsIgnoreCase("a")){
                boolean flag = false;
                do{
                    System.out.println("Please enter your admin username\n");
                    String user = reader.readLine();
                    System.out.println("Please enter your admin password\n");
                    String pass = reader.readLine();
                    boolean confirmed = Library.confirmCredentials(user,pass);
                    if (confirmed){
                        //admin menu
                        System.out.println("Enter the corresponding number for which action you would like to take");
                        System.out.println("(1) Add Book");
                        System.out.println("(2) Remove Book");
                        System.out.println("(3) Close Account");
                        System.out.println("(4) Open Account");
                        System.out.println("(5) Freeze Account");
                        System.out.println("(6) Unfreeze Account");
                        System.out.println("(7) View Checked Out Books");
                        String ansMenu  = reader.readLine();
                        boolean flag2=true;
                        //need to continue error checking
                        do{
                        flag2=true;
                        if (ansMenu=="1"){
                            //add book
                        }
                        else if (ansMenu=="2"){
                            //remove book
                        }
                        else if (ansMenu=="3"){
                            //close account
                        }
                        else if (ansMenu=="4"){
                            //open account
                        }
                        else if (ansMenu=="5"){
                            //freeze account
                        }
                        else if (ansMenu=="6"){
                            //unfreeze account
                        }
                        else if (ansMenu=="7"){
                            //view checked out books
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                            flag2=false;
                            ansMenu  = reader.readLine();
                        }
                    }
                    while(flag2==false);
                    }
                    
                    
                    else{
                        System.out.println("Username/password not found. To enter again, type e, or to quit, type q\n");
                        String incorrect = reader.readLine();
                        while ((!incorrect.equalsIgnoreCase("e")) && (!incorrect.equalsIgnoreCase("q"))) {
                            System.out.println("Incorrect input. Try again\n");
                            incorrect = reader.readLine();
                        }
                        if (incorrect.equalsIgnoreCase("q")){
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
                        }
                        else{
                            flag = true;
                        }
                    }
                } while(flag);
                break;
            }
            else if (ans.equalsIgnoreCase("q")){
                System.out.println("Thanks for visiting the online library!\n");
                break;
            }
            else{
                System.out.println("Invalid input. Please enter again\n");
                ans = reader.readLine();
            }
        } while((!ans.equalsIgnoreCase("c")) || (!ans.equalsIgnoreCase("a")) || (!ans.equalsIgnoreCase("q")));
    }
}