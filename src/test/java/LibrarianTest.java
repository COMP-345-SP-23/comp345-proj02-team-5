import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class LibrarianTest {

    @Test
    void addBookTest(){
        Library barrLib = new Library("Barr");
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");
        Book book3 = new Book("Book3");


        // assertEquals(bookList, barrLib.getBookList());  //Test list is empty
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is empty
        bookList.add(book1);
        barrLibrarian.addBook(book1);
        // assertEquals(bookList, barrLib.getBookList());  //Test new book added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book2);
        barrLibrarian.addBook(book2);
        // assertEquals(bookList, barrLib.getBookList());  //Test new book added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test new book added
        bookList.add(book3);
        barrLibrarian.addBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //Test another copy of a book is added
        assertEquals(bookList, barrLibrarian.getBookList());  //Test another copy of a book is added

    }

    @Test
    void removeBookTest(){
        Library barrLib = new Library("Barr");
        Librarian barrLibrarian = new Librarian(12345);
        ArrayList<Book> bookList = new ArrayList<>();

        Book book1 = new Book("Book1");
        Book book2 = new Book("Book2");
        Book book3 = new Book("Book3");

        barrLibrarian.addBook(book1);
        barrLibrarian.addBook(book2);
        bookList.add(book1);
        bookList.add(book2);

        // assertEquals(bookList, barrLib.getBookList());  //Test list is not empty
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list is not empty
        bookList.remove(book2);
        barrLibrarian.removeBook(book2);
        // assertEquals(bookList, barrLib.getBookList());  //Test list removes the specified book
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //Test nothing happens when book that is not at library is removed
        assertEquals(bookList, barrLibrarian.getBookList());  //Test nothing happens when book that is not at library is removed
        bookList.remove(book1);
        barrLibrarian.removeBook(book1);
        // assertEquals(bookList, barrLib.getBookList());  //Test list removes the specified book
        assertEquals(bookList, barrLibrarian.getBookList());  //Test list removes the specified book
        bookList.remove(book3);
        barrLibrarian.removeBook(book3);
        // assertEquals(bookList, barrLib.getBookList());  //list remains empty when trying to remove a book from empty list
        assertEquals(bookList, barrLibrarian.getBookList());  //list remains empty when trying to remove a book from empty list


    }

    @Test
    void freezeAccountTest(){

    }

    @Test
    void unfreezeAccountTest(){

    }

    @Test
    void removeAccountTest(){

    }

//    @Test
//    void getCheckedOutListTest(){
//      This is for library now
//    }

}
