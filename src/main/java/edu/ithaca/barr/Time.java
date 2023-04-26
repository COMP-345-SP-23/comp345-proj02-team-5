package edu.ithaca.barr;

public class Time {

    private User user;
    private Book book;
    public int days_left;


    public Time (User user, Book book){
        this.user = user;
        this.book = book;
        days_left = 7;
    }

    /**
     * A day passes so the time for all books currently checked out decreases by 1
     */
    public void passTime(){
        days_left--;
        if(days_left < 0){
            System.out.println(book.getTitle() + " is " + (-1 * days_left) + " day overdue. Please go in person to the library to pay your fine of $" + (-0.1 * days_left));
        }
    }
}
