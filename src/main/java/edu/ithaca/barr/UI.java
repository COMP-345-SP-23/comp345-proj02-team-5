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
                        //other menu
                        System.out.println("balls");
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
                System.out.println("Please enter your admin username");
                String user = reader.readLine();
                System.out.println("Please enter your admin password");
                String pass = reader.readLine();
                //boolean confirmed = Library.confirmCredentials(user,pass)
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