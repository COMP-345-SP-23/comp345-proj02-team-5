package edu.ithaca.barr;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Librarian {

    
    public String username;
    public String password;
    private String title;
    private int id;
    private ArrayList<Book> bookList = new ArrayList<>();

    @JsonCreator
    public Librarian(@JsonProperty("id") int id){
        this.id = id;
    }

    /**
     * gets and returns the librarian's id
     * @return the librarian's id
     */
    public int getId(){
        return id;
    }

    /**
     * Adds a book to the list of books at the library, or increases the number of copies
     * if the book is already at the library
     */
    public void addBook(Book book){
        int i;
        boolean there = false;
        for(i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                book.numCopies++;
                there = true;
            }
        }
        if(!there){
            bookList.add(book);
        }
    }

    public String getName(){
        return username;
    }

    public String getPass(){
        return password;
    }

    /**
     * Decreases the count of a book at the library
     */
    public void removeBook(Book book){
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                bookList.remove(book);
            }
        }

        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                if(bookList.get(i).numCopies > 0){
                    book.numCopies--;
                }
                bookList.remove(book);
            }
        }
    }

    /**
     * Freezes an account
     * @param account the account being frozen
     * @return True if successful, false if unsuccessful
     */
    public boolean freezeAccount(User account){
        account.frozen = true;
        return account.isFrozen();
    }

    /**
     * Unfreezes an account
     * @param account the account being unfrozen
     * @return True if successful, false if unsuccessful
     */
    public boolean unfreezeAccount(User account){
        account.frozen = false;
        return account.isFrozen();
    }

    /**
     * Checks to see if an account is frozen
     * @param account the account being checked if frozen
     * @return True if frozen, false if unfrozen
     */
    public boolean isFrozen(User account){
        return account.frozen;
    }

    /**
     * Removes an account from the system
     * @param account the account being removed
     */
    public void removeAccount(User account){
      Library.userList.remove(account);
    }

    /**
     * Gets a list of books currently checked out
     * @return list of books checked out
     */
//    public List<Book> getCheckedOutList(){
//      used on type library
//    }

    /**
     * Gets a list of books the library has
     * @return list of books at the library
     */
//    public List<Book> getBookList(){
//        used on type library
//    }

  /**
     * Gets a list of books the library has
     * @return list of books at the library
     */
    public List<Book> getBookList(){
        return bookList;
    }

    /**
     * Gets a list of users at the library
     * @return list of users at the library
     */
    public List<User> getUserList(){
        return Library.userList;
    }

    /**
     * searches userlist for a specific user
     * @param account that is being searched for
     * @return the account if found, null if account not found
     */
    public User searchAccount(User account){
        for(User u : Library.userList){
            if(u.equals(account)){
                return account;
            }
        }
        return null;
    }

}
