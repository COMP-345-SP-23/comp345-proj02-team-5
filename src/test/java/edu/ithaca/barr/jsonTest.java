package edu.ithaca.barr;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class jsonTest {


    @Test
    public void jTest() throws IOException {
        Book book =new Book(0, "A", "B", 0);
        JsonUtil.toJsonFile("src/test/java/edu/ithaca/barr/book.json", book);

        Book jb = JsonUtil.fromJsonFile("src/test/java/edu/ithaca/barr/book.json", Book.class);
        assertEquals(book.getID(), jb.getID());
        assertEquals(book.getTitle(), jb.getTitle());
        assertEquals(book.getAuthor(), jb.getAuthor());
        assertEquals(book.getNumCopies(), jb.getNumCopies());

    }

    @Test
    public void jbksTest() throws IOException {
        List<Book> books = Arrays.asList(
            new Book(0, "A", "B", 0),
            new Book(1, "C", "D", 1),
            new Book(3, "E", "F", 5)
        );
        JsonUtil.toJsonFile("src/test/java/edu/ithaca/barr/booksjtest.json", books);

        List<Book> jbs = JsonUtil.listFromJsonFile("src/test/java/edu/ithaca/barr/booksjtest.json", Book.class);
        assertEquals(3, jbs.size());
        assertEquals("E", jbs.get(2).getTitle());
        assertEquals("B", jbs.get(0).getAuthor());
        assertEquals(1, jbs.get(1).getNumCopies());

    }

}
