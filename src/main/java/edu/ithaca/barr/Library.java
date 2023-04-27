package edu.ithaca.barr;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

public class Library {

    public ArrayList<Book> allBooks = new ArrayList<>();
    public HashMap<Integer, Book> checkedOutBooks;
    public static HashMap<User, Book> reservedBooks;
    public static List<User> userList = new ArrayList<>();
    public static List<String> usernameList = new ArrayList<>();
    public static List<String> passwordList = new ArrayList<>();

    // ArrayList<Author> authors = new ArrayList<>();
    // ArrayList<Account> accounts = new ArrayList<>();
    // ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    // private String name;
    private int id;

    @JsonCreator
    public Library(@JsonProperty("id") int id) {
        // this.name = name;
        this.id = id;
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
//            userList.add(newUser);
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
     * method checks to see if the library has a certain book (its status)
     * @param book book to be checked
     * @return boolean
     */
    public boolean searchBook(Book book) {
        for (Book allBook : allBooks) {
            if (allBook == book && book.getNumCopies() > 0) {
                return true;
            }
        }
        return false;
    }
     /**
     * if the reservation status of a book is false
     * the book can be reserved
     * @param book book being reserved
     * @return user if reserved, throws illegal argument exception if already reserved
     */
    public User reserveBook(User user, Book book) {
        if (searchBook(book)) {
            // int userID = user.getID();
            reservedBooks.put(user, book);
            return user;
        } else{
            throw new IllegalArgumentException("book is not available for reservation");
        }
    }
 

    /**
     * method checks out a book
     * and adds it to list of all checked out books
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
            } else {
                throw new IllegalArgumentException("book is not available for check out");
            }
        }

    /**
     * returns the book checked out by the user
     * @param user the user returning the book
     * @param book the book being returned
     * @return true if successful, false if not successful
     */
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
}
