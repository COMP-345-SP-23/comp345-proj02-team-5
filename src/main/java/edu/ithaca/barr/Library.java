package edu.ithaca.barr;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    
    ArrayList<Book> books = new ArrayList<>();
    HashMap<Integer, Book> CheckedOutBooks;
    //ArrayList<Author> authors = new ArrayList<>();
    //ArrayList<Account> accounts = new ArrayList<>();
    //ArrayList<edu.ithaca.barr.Librarian> librarians = new ArrayList<>();

    private String name;
    
    public Library(String name){
        this.name = name;
<<<<<<< HEAD
=======
        this.CheckedOutBooks = new HashMap<>();


    public Library(){


>>>>>>> 0be9dee9a87e92687bfd0a1166f4c1158e6e01b6
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

    public Book searchByTitle(){
        //implement
        return null;
    }

    public Book searchByAuthor(){
        //implement
        return null;
    }

    public boolean checkOutBook(){
        //implement
        return false;
    }

    public boolean returnBook(){
        //implement
        return false;
    }
}
