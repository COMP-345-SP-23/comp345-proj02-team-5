package edu.ithaca.barr;

import edu.ithaca.barr.Librarian;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LibrarianTest {

    @Test
    void addBookTest(){
        Library barrLib = new Library("Barr");
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book(1, "Book1", "John Barr", 3);
        Book book2 = new Book(2,"Book2", "Johnny Barr", 2);
        Book book3 = new Book(3,"Book3", "Jo Bar", 1);


        // assertEquals(bookList, barrLib.getBookList());  //Test list is empty
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is empty
        bookList.add(book1);
        barrLibrarian.addBook(book1);
        // assertEquals(bookList, barrLib.getBookList());  //Test new book added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book2);
        barrLibrarian.addBook(book2);
        // assertEquals(bookList, barrLib.getBookList());  //Test new book added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book3);
        barrLibrarian.addBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //Test another copy of a book is added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test another copy of a book is added

    }

    @Test
    void removeBookTest(){
        Library barrLib = new Library("Barr");
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book(1, "Book1", "John Barr", 3);
        Book book2 = new Book(2,"Book2", "Johnny Barr", 2);
        Book book3 = new Book(3,"Book3", "Jo Bar", 1);

        barrLibrarian.addBook(book1);
        barrLibrarian.addBook(book2);
        bookList.add(book1);
        bookList.add(book2);

        // assertEquals(bookList, barrLib.getBookList());  //Test list is not empty
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is not empty
        bookList.remove(book2);
        barrLibrarian.removeBook(book2);
        // assertEquals(bookList, barrLib.getBookList());  //Test list removes the specified book
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //Test nothing happens when book that is not at library is removed
        assertEquals(bookList, barrLibrarian.getBookList());  //Test nothing happens when book that is not at library is removed
        bookList.remove(book1);
        barrLibrarian.removeBook(book1);
        // assertEquals(bookList, barrLib.getBookList());  //Test list removes the specified book
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //list remains empty when trying to remove a book from empty list
        assertEquals(bookList, barrLibrarian.getBookList());  //list remains empty when trying to remove a book from empty list


    }

    @Test
    void freezeAccountTest(){
        Librarian barr = new Librarian(1);
        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");
        user2.frozen = true;

        assertFalse(user1.isFrozen());
        assertTrue(user2.isFrozen());

        assertTrue(barr.freezeAccount(user1));
        assertTrue(barr.freezeAccount(user2));
    }

    @Test
    void unfreezeAccountTest(){
        Librarian barr = new Librarian(1);
        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");
        user2.frozen = true;

        assertFalse(user1.isFrozen());
        assertTrue(user2.isFrozen());

        assertFalse(barr.unfreezeAccount(user1));
        assertFalse(barr.unfreezeAccount(user2));
    }

    @Test
    void removeAccountTest(){

    }

    @Test
    void checkOutTest(){
        Book book1 = new Book(2537, "Feminists", "bell hooks", 10);
        Book book2 = new Book(2587, "The Da Vinci Code", "Dan Brown", 5);
        Book book3 = new Book(7659, "Divergent", "Veronica Roth", 2);
        Book book4 = new Book(8302, "The Maze Runner", "James Dashner", 0);
        // make a librarian object
        // create user objects
        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofu_21");
        User user3 = new User(268, "Vanessa", "vmpofu", "vmpofu_21");

        Librarian librarian = new Librarian(3);
        librarian.checkOutBook(user1, book2);
        librarian.checkOutBook(user3, book3);
        // make user object
        //make a Library object
        Library library = new Library("bell hooks");
        assertEquals(2, library.CheckedOutBooks.size());
        //assertEquals("DivergentVR" , CheckedOutBooks.get(user3));
        assertEquals(4, book2.getNumCopies());
        assertThrows(IllegalArgumentException.class, ()->   librarian.checkOutBook(user3, book3));
    }

}

//    @Test
//    void getCheckedOutListTest(){
//      This is for library now
//    }



