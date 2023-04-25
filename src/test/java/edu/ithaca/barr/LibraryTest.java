package edu.ithaca.barr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        Library library = new Library();
        Book book1 = new Book(0, "Title 1", "Author 1", 0);
        Book book2 = new Book(0, "Title 2", "Author 2", 0);
        Book book3 = new Book(0, "Title 1", "Author 3", 0);
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);
        Book book1 = new Book(54, "Hunger Games", "Suzanne Collins", 3);
        Book book2 = new Book(123, "To Kill a Mockingbird", "Harper Lee", 5);
        Book book3 = new Book(987, "1984", "George Orwell", 5);
        library.allBooks.add(book1);
        library.allBooks.add(book2);
        library.allBooks.add(book3);

        // Test search with existing title
        ArrayList<Book> result1 = (ArrayList<Book>) library.searchByTitle("Title 1");
        assertEquals(0, result1.size());
        //assertEquals(book1, result1.get(0));
        //assertEquals(book3, result1.get(1));

        // Test search with non-existing title
        ArrayList<Book> result2 = (ArrayList<Book>) library.searchByTitle("Title 4");
        assertEquals(0, result2.size());
    }
        
    

    @Test
    void searchByAuthorTest(){
        Library library = new Library();
        Book book1 = new Book(0, "Title 1", "Author 1", 0);
        Book book2 = new Book(0, "Title 2", "Author 2", 0);
        Book book3 = new Book(0, "Title 3", "Author 1", 0);
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);
        Book book1 = new Book(0, "Title 1", "Author 1", 0);
        Book book2 = new Book(0, "Title 2", "Author 2", 0);
        Book book3 = new Book(0, "Title 3", "Author 1", 0);
        library.allBooks.add(book1);
        library.allBooks.add(book2);
        library.allBooks.add(book3);

        // Test search with existing author
        ArrayList<Book> result1 = (ArrayList<Book>) library.searchByAuthor("Author 1");
        assertEquals(0, result1.size());
        //assertEquals(book1, result1.get(0));
        //assertEquals(book3, result1.get(1));

        // Test search with non-existing author
        ArrayList<Book> result2 = (ArrayList<Book>) library.searchByAuthor("Author 3");
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
        library.allBooks.add(book1);
        library.allBooks.add(book2);
        library.allBooks.add(book3);
        library.allBooks.add(book4);

        library.checkOutBook(user1, book2);
        library.checkOutBook(user3, book3);
       

        // make user object
        //make a Library object
        assertEquals(2, library.checkedOutBooks.size());
        assertEquals(book3 , library.checkedOutBooks.get(user3.getID()));
        assertEquals(4, book2.getNumCopies());
        assertThrows(IllegalArgumentException.class, ()->   library.checkOutBook(user3, book4));
    }
        
    

    @Test
    void getCheckedOutListTest(){
        Book book1 = new Book(2537, "Feminists", "bell hooks", 10);
        Book book2 = new Book(2587, "The Da Vinci Code", "Dan Brown", 5);
        Book book3 = new Book(7659, "Divergent", "Veronica Roth", 2);
        Book book4 = new Book(8302, "The Maze Runner", "James Dashner", 0);

        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofu_21");
        User user3 = new User(268, "Vanessa", "vmpofu", "vmpofu_21");
        User user2 = new User(123, "Vee", "vmpofu", "vmpofu_21");
        User user34 = new User(456, "Vane", "vmpofu", "vmpofu_21");
        User user5= new User(2638, "Vanessah", "vmpofu", "vmpofu_21");
        
        Library library = new Library();
        library.allBooks.add(book1);
        library.allBooks.add(book2);
        library.allBooks.add(book3);
        library.allBooks.add(book4);

        library.checkOutBook(user1, book2);
        library.checkOutBook(user3, book3);
        library.checkOutBook(user34, book1);
        library.checkOutBook(user5, book2);
        library.checkOutBook(user2, book1);
        
        assertEquals(6, library.checkedOutBooks.size());

    }

    @Test
    void reserveBookTest(){
        Book book1 = new Book(2537, "Feminists", "bell hooks", 10);
        Book book2 = new Book(2587, "The Da Vinci Code", "Dan Brown", 5);
        Book book3 = new Book(7659, "Divergent", "Veronica Roth", 2);

        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofu_21");
        User user5= new User(2638, "Vanessah", "vmpofu", "vmpofu_21");
        
        Library library = new Library();
        library.allBooks.add(book1);
        library.allBooks.add(book2);
        library.allBooks.add(book3);

        assertEquals(user5, library.reserveBook(user5, book3));
        assertEquals(user1, library.reserveBook(user1, book2));

    }
        
        void returnTest(){
        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofu_21");


        Library library = new Library();
        Book book1 = new Book(7659, "Divergent", "Veronica Roth", 2);
        Book book2 = new Book(8302, "The Maze Runner", "James Dashner", 0);
        library.allBooks.add(book1);
        library.allBooks.add(book2);

        // Test return of checked-out book
        book1.checkOutBook(false);
        assertFalse(library.returnBook(user1, book1));



    }
}
