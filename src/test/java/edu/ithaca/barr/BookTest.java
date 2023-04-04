package edu.ithaca.barr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {
    
    @Test
    void returnInfoTest(){
        Book book =new Book(0, "A", "B", 0);
        Book book2 =new Book(1, "C", "D", 1);
        Book book3 =new Book(3, "E", "F", 5);
        assertEquals("ID: 0, Title: A, Author: B, Number of Copies: 0", book.returnInfo());
        assertEquals("ID: 1, Title: C, Author: D, Number of Copies: 1", book2.returnInfo());
        assertEquals("ID: 3, Title: E, Author: F, Number of Copies: 5", book3.returnInfo());
        //book.checkout
        //assertEquals("ID: 3, Title: E, Author: F, Number of Copies: 4", book.returnInfo());
    }
}
