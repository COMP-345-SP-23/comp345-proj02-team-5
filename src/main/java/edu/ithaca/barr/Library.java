package edu.ithaca.barr;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class Library {
    
    ArrayList<Book> AllBooks = new ArrayList<>();
    HashMap<Integer, Book> CheckedOutBooks;
    //ArrayList<Author> authors = new ArrayList<>();
    //ArrayList<Account> accounts = new ArrayList<>();
    //ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    //private String name;
    
    public Library(){
       // this.name = name;
        this.CheckedOutBooks = new HashMap<>();
    }

  

    
    public ArrayList<Book> getBookList(){
        return AllBooks;
    }
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

    public boolean createAccount(String username, String password){
        //create a new Account using username and password
        //add it to accounts list so long as it is valid
        return false;
    }

    

    public List<Book> searchByTitle(String title){
        List<Book> titleResults = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleResults.add(book);
            }
        }
        return titleResults;
    }

    public List<Book> searchByAuthor(String author){
        List<Book> authorResult = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorResult.add(book);
            }
        }
        return authorResult;
    }

    /**
     * method checks the reservation status of a book 
     * @param book
     * @return boolean
     */
    public boolean checkStatus(Book book){
        if(book.getStatus().equals("unreserved")){
            return false;
        }
        else{
            return true;
        }
    }
     /**
     * if the reservation status of a book is false
     * the book can be reserved
     * @param book
     * @return 
     */
    public User reserveBook(User user, Book book){
        if(!checkStatus(book) &&  book.getNumCopies() > 0){
            book.setStatus("reserved");
            return user;             
        }
        else{
            throw new IllegalArgumentException("book is already reserved");
        }
        
    }

   

    /**
     * method checks to see if the library has a certain book 
     * @param book
     * @return boolean
     */
    public boolean searchBook(Book book){
        for( int i=0; i<AllBooks.size(); i++){
            if(AllBooks.get(i) == book && book.getNumCopies() > 0){
                return true;
            }
        }
        return false;

    }

    /**
     * method checks out a book
     * and adds it to list of all checked out books
     * @param user
     * @param book
     */
    public void checkOutBook(User user, Book book){
        // method to be implemented
        if(searchBook(book) == true && reserveBook(user, book) == user){
            System.out.println("book checked out");
            book.setNumCopies(book);
            int userID = user.getID();
            CheckedOutBooks.put(userID, book);
        }

        else{
            throw new IllegalArgumentException("book is not available for check out");
        }
    
       
    }
    public boolean returnBook(){
        //implement
    }
    
    public boolean returnBook(Book book) {
        return false;
        
    }
   

     /**
     * Gets a list of books currently checked out
     * return: list of books checked out
     */
    public List<Book> getCheckedOutList(){
        return new ArrayList<>(CheckedOutBooks.values());
    }


}
