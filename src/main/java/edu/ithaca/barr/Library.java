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

    // ArrayList<Author> authors = new ArrayList<>();
    // ArrayList<Account> accounts = new ArrayList<>();
    // ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    // private String name;

    public Library() {
        // this.name = name;
        this.checkedOutBooks = new HashMap<>();
        this.reservedBooks = new HashMap<>();
    }

    public ArrayList<Book> getBookList() {
        return allBooks;
    }
    /*
     * public ArrayList<Book> getAuthorList(){
     * return authors;
     * }
     * 
     * public ArrayList<Book> getAccountsList(){
     * return accounts;
     * }
     * 
     * public ArrayList<Book> getLibrariansList(){
     * return librarians;
     * }
     * 
     * public boolean closeAccount(){
     * //implement
     * }
     * 
     */

   /*
    public ArrayList<Book> getAuthorList(){
        return authors;
    }

    public ArrayList<Book> getAccountsList(){
        return accounts;
    }

    public ArrayList<Book> getLibrariansList(){
        return librarians;
    }

    public boolean closeAccount(){
        //implement
    }

    */

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

    public static boolean confirmCredentials(String password, String username){
        // for loop to itereate through userlist
        for(int i =0; i<userList.size();){
            if ((userList.get(i).getName().equals(username)) && (userList.get(i).getPassword().equals(password))){
                return true;
            }
        }
        return false;
        
    }

    public List<Book> searchByTitle(String title) {
        List<Book> titleResults = new ArrayList<>();
        for (Book book : this.allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleResults.add(book);
            }
        }
        return titleResults;
    }

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
        // method to be implemented
            if (reserveBook(user, book) == user) {
                if(reservedBooks.get(user)== book){
                    System.out.println("Book checked out.");
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
     * Gets a list of books currently checked out
     * return: list of books checked out
     */
    // public List<Book> getCheckedOutList(){
    // return new ArrayList<>(CheckedOutBooks.values());
    // }
      
   

//    public List<Book> getCheckedOutList(){
//        return null;
//    }

    public boolean returnBook(User user, Book book) {
        int userId = user.getID();
        if (checkedOutBooks.containsKey(userId) && checkedOutBooks.get(userId) == book) {
            checkedOutBooks.remove(userId);
            book.returnInfo();
            return true;
        } else {
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
