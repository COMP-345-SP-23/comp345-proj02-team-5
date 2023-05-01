package edu.ithaca.barr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LibrarianTest {

    @Test
    void addBookTest() {
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book(1, "Book1", "John Barr", 3);
        Book book2 = new Book(2, "Book2", "Johnny Barr", 2);
        Book book3 = new Book(3, "Book3", "Jo Bar", 1);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is empty
        bookList.add(book1);
        barrLibrarian.addBook(book1);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book2);
        barrLibrarian.addBook(book2);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book3);
        barrLibrarian.addBook(book3);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test another copy of a book is added
    }

    @Test
    void removeBookTest() {
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book(1, "Book1", "John Barr", 3);
        Book book2 = new Book(2, "Book2", "Johnny Barr", 2);
        Book book3 = new Book(3, "Book3", "Jo Bar", 1);

        barrLibrarian.addBook(book1);
        barrLibrarian.addBook(book2);
        bookList.add(book1);
        bookList.add(book2);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is not empty
        bookList.remove(book2);
        barrLibrarian.removeBook(book2);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test nothing happens when book that is not at library is removed
        bookList.remove(book1);
        barrLibrarian.removeBook(book1);

        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);

        assertEquals(bookList, barrLibrarian.getBookList());  //list remains empty when trying to remove a book from empty list
    }

    @Test
    void freezeAccountTest() {
        Librarian barr = new Librarian(1);
        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");
        user2.frozen = true;

        assertFalse(barr.isFrozen(user1));
        assertTrue(barr.isFrozen(user2));

        assertTrue(barr.freezeAccount(user1));
        assertTrue(barr.freezeAccount(user2));
    }

    @Test
    void unfreezeAccountTest() {
        Librarian barr = new Librarian(1);
        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");
        user2.frozen = true;

        assertFalse(barr.isFrozen(user1));
        assertTrue(barr.isFrozen(user2));

        assertFalse(barr.unfreezeAccount(user1));
        assertFalse(barr.unfreezeAccount(user2));
    }

    @Test
    void removeAccountTest() {
        Librarian barr = new Librarian(1);
        ArrayList<User> userList = new ArrayList<>();

        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");

        userList.add(user1);
        userList.add(user2);

        assertEquals(userList, barr.getUserList()); //Tests that accounts are added when created

        barr.removeAccount(user2);
        userList.remove(user2);
        assertEquals(userList, barr.getUserList()); //Tests that a specific account can be removed

        User user3 = new User(3, "Barr3", "jbarro", "pass");
        User user4 = new User(4, "Barr4", "barro", "word");

        userList.add(user3);
        userList.add(user4);

        assertEquals(userList, barr.getUserList()); //Tests that accounts are added when

        barr.removeAccount(user1);
        userList.remove(user1);
        assertEquals(userList, barr.getUserList()); //Tests that a specific account (in this case the first account) can be removed
    }


    @Test
    void searchAccountTest() {
        Librarian barr = new Librarian(1);
        ArrayList<User> userList = new ArrayList<>();

        User user1 = new User(1, "Barr1", "jbarr", "password");
        User user2 = new User(2, "Barr2", "barr", "psswrd");

        userList.add(user1);
        userList.add(user2);

        assertEquals(userList, barr.getUserList()); //Tests that accounts are added when created

        assertEquals(user1, barr.searchAccount(user1));  //Tests that an account that is in the list is found

        barr.removeAccount(user2);

        assertNull(barr.searchAccount(user2));  //Tests that an account that is not in the list is not found

        barr.removeAccount(user1);

        assertNull(barr.searchAccount(user1));  //Tests that an account that has been removed is not found

    }
}



