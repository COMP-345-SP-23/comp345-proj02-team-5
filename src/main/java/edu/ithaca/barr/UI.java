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
        lib.allBooks.add(new Book(0, "Graphs", "Ali", 0));
        lib.allBooks.add(new Book(1, "Prim", "Primrose Everdeen", 5));
        lib.allBooks.add(new Book(2, "Prim", "Ali", 5));
        lib.allBooks.add(new Book(3, "Structs", "John", 1));
        Librarian librarian = new Librarian("Scrum", "chessgod");
        Library.librarianList.add(librarian);
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
                        boolean flag2=false;
                        //need to continue error checking
                        do{
                        //customer menu
                        System.out.println("Enter the corresponding number for which action you would like to take");
                        System.out.println("(1) Search Title");
                        System.out.println("(2) Search Author");
                        System.out.println("(3) Return Book");
                        System.out.println("(4) Checkout Book");
                        System.out.println("(5) Checked Out Books List");
                        System.out.println("(6) Reserved Books List");
                        System.out.println("(7) Change Password");
                        System.out.println("(8) Sign Out");

                        String ansMenu  = reader.readLine();
                        flag2=false;
                        if (ansMenu.equals("1")){
                            //search title
                            boolean exit = true;
                            do{
                            System.out.println("Enter the book title:");
                            String title = reader.readLine();
                            List<Book> answer = lib.searchByTitle(title);
                            if (answer.size()==0){
                                System.out.println("Book not found.");
                            }
                            else{
                                for (int i=0; i<answer.size();i++){
                                    System.out.println(answer.get(i).getAuthor());
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
                        else if (ansMenu.equals("2")){
                            //search author
                            boolean exit = true;
                            do{
                            System.out.println("Enter the book author:");
                            String title = reader.readLine();
                            List<Book> answer = lib.searchByAuthor(title);
                            if (answer.size()==0){
                                System.out.println("Author not found.");
                            }
                            else{
                                for (int i=0; i<answer.size();i++){
                                    System.out.println(answer.get(i).getTitle());
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
                                if (found==false) System.out.println("Book not found.");
                                System.out.println("Would you like to try entering another book to return? Enter y if so, any other character if not");
                                String l = reader.readLine();
                                if (!l.equals("y")){
                                    cont = false;
                                }
                            } while(cont==true);
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
                                        found = true;
                                        if (lib.allBooks.get(i).numCopies>1) {
                                            lib.checkOutBook(user1, lib.allBooks.get(i));
                                            //System.out.println("Checked out.");
                                        }
                                        else{
                                            System.out.println("Book has no copies available. If you would like to reserve this book, type y. Otherwise, enter any character.");
                                            String anss = reader.readLine();
                                            if (anss.equalsIgnoreCase("y")) {
                                                user1.reservedList.add(lib.allBooks.get(i));
                                                System.out.println("Book reserved.");
                                            }
                                        }
                                        //reserve book?
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
                        else if (ansMenu.equals("5")){
                            //checked out books list
                            for (int i=0;i<user1.checkedOutList.size();i++){
                                System.out.println(user1.checkedOutList.get(i).getTitle()+", "+user1.checkedOutList.get(i).getAuthor());
                            }
                            if (user1.checkedOutList.size()==0){
                                System.out.println("No checked out books.");
                            }
                            flag2=false;
                        }
                        else if (ansMenu.equals("6")){
                            for (int i=0;i<user1.reservedList.size();i++){
                                System.out.println(user1.reservedList.get(i).getTitle()+", "+user1.reservedList.get(i).getAuthor());
                            }
                            if (user1.reservedList.size()==0){
                                System.out.println("No reserved books.");
                            }
                            flag2=false;
                        }
                        else if (ansMenu.equals("7")){
                            //change pw
                            System.out.println("Enter your new password");
                            String pw = reader.readLine();
                            System.out.println("Password changed.");
                            user1.password=pw;
                        }
                        else if (ansMenu.equals("8")){
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                            flag2=false;
                            //ansMenu  = reader.readLine();
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
                    boolean confirmed = Library.confirmCredentialsAdmin(user,pass);
                    if (confirmed){
                        boolean flag2=false;
                        //need to continue error checking
                        do{
                        //admin menu
                        System.out.println("Enter the corresponding number for which action you would like to take");
                        System.out.println("(1) Add Book");
                        System.out.println("(2) Remove Book");
                        System.out.println("(3) Close Account");
                        System.out.println("(4) Open Account");
                        System.out.println("(5) Freeze Account");
                        System.out.println("(6) Unfreeze Account");
                        System.out.println("(7) View Checked Out Books");
                        System.out.println("(8) View Books");
                        System.out.println("(9) View A Book");
                        System.out.println("(10) View Accounts");
                        System.out.println("(11) Change Password");
                        System.out.println("(12) Sign Out");
                        String ansMenu  = reader.readLine();
                        flag2=false;
                        if (ansMenu.equals("1")){
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
                                boolean contains = false;
                                Book book = null;
                                for (int i=0;i<lib.allBooks.size();i++){
                                    if (lib.allBooks.get(i).getID()==bookIDC){
                                        contains=true;
                                        book = lib.allBooks.get(i);
                                    }
                                }
                                if (contains==false){
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
                                    lib.allBooks.add(book2);
                                    System.out.println("Book added");
                                }
                                else{
                                    System.out.println("Library already contains book with this ID. If you would like to add copies of this book, type a.");
                                    System.out.println("Otherwise, type any other character to exit.");
                                    String answer = reader.readLine();
                                        if (answer.equalsIgnoreCase("a")){
                                            boolean copiesUpdated=false;
                                            do{
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
                                            flagAdd=true;
                                            copiesUpdated=true;
                                        }while (copiesUpdated==false);
                                        }
                                        else{
                                            flagAdd=true;
                                        }
                                }
                                System.out.println("If you would like to try entering the ID again, type y. Otherwise, type any other character to exit.");
                                    String answer = reader.readLine();
                                        if (!answer.equalsIgnoreCase("y")){
                                            flagAdd=true;
                                        }
                            }
                        }
                        else if (ansMenu.equals("2")){
                            //remove book
                            boolean flagRemove = false;
                            while (flagRemove==false){
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
                                if (contains==true){
                                    boolean found = false;
                                    do{
                                    System.out.println("Would you like to decrement copies of this book, remove it altogether, or quit? Type either d, r, or q, respectively.");
                                    String anss = reader.readLine();
                                    int decnum=0;
                                    if (anss.equalsIgnoreCase("d")){
                                        System.out.println("Enter the decrement number:");
                                        String dec = reader.readLine();
                                        try {
                                            decnum = Integer.parseInt(dec);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Decrement number has to be an integer");
                                            continue;
                                        }
                                        book.numCopies-=decnum;
                                        System.out.println("Decremented.");
                                        found=true;
                                    }
                                    else if  (anss.equalsIgnoreCase("r")){
                                        lib.allBooks.remove(book);
                                        System.out.println("Book removed.");
                                        flagRemove=false;
                                        found=true;
                                    }
                                    else if (anss.equalsIgnoreCase("q")){
                                        flagRemove=false;
                                    found=true;
                                    }
                                    else{
                                        System.out.println("Invalid input.");
                                    }
                                } while(found==false);
                                }
                                else{
                                    System.out.println("Book not found.");
                                }
                                System.out.println("Type y to go again, or any other character to exit");
                                    String answer = reader.readLine();
                                        if (!answer.equalsIgnoreCase("y")){
                                            flagRemove = true;
                                        }
                            }
                        }
                        else if (ansMenu.equals("3")){
                            //close account
                            boolean flagAccountDelete=true;
                            while (flagAccountDelete == true){
                                System.out.println("Enter the username of the account you would like to close");
                                String username = reader.readLine();
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains==true){
                                    librarian.removeAccount(user3);
                                    System.out.println("Account closed.");
                                }
                                else{
                                    System.out.println("Username not found."); 
                                }
                                System.out.println("Type y to go again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountDelete = false;
                                    }
                            }  
                        }
                        else if (ansMenu.equals("4")){
                            //open account
                            boolean flagAccountCreation=true;
                            while (flagAccountCreation == true){
                                System.out.println("Enter the username of the account you would like to open");
                                String username = reader.readLine();
                                System.out.println("Enter the password of the account you would like to open");
                                String password = reader.readLine();
                                boolean contains = false;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        contains=true;
                                    }
                                }
                                if (contains==false){
                                    lib.createAccount("Jeff", username, password);
                                    System.out.println("Account created.");
                                }
                                else{
                                    System.out.println("Username already taken or invalid.");
                                }
                                System.out.println("Type y to go again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagAccountCreation = false;
                                    }
                            }  
                        }
                        else if (ansMenu.equals("5")){
                            //freeze account
                            boolean flagFreeze=true;
                            do{
                                System.out.println("Enter the username of the account you would like to freeze");
                            String username = reader.readLine();
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains==true){
                                    librarian.freezeAccount(user3);
                                    System.out.println(username+" frozen.");
                                } 
                                else{
                                    System.out.println("Username not found or account is already frozen, would you like to try again? ");
                                } 
                                System.out.println("Type y to go again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagFreeze = false;
                                    }
                            }  while (flagFreeze == true);
                        }
                        else if (ansMenu.equals("6")){
                            //unfreeze account
                            boolean flagUnfreeze=true;
                            do{
                                System.out.println("Enter the username of the account you would like to unfreeze");
                            String username = reader.readLine();
                                boolean contains = false;
                                User user3 = null;
                                for (int i=0;i<Library.userList.size();i++){
                                    if (Library.userList.get(i).getUserName().equals(username)){
                                        user3 = Library.userList.get(i);
                                        contains=true;
                                    }
                                }
                                if (contains==true){
                                    librarian.unfreezeAccount(user3);
                                    System.out.println(username+" unfrozen.");
                                } 
                                else{
                                    System.out.println("Username not found or account is already unfrozen, would you like to try again? ");
                                } 
                                System.out.println("Type y to go again or any other character to exit");
                                    String answer = reader.readLine();
                                    if (!answer.equalsIgnoreCase("y")){
                                        flagUnfreeze = false;
                                    }
                            }  while (flagUnfreeze == true);
                        }
                        else if (ansMenu.equals("7")){
                            //view checked out books
                            lib.checkedOutBooks.put(0, new Book(5, "ML", "Andrew Ng", 0));
                            for (int i=0;i<lib.checkedOutBooks.size();i++){
                                System.out.println(lib.checkedOutBooks.get(i).getTitle()+ ", "+ lib.checkedOutBooks.get(i).getAuthor());
                            }
                        }
                        else if (ansMenu.equals("8")){
                            //view books
                            for (int i=0;i<lib.allBooks.size();i++){
                                System.out.println(lib.allBooks.get(i).getTitle()+ ", "+ lib.allBooks.get(i).getAuthor());
                            }
                            if (lib.allBooks.size()==0) System.out.println("No books.");

                        }
                        else if (ansMenu.equals("9")){
                            //view book
                            boolean thing = true;
                            boolean found =false;
                            do{
                            System.out.println("Enter the title of the book you would like to print out");
                                    String title= reader.readLine();
                                    System.out.println("Enter the author of the book you would like print out");
                                    String author= reader.readLine();
                            for (int i=0;i<lib.allBooks.size();i++){
                                if (lib.allBooks.get(i).getAuthor().equals(author)&&lib.allBooks.get(i).getTitle().equals(title)){
                                System.out.println(lib.allBooks.get(i).getTitle()+ ", "+ lib.allBooks.get(i).getAuthor()+ ", Num Copies: "+ lib.allBooks.get(i).getNumCopies()+ ", ID: "+ lib.allBooks.get(i).getID());
                                found=true;}
                            }
                            if (found==false) System.out.println("Book not found.");
                            System.out.println("Would you like to search again? Enter y if yes, any other character if no.");
                            String anotherans= reader.readLine();
                            if (!anotherans.equalsIgnoreCase("y")){
                                thing=false;
                            }
                        } while (thing==true);

                        }
                        else if (ansMenu.equals("10")){
                            //view users
                            for (int i=0;i<Library.userList.size();i++){
                                System.out.println(Library.userList.get(i).getUserName());
                            }
                        }
                        else if (ansMenu.equals("11")){
                            //change pw
                            System.out.println("Enter your new password");
                            String pw = reader.readLine();
                            System.out.println("Password changed.");
                            librarian.password=pw;
                        }
                        else if (ansMenu.equals("12")){
                            //sign out
                            System.out.println("Thanks for visiting the online library!\n");
                            break;
                        }
                        else{
                            System.out.println("Invalid input. Please try again");
                            flag2=false;
                            //ansMenu  = reader.readLine();
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
            } else if (ans.equalsIgnoreCase("q")) {
                System.out.println("Thanks for visiting the online library!\n");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please enter again\n");
            }
        } while (true);
    }
}
