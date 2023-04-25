package edu.ithaca.barr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class UI{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the Online Library\n");
        System.out.println("Type c if you would like to log in as a customer, a if you would like to log in as an admin, or q to quit\n");
        String ans = reader.readLine();//need to error check
        Library lib = new Library();
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
                        User user1;
                        for (int i=0;i<Library.userList.size();i++){
                            if ((Library.userList.get(i).getName().equals(user)) && (Library.userList.get(i).getPassword().equals(pass))){
                                user1 = Library.userList.get(i);
                            }
                        }
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
                            boolean exit = true;
                            do{
                            System.out.println("Enter the book title:");
                            String title = reader.readLine();
                            List<Book> answer = lib.searchByTitle(title);
                            if (answer==null){
                                System.out.println("Book not found.");
                            }
                            else{
                                for (int i=0; i<answer.size();i++){
                                    System.out.println(answer.get(i));
                                }
                            }
                            System.out.println("Would you like to search again? Enter y if yes, or any other character if not");
                            String goagain = reader.readLine();
                            if (!goagain.equals("y")){
                                exit=false;
                            }
                            }
                            while (exit==true);
                        }
                        else if (ansMenu=="2"){
                            //search author
                            boolean exit = true;
                            do{
                            System.out.println("Enter the book author:");
                            String title = reader.readLine();
                            List<Book> answer = lib.searchByAuthor(title);
                            if (answer==null){
                                System.out.println("Author not found.");
                            }
                            else{
                                for (int i=0; i<answer.size();i++){
                                    System.out.println(answer.get(i));
                                }
                            }
                            System.out.println("Would you like to search again? Enter y if yes, or any other character if not");
                            String goagain = reader.readLine();
                            if (!goagain.equals("y")){
                                exit=false;
                            }
                            }
                            while (exit==true);
                        }
                        else if (ansMenu=="3"){
                            //return book
                            boolean cont=true;
                            do{
                                System.out.println("Enter the title of the book you would like to return");
                                String title = reader.readLine();
                                System.out.println("Enter the author of the book you would like to return");
                                String author = reader.readLine();
                                boolean found = false;
                                for (int i=0;i<user1.checkedOutList.size();i++){
                                    if ((user1.checkedOutList.get(i).getTitle().equals(title)) && (user1.checkedOutList.get(i).getAuthor().equals(author))){
                                        lib.returnBook(user1, user1.checkedOutList.get(i));
                                        System.out.println("Book returned.");
                                        found = true;
                                        break;
                                        }
                                }
                                if (found==false) System.out.println("Book not found.");
                                System.out.println("Would you like to try entering another book to return? Enter y if so, any other character if not");
                                String l = reader.readLine();
                                if (!l.equals("y")){
                                    cont = false;
                                }
                            } while(cont==true);
                        }
                        else if (ansMenu=="4"){
                            //checkout book
                            boolean cont=true;
                            do{
                                System.out.println("Enter the title of the book you would like to check out");
                                String title = reader.readLine();
                                System.out.println("Enter the author of the book you would like to check out");
                                String author = reader.readLine();
                                boolean found = false;
                                for (int i=0;i<lib.allBooks.size();i++){
                                    if ((lib.allBooks.get(i).getTitle().equals(title)) && (lib.allBooks.get(i).getAuthor().equals(author))){
                                        lib.checkOutBook(user1, lib.allBooks.get(i));
                                        //reserve book?
                                        System.out.println("Book checked out.");
                                        found = true;
                                        break;
                                        }
                                }
                                if (found==false) System.out.println("Book not found.");
                                System.out.println("Would you like to try entering another book to check out? Enter y if so, any other character if not");
                                String l = reader.readLine();
                                if (!l.equals("y")){
                                    cont = false;
                                }
                            } while(cont==true);
                        }
                        else if (ansMenu=="5"){
                            //checked out books list
                            for (int i=0;i<user1.checkedOutList.size();i++){
                                System.out.println(user1.checkedOutList.get(i));
                            }
                        }
                        else if (ansMenu=="6"){
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
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
                        System.out.println("(8) View Checked Out Books");
                        String ansMenu  = reader.readLine();
                        boolean flag2=true;
                        //need to continue error checking
                        do{
                        flag2=true;
                        if (ansMenu=="1"){
                            //add book
                            boolean flagAdd = false;
                            int bookIDC;
                            int numCopiesInt;
                            while (flagAdd==false){
                                System.out.println("Enter the ID of the book you would like to add");
                                String bookID = reader.readLine();
                                try {
                                    bookIDC = Integer.parseInt(bookID);
                                } catch (NumberFormatException e) {
                                    System.out.println("ID has to be an integer");
                                    continue;
                                }
                                //if (!Library.contains(bookIDC)){
                                    System.out.println("Enter the title of the book you would like to add");
                                    String title= reader.readLine();
                                    System.out.println("Enter the author of the book you would like to add");
                                    String author= reader.readLine();
                                    System.out.println("Enter the number of copies of the book you would like to add");
                                    String numCopies = reader.readLine();
                                    try {
                                        numCopiesInt = Integer.parseInt(bookID);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Number of copies has to be an integer");
                                        continue;
                                    }
                                    //Library.addBook(title,author,bookIDC,numCopiesInt);
                                    flagAdd=false;
                                //}
                                //else{
                                    System.out.println("Library already contains book with this ID. If you would like to add copies of this book, type a.");
                                    System.out.println("If you would like to try entering the ID again, type y. Otherwise, type any other character to exit.");
                                    String answer = reader.readLine();
                                        if (answer.equalsIgnoreCase("y")){
                                            continue;
                                        }
                                        else if (answer.equalsIgnoreCase("a")){
                                            System.out.println("How many copies would you like to add?");
                                            String numCopies = reader.readLine();
                                            try {
                                                numCopiesInt = Integer.parseInt(bookID);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Number of copies has to be an integer");
                                                continue;
                                            }
                                            //Library.get(BookIDC).updateCopies(numCopiesInt);
                                            flagAdd=false;
                                        }
                                        else{
                                            flagAdd=false;s
                                        }
                                //}
                            }
                        }
                        else if (ansMenu=="2"){
                            //remove book
                            boolean flagRemove = false;
                            while (flagRemove==false){
                                System.out.println("Enter the ID of the book you would like to remove");
                                String bookID = reader.readLine();
                                try {
                                    int bookIDC = Integer.parseInt(bookID);
                                } catch (NumberFormatException e) {
                                    System.out.println("ID has to be an integer");
                                    continue;
                                }
                                //if (Library.contains(bookIDC)){
                                    //Library.remove(bookIDC);
                                    flagRemove=false;
                                //}
                                //else{
                                    System.out.println("Book not found. Type y to try again, or any other character to exit");
                                    String answer = reader.readLine();
                                        if (!answer.equalsIgnoreCase("y")){
                                            flagRemove = false;
                                        }
                                //}
                            }
                        }
                        else if (ansMenu=="3"){
                            //close account
                            boolean flagAccountDelete=true;
                            while (flagAccountDelete == true){
                                System.out.println("Enter the username of the account you would like to close");
                                String username = reader.readLine();
                                //if (Library.contains(username)){
                                    //Library.closeAccount(username);
                                    flagAccountDelete= false;
                                //}
                                //else{
                                    System.out.println("Username not found, type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountDelete = false;
                                    }
                                //}
                            }  
                        }
                        else if (ansMenu=="4"){
                            //open account
                            boolean flagAccountCreation=true;
                            while (flagAccountCreation == true){
                                System.out.println("Enter the username of the account you would like to open");
                                String username = reader.readLine();
                                System.out.println("Enter the password of the account you would like to open");
                                String password = reader.readLine();
                                //if (!Library.contains(username)){
                                    //Library.addAccount(username, password);
                                    flagAccountCreation= false;
                                //}
                                //else{
                                    System.out.println("Username already taken or invalid, type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountCreation = false;
                                    }
                                //}
                            }  
                        }
                        else if (ansMenu=="5"){
                            //freeze account
                            System.out.println("Enter the username of the account you would like to freeze");
                            String username = reader.readLine();
                            boolean flagFreeze=true;
                            while (flag == true){
                            //if (username in Library){
                                //Library.freeze(username);
                                flagFreeze=false;
                            //} 
                            //else{
                                System.out.println("Username not found or account is already frozen, would you like to try again? ");
                                System.out.println("Type y to try again or any other character to exit");
                                String answer = reader.readLine();
                                if (!answer.equalsIgnoreCase("y")){
                                    flag = false;
                                }
                            //} 
                            }
                        }
                        else if (ansMenu=="6"){
                            //unfreeze account
                            System.out.println("Enter the username of the account you would like to unfreeze");
                            String username = reader.readLine();
                            boolean flagUnfreeze=true;
                            while (flag == true){
                            //if (username in Library){
                                //Library.unfreeze(username);
                                flagUnfreeze=false;
                            //} 
                            //else{
                                System.out.println("Username not found or account is already unfrozen, would you like to try again?");
                                System.out.println("Type y to try again or any other character to exit");
                                String answer = reader.readLine();
                                if (!answer.equalsIgnoreCase("y")){
                                    flag = false;
                                }
                            //} 
                            }
                        }
                        else if (ansMenu=="7"){
                            //view checked out books
                            for (int i=0;i<lib.checkedOutBooks.size();i++){
                                System.out.println(lib.checkedOutBooks.get(i));
                            }
                        }
                        else if (ansMenu=="8"){
                            //sign out
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
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