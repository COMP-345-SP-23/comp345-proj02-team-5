package edu.ithaca.barr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LibraryTest {
    
    @Test
    void createAccountTest(){
        //create users and passwords, assert they are in the system and have correct values
    }

    @Test
    void closeAccountTest(){
        //close out accounts using usernames and passwords and assure they are removed.
    }

    @Test
    void searchByTitleTest(){
        
    }

    @Test
    void searchByAuthorTest(){
        
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

        Library library = new Library();
        library.AllBooks.add(book1);
        library.AllBooks.add(book2);
        library.AllBooks.add(book3);
        library.AllBooks.add(book4);

        library.checkOutBook(user1, book2);
        library.checkOutBook(user3, book3);

        // make user object
        //make a Library object
        assertEquals(2, library.CheckedOutBooks.size());
        assertEquals(book3 , library.CheckedOutBooks.get(user3.getID()));
        assertEquals(4, book2.getNumCopies());
        assertThrows(IllegalArgumentException.class, ()->   library.checkOutBook(user3, book4));
    }
        
    

    @Test
    void returnTest(){
        
    }
}
