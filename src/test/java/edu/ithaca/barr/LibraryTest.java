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
        Library library = new Library("My Library");
        Book book1 = new Book(0, "Title 1", "Author 1", 0);
        Book book2 = new Book(0, "Title 2", "Author 2", 0);
        Book book3 = new Book(0, "Title 1", "Author 3", 0);
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);

        // Test search with existing title
        List<Book> result1 = library.searchByTitle("Title 1");
        assertEquals(2, result1.size());
        assertEquals(book1, result1.get(0));
        assertEquals(book3, result1.get(1));

        // Test search with non-existing title
        List<Book> result2 = library.searchByTitle("Title 4");
        assertEquals(0, result2.size());
    }
        
    

    @Test
    void searchByAuthorTest(){
        Library library = new Library("My Library");
        Book book1 = new Book(0, "Title 1", "Author 1", 0);
        Book book2 = new Book(0, "Title 2", "Author 2", 0);
        Book book3 = new Book(0, "Title 3", "Author 1", 0);
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);

        // Test search with existing author
        List<Book> result1 = library.searchByAuthor("Author 1");
        assertEquals(2, result1.size());
        assertEquals(book1, result1.get(0));
        assertEquals(book3, result1.get(1));

        // Test search with non-existing author
        List<Book> result2 = library.searchByAuthor("Author 3");
        assertEquals(0, result2.size());
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
