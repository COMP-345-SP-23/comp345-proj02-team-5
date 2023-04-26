package edu.ithaca.barr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {
    @Test
    public void passTimeTest(){
        Library barr = new Library();   //Make library
        Book book1 = new Book(1, "Book1", "Author1", 2, "unreserved");  //Make book
        Book book2 = new Book(2, "Book2", "Author1", 1, "unreserved");  //Make book
        Book book3 = new Book(3, "Book3", "Author2", 3, "unreserved");  //Make book

        barr.allBooks.add(book1);   //Add book
        barr.allBooks.add(book2);   //Add book
        barr.allBooks.add(book3);   //Add book

        User user1 = new User(1,"John", "jbarr", "barrj");  //Create user
        User user2 = new User(2,"Barr", "barro", "obarr");  //Create user

        barr.checkOutBook(user1, book1);    //User checks out a book
        Time t1 = new Time(user1, book1);

        assertEquals(7, t1.days_left);    //Test that a newly checked out book has 7 days left

        t1.passTime();    //A day passes
        assertEquals(6, t1.days_left);    //Test that after a day, the book has 6 days left

        t1.passTime();    //A day passes
        assertEquals(5, t1.days_left);    //Test that after another day, the book has 5 days left

        barr.checkOutBook(user2, book2);   //A different user checks out a book
        Time t2 = new Time(user2, book2);
        barr.checkOutBook(user2, book1);    //A user who has checked out a book before checks out another
        Time t3 = new Time(user2, book1);
        assertEquals(7, t2.days_left);    //Newly checked out book has 7 days left
        assertEquals(7, t3.days_left);    //Newly checked out book has 7 days left


        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(4, t1.days_left);    //Tests that after a day a book checked out a bit ago is at its correct time for days left
        assertEquals(6, t2.days_left);    //Tests that after a day, newly checked out book has 6 days left
        assertEquals(6, t3.days_left);    //Tests that after a day, newly checked out book has 6 days left

        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(3, t1.days_left);    //Test time decreases after a day
        assertEquals(5, t2.days_left);    //Test time decreases after a day
        assertEquals(5, t3.days_left);    //Test time decreases after a day

        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(2, t1.days_left);    //Test time decreases after a day
        assertEquals(4, t2.days_left);    //Test time decreases after a day
        assertEquals(4, t3.days_left);    //Test time decreases after a day

        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(1, t1.days_left);    //Test time decreases after a day
        assertEquals(3, t2.days_left);    //Test time decreases after a day
        assertEquals(3, t3.days_left);    //Test time decreases after a day

        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(0, t1.days_left);    //Test time decreases after a day
        assertEquals(2, t2.days_left);    //Test time decreases after a day
        assertEquals(2, t3.days_left);    //Test time decreases after a day

        t1.passTime();    //A day passes
        t2.passTime();    //A day passes
        t3.passTime();    //A day passes
        assertEquals(-1, t1.days_left);   //Test that when a book is overdue, time is the negative amount of days overdue
        assertEquals(1, t2.days_left);    //Test time decreases after a day
        assertEquals(1, t3.days_left);    //Test time decreases after a day
    }
}
