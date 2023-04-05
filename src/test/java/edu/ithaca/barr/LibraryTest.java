package edu.ithaca.barr;

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
    void checkOutBookTest(){
        
    }

    @Test
    void returnTest(){
        
    }
}
