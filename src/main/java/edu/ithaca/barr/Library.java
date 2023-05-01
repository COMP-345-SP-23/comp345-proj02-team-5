package edu.ithaca.barr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    ArrayList<Book> allBooks = new ArrayList<>();
    HashMap<Integer, Book> checkedOutBooks;
    HashMap<User, Book> reservedBooks;
    public static List<User> userList = new ArrayList<>();
    public static List<String> usernameList = new ArrayList<>();
    public static List<String> passwordList = new ArrayList<>();


    public Library() {
        this.checkedOutBooks = new HashMap<>();
        this.reservedBooks = new HashMap<>();
    }

    /**
     * method returns an arraylist of all books 
     * in the library's system
     */
    public ArrayList<Book> getBookList() {
        return allBooks;
    }
   
    /**
     * creates an account
     * @param name the user's name
     * @param username the user's username
     * @param password the user's password
     * @return true if account created, false if not
     */
    public boolean createAccount(String name, String username, String password){
        if(!Library.usernameList.contains(username) && !Library.passwordList.contains(password)){
            int id = (int)Math.ceil(Math.random());
            User newUser = new User(id, name, username, password);
            userList.add(newUser);
            return true;
        }
        return false;
    }

    /**
     * method confirms credentials of users
     * @param user
     * @param password
     * @param username
     * @return boolean
     */
    public static boolean confirmCredentials(User user, String password, String username){
        for(int i =0; i<userList.size();){
            if(userList.get(i) == user){
                if(user.getPassword().equals(password) && user.getUserName().equals(username)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                throw new IllegalArgumentException("user is not in our systems");
    
            }
        }
        return false;
        
    }

    /**
     * searches a book by title
     * @param title
     * @return
     */
    public List<Book> searchByTitle(String title) {
        List<Book> titleResults = new ArrayList<>();
        for (Book book : this.allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleResults.add(book);
            }
        }
        return titleResults;
    }

    /**
     * searches book by author's name 
     * @param author
     * @return
     */
    public List<Book> searchByAuthor(String author) {
        List<Book> authorResult = new ArrayList<>();
        for (Book book : this.allBooks) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorResult.add(book);
            }
        }
        return authorResult;
    }

    /**
     * method checks to see if the library has a certain book
     * 
     * @param book
     * @return boolean
     */
    public boolean searchBook(Book book) {
        for (int i = 0; i < allBooks.size(); i++) {
            if (allBooks.get(i) == book && book.getNumCopies() > 0) {
                return true;
            }
        }
        return false;
    }
        

  

    /**
     * the book can be reserved
     * 
     * @param book
     * @return
     * @param book book being reserved
     * @return user if reserved, throws illegal argument exception if already reserved
     */
    public User reserveBook(User user, Book book) {
        if (searchBook(book)) {
            // int userID = user.getID();
            reservedBooks.put(user, book);
            return user;

        }

        else{
            throw new IllegalArgumentException("book is not available for reservation");
        }
    }
 

    /**
     * method checks out a book
     * and adds it to list of all checked out books
     * 
     * @param user
     * @param book
     * @param user user checking out
     * @param book book being checked out
     */
    public void checkOutBook(User user, Book book) {
        if (reserveBook(user, book) == user) {
            if(reservedBooks.get(user)== book){
                System.out.println("book checked out");
                book.setNumCopies(book);
                int userID = user.getID();
                checkedOutBooks.put(userID, book);
            }
        }

        else {
            throw new IllegalArgumentException("book is not available for check out");
        }
    }
    
    /**
     * method returns a book that was checked out
     * @param user
     * @param book
     * @return
     */
    public boolean returnBook(User user, Book book) {
        int userId = user.getID();
        if (checkedOutBooks.containsKey(userId) && checkedOutBooks.get(userId) == book) {
            checkedOutBooks.remove(userId);
            book.returnInfo();
            return true;
        } 
        else {
            return false;
        }
    }

    /**
     * A day passes so the time for all books currently checked out decreases by 1
     */
    public void passTime(){

    }



    public static void addUser(String user, String pass) {
    }


}
