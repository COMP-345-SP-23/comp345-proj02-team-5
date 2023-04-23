package edu.ithaca.barr;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    void changePasswordUsernameTest(){
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

        Book book1 = new Book(1, "Title 1", "Author 1", 1,"unreserved");
        Book book2 = new Book(2, "Title 2", "Author 2", 2,"unreserved");
        Book book3 = new Book(3, "Title 3", "Author 1", 3,"unreserved");
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

    public void getReservedListTest(){
        Library barr = new Library();
        User user1 = new User(1, "John", "abc", "123");
        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users

        Book book1 = new Book(1, "Title 1", "Author 1", 1,"unreserved");
        Book book2 = new Book(2, "Title 2", "Author 2", 0,"reserved");
        Book book3 = new Book(3, "Title 3", "Author 1", 0,"reserved");
        List<Book> reserved = new ArrayList<>();

        barr.allBooks.add(book1);
        barr.allBooks.add(book2);
        barr.allBooks.add(book3);

        assertEquals(reserved, user1.getCheckedOutList()); //Test list is empty when no books reserved

        barr.checkOutBook(user1, book1);
        assertEquals(reserved, user1.getReservedList()); //Test list is empty when a book was checked out

//        barr.checkOutBook(user1, book2);
        //Should reserve be a part of the checkOutBook method?
//        barr.reserve(user1, book2);
        assertEquals(reserved, user1.getCheckedOutList()); //Test list one book when a book is reserved

        barr.checkOutBook(user2, book1);
        //        barr.reserve(user2, book1);

        assertEquals(reserved, user2.getCheckedOutList()); //Test books are reserved only for the specific user

//        assertThrows(IllegalArgumentException.class, ()->   barr.reserved(user2, book1));   //Test list does not change if user tries to check out a book with no copies left
    }
}
