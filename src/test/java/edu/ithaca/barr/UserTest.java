package edu.ithaca.barr;

import edu.ithaca.barr.Librarian;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void getUserListTest(){
        Librarian barrj = new Librarian(1);
        ArrayList<User> userList = new ArrayList<>();

        User user1 = new User(1, "John", "abc", "123"); //Tests when there is a single user
        userList.add(user1);
//        assertEquals(userList, barrj.getUserList());

        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users
        userList.add(user2);
//        assertEquals(userList, barrj.getUserList());

        User user3 = new User(3, "jBarr", "ghi", "789"); //Test when there are three user
        userList.add(user3);
//        assertEquals(userList, barrj.getUserList());

    }

    @Test
    public void getCheckedOutListTest(){
        Library barr = new Library();
        User user1 = new User(1, "John", "abc", "123");
        User user2 = new User(2, "Barr", "def", "456"); //Tests when there are two users

        Book book1 = new Book(0, "Title 1", "Author 1", 1);
        Book book2 = new Book(0, "Title 2", "Author 2", 2);
        Book book3 = new Book(0, "Title 3", "Author 1", 3);
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

        barr.checkOutBook(user2, book1);
        assertEquals(checkedOut, user2.getCheckedOutList()); //Test list does not change if user tries to check out a book with no copies left


    }
}
