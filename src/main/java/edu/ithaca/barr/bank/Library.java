package edu.ithaca.barr.bank;

import java.util.ArrayList;

public class Library {
    
    private ArrayList<Book> books; // an ArrayList to store the books
    
    // Constructor to initialize the ArrayList
    public Library() {
        books = new ArrayList<Book>();
    }
    
    // Method to add a book to the ArrayList
    public void addBook(Book book) {
        books.add(book);
    }
    
    // Method to search for a book by its title
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // return null if the book is not found
    }
    
    // Method to return a book that was borrowed
    public void returnBook(Book book) {
        book.returnBook();
    }
}



    