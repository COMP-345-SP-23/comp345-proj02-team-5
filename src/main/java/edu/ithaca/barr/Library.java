package edu.ithaca.barr;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class Library {
    
    ArrayList<Book> allBooks = new ArrayList<>();
    HashMap<Integer, Book> checkedOutBooks;
    public static List<User> userList = new ArrayList<>();

    //ArrayList<Author> authors = new ArrayList<>();
    //ArrayList<Account> accounts = new ArrayList<>();
    //ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    //private String name;
    
    public Library(){
       // this.name = name;
        this.checkedOutBooks = new HashMap<>();
    }

  

    
    public ArrayList<Book> getBookList(){
        return allBooks;
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
        List<Book> titleResults = new ArrayList<>();
        for (Book book : this.allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                titleResults.add(book);
            }
        }
        return titleResults;
    }

    public List<Book> searchByAuthor(String author){
        List<Book> authorResult = new ArrayList<>();
        for (Book book : this.allBooks) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                authorResult.add(book);
            }
        }
        return authorResult;
    }

    public boolean searchBook(Book book){
        for(int i = 0; i< allBooks.size(); i++){
            if(allBooks.get(i) == book && book.getNumCopies() > 0){
                return true;
            }
        }
        return false;

    }
    public void checkOutBook(User user, Book book){
        // method to be implemented
        if(searchBook(book)){
            System.out.println("book checked out");
            book.setNumCopies(book);
            int userID = user.getID();
            checkedOutBooks.put(userID, book);
        }

        else{
            throw new IllegalArgumentException("book is not available for check out");
        }
        
       
    }
    public boolean returnBook(){
        //implement
        return false;
    }

    public boolean returnBook(Book book) {
        return false;
        
    }
}
