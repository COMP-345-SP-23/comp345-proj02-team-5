package edu.ithaca.barr;

import java.util.ArrayList;

public class Library {
    
    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, Book> CheckedOutBooks;
    //ArrayList<Author> authors = new ArrayList<>();
    //ArrayList<Account> accounts = new ArrayList<>();
    //ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    private String name;
    
    public Library(String name){
        this.name = name;
        this.CheckedOutBooks = new HashMap<>();


    public Library(){


    }

    /* 
    public ArrayList<Book> getBookList(){
        return books;
    }

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

    public boolean checkOutBook(){
        //implement
        return false;
    }

    public boolean returnBook(Book book) {
        return false;
        
    }
}
