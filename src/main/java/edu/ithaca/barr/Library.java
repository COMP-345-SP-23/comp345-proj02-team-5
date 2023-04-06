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

    

    public boolean searchBook(Book book){
        for( int i=0; i<AllBooks.size(); i++){
            if(AllBooks.get(i) == book && book.getNumCopies() > 0){
                return true;
            }
        }
        return false;

    }
    public void checkOutBook(User user, Book book){
        // method to be implemented
        if(searchBook(book) == true){
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
        return false;
    }
}
