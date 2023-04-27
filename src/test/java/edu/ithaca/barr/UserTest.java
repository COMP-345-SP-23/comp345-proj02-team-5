package edu.ithaca.barr;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserTest {

    @Test
    public void changePasswordUsernameTest(){
        //create a bunch of user objects
        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofU_21");
        User user3 = new User(268, "Vicky ", "Conrad", "Vconrad/25");
        User user2 = new User(123, "Cody", "Carnes", "Ccordy74");

        assertEquals("Vanessa99", user1.changePassword(user1, "Vanessa99", "vmpofU_21"));
        assertEquals("VictoriaConrad", user3.changeUsername(user3, "VictoriaConrad", "Conrad"));
        assertEquals("Ccordy74", user2.changePassword(user2, "Cordy2022", "CCarnes74"));
        assertEquals("vmpofu", user1.changeUsername(user1, "VanessaMpofu", "VMpofu"));

    }


    @Test
    public void getUserListTest(){
        Librarian barrj = new Librarian(1);
        ArrayList<User> userList = new ArrayList<>();

        User user1 = new User(1, "John", "abc", "123"); //Tests when there is a single user
        userList.add(user1);
        assertEquals(userList, barrj.getUserList());

        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users
        userList.add(user2);
        assertEquals(userList, barrj.getUserList());

        User user3 = new User(3, "jBarr", "ghi", "789"); //Test when there are three user
        userList.add(user3);
        assertEquals(userList, barrj.getUserList());

    }

    @Test
    public void getCheckedOutListTest(){
        Library barr = new Library();
        User user1 = new User(1, "John", "abc", "123");
        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users

        Book book1 = new Book(1, "Title 1", "Author 1", 1);
        Book book2 = new Book(2, "Title 2", "Author 2", 2);
        Book book3 = new Book(3, "Title 3", "Author 1", 3);
        List<Book> checkedOut = new ArrayList<>();

        barr.allBooks.add(book1);
        barr.allBooks.add(book2);
        barr.allBooks.add(book3);

        assertEquals(checkedOut, user1.getCheckedOutList()); //Test list is empty when no books checked out

        barr.checkOutBook(user1, book1);
        assertEquals(checkedOut, user1.getCheckedOutList()); //Test list has the book that was just checked out

        barr.checkOutBook(user1, book2);
        assertEquals(checkedOut, user1.getCheckedOutList()); //Test list has the books that have been checked out

        barr.checkOutBook(user2, book2);
        assertEquals(checkedOut, user2.getCheckedOutList()); //Test books are checked out only for the specific user

        assertThrows(IllegalArgumentException.class, ()->   barr.checkOutBook(user2, book1));   //Test list does not change if user tries to check out a book with no copies left
    }

    @Test

    public void getReservedBooksTest(){
        Library barr = new Library();
        User user1 = new User(1, "John", "abc", "123");
        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users

        Book book1 = new Book(1, "Title 1", "Author 1", 0);
        Book book2 = new Book(2, "Title 2", "Author 2", 2);
        Book book3 = new Book(3, "Title 3", "Author 1", 1);
        HashMap<User,Book> reserved = new HashMap<>();
        HashMap<User,Book> reserved2 = new HashMap<>();

        barr.allBooks.add(book1);
        barr.allBooks.add(book2);
        barr.allBooks.add(book3);

        assertNull(user1.getReservedBooks()); //Test list is empty when no books reserved

        assertThrows(IllegalArgumentException.class, ()->   barr.reserveBook(user1, book1));    //Tests list is empty when a book cannot be reserved

        barr.reserveBook(user1, book2);
        reserved.put(user1, book2);
        assertEquals(reserved.get(user1), user1.getReservedBooks());  //Tests list has one book when one book is successfully reserved

        assertThrows(IllegalArgumentException.class, ()->   barr.reserveBook(user2, book1)); //Tests that a book that is already reserved cannot be reserved by another person

        barr.reserveBook(user2, book3);
        reserved.put(user2, book3);
        assertEquals(reserved.get(user2), user2.getReservedBooks());  //Tests that the reserved list is only for the specified user
    }
}
