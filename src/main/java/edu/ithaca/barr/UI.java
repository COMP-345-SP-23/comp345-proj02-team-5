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
        Library lib = new Library();
        Library.userList.add(0, new User(0, "jeff", "jeff", "jeff"));
        lib.allBooks.add(new Book(0, "Graphs", "Ali", 5));
        Librarian librarian = new Librarian(0);
        User user1 = null;
        do{
            String ans = reader.readLine();
            if (ans.equalsIgnoreCase("c")){
                boolean flag = false;
                do {
                    System.out.println("Please enter your username\n");
                    String user = reader.readLine();
                    System.out.println("Please enter your password\n");
                    String pass = reader.readLine();
                    boolean confirmed = Library.confirmCredentials(user,pass);
                    if (confirmed){
                        for (int i=0;i<Library.userList.size();i++){
                            if ((Library.userList.get(i).getName().equals(user)) && (Library.userList.get(i).getPassword().equals(pass))){
                                user1 = Library.userList.get(i);
                            }
                        }
                        boolean flag2=true;
                        //need to continue error checking
                        do{
                        //customer menu
                        System.out.println("Enter the corresponding number for which action you would like to take");
                        System.out.println("(1) Search Title");
                        System.out.println("(2) Search Author");
                        System.out.println("(3) Return Book");
                        System.out.println("(4) Checkout Book");
                        System.out.println("(5) Checked Out Books List");
                        System.out.println("(6) Sign Out");
                        String ansMenu  = reader.readLine();
                        flag2=true;
                        if (ansMenu.equals("1")){
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
                            while (exit);
                        }
                        else if (ansMenu.equals("2")){
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
                            while (exit);
                        }
                        else if (ansMenu.equals("3")){
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
                                if (!found) System.out.println("Book not found.");
                                System.out.println("Would you like to try entering another book to return? Enter y if so, any other character if not");
                                String l = reader.readLine();
                                if (!l.equals("y")){
                                    cont = false;
                                }
                            } while(cont);
                        }
                        else if (ansMenu.equals("4")){
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
                                        //System.out.println("Book checked out.");
                                        found = true;
                                        break;
                                        }
                                }
                                if (!found) System.out.println("Book not found.");
                                System.out.println("Would you like to try entering another book to check out? Enter y if so, any other character if not");
                                String l = reader.readLine();
                                if (!l.equals("y")){
                                    cont = false;
                                }
                            } while(cont);
                        }
                        else if (ansMenu.equals("5")){
                            //checked out books list
                            for (int i=0;i<user1.checkedOutList.size();i++){
                                System.out.println(user1.checkedOutList.get(i));
                            }
                            if (user1.checkedOutList.size()==0){
                                System.out.println("No checked out books.");
                            }
                            flag2=false;
                        }
                        else if (ansMenu.equals("6")){
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                            flag2=false;
                            ansMenu  = reader.readLine();
                        }
                    }
                    while(!flag2);
                    }
                    
                    else{
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
                        if (ansMenu.equals("1")){
                            //add book
                            boolean flagAdd = false;
                            int bookIDC;
                            int numCopiesInt;
                            while (!flagAdd){
                                System.out.println("Enter the ID of the book you would like to add");
                                String bookID = reader.readLine();
                                try {
                                    bookIDC = Integer.parseInt(bookID);
                                } catch (NumberFormatException e) {
                                    System.out.println("ID has to be an integer");
                                    continue;
                                }
                                boolean contains = false;
                                Book book = null;
                                for (int i=0;i<lib.allBooks.size();i++){
                                    if (lib.allBooks.get(i).getID()==bookIDC){
                                        contains=true;
                                        book = lib.allBooks.get(i);
                                    }
                                }
                                if (!contains){
                                    System.out.println("Enter the title of the book you would like to add");
                                    String title= reader.readLine();
                                    System.out.println("Enter the author of the book you would like to add");
                                    String author= reader.readLine();
                                    System.out.println("Enter the number of copies of the book you would like to add");
                                    String numCopies = reader.readLine();
                                    try {
                                        numCopiesInt = Integer.parseInt(numCopies);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Number of copies has to be an integer");
                                        continue;
                                    }
                                    Book book2 = new Book(bookIDC, title, author, numCopiesInt);
                                    librarian.addBook(book2);
                                    System.out.println("Book added");
                                    flagAdd=false;
                                }
                                else{
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
                                                numCopiesInt = Integer.parseInt(numCopies);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Number of copies has to be an integer");
                                                continue;
                                            }
                                            book.numCopies+=numCopiesInt;
                                            System.out.println("Copies updated");
                                            flagAdd=false;
                                        }
                                        else{
                                            flagAdd=false;
                                        }
                                }
                            }
                        }
                        else if (ansMenu.equals("2")){
                            //remove book
                            boolean flagRemove = false;
                            while (!flagRemove){
                                System.out.println("Enter the ID of the book you would like to remove");
                                String bookID = reader.readLine();
                                int bookIDC;
                                try {
                                    bookIDC = Integer.parseInt(bookID);
                                } catch (NumberFormatException e) {
                                    System.out.println("ID has to be an integer");
                                    continue;
                                }
                                boolean contains = false;
                                Book book=null;
                                for (int i=0;i<lib.allBooks.size();i++){
                                    if (lib.allBooks.get(i).getID()==bookIDC){
                                        book = lib.allBooks.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains){
                                    librarian.removeBook(book);
                                    System.out.println("Book removed.");
                                    flagRemove=false;
                                }
                                else{
                                    System.out.println("Book not found. Type y to try again, or any other character to exit");
                                    String answer = reader.readLine();
                                        if (!answer.equalsIgnoreCase("y")){
                                            flagRemove = false;
                                        }
                                }
                            }
                        }
                        else if (ansMenu.equals("3")){
                            //close account
                            boolean flagAccountDelete=true;
                            while (flagAccountDelete){
                                System.out.println("Enter the username of the account you would like to close");
                                String username = reader.readLine();
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName()==username){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains){
                                    librarian.removeAccount(user3);
                                    System.out.println("Account closed.");
                                    flagAccountDelete= false;
                                }
                                else{
                                    System.out.println("Username not found, type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountDelete = false;
                                    }
                                }
                            }  
                        }
                        else if (ansMenu.equals("4")){
                            //open account
                            boolean flagAccountCreation=true;
                            while (flagAccountCreation){
                                System.out.println("Enter the username of the account you would like to open");
                                String username = reader.readLine();
                                System.out.println("Enter the password of the account you would like to open");
                                String password = reader.readLine();
                                boolean contains = false;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName()==username){
                                        contains=true;
                                    }
                                }
                                if (!contains){
                                    lib.createAccount("Jeff", username, password);
                                    System.out.println("Account created.");
                                    flagAccountCreation= false;
                                }
                                else{
                                    System.out.println("Username already taken or invalid, type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountCreation = false;
                                    }
                                }
                            }  
                        }
                        else if (ansMenu.equals("5")){
                            //freeze account
                            System.out.println("Enter the username of the account you would like to freeze");
                            String username = reader.readLine();
                            boolean flagFreeze=true;
                            do{
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains){
                                    librarian.freezeAccount(user3);
                                    System.out.println(username+" frozen.");
                                    flagFreeze=false;
                                } 
                                else{
                                    System.out.println("Username not found or account is already frozen, would you like to try again? ");
                                    System.out.println("Type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagFreeze = false;
                                    }
                                } 
                            }  while (flagFreeze);
                        }
                        else if (ansMenu.equals("6")){
                            //unfreeze account
                            System.out.println("Enter the username of the account you would like to unfreeze");
                            String username = reader.readLine();
                            boolean flagUnfreeze=true;
                            do{
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains){
                                    librarian.unfreezeAccount(user3);
                                    System.out.println(username+" unfrozen.");
                                    flagUnfreeze=false;
                                } 
                                else{
                                    System.out.println("Username not found or account is already unfrozen, would you like to try again? ");
                                    System.out.println("Type y to try again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagUnfreeze = false;
                                    }
                                } 
                            }  while (flagUnfreeze);
                        }
                        else if (ansMenu.equals("7")){
                            //view checked out books
                            for (int i=0;i<lib.checkedOutBooks.size();i++){
                                System.out.println(lib.checkedOutBooks.get(i));
                            }
                        }
                        else if (ansMenu.equals("8")){
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
                    while(!flag2);
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
            } else if (ans.equalsIgnoreCase("q")) {
                System.out.println("Thanks for visiting the online library!\n");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter again\n");
            }
        } while (true);
    }
}
