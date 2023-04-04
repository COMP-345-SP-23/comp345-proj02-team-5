import java.util.ArrayList;
import java.util.List;

public class Librarian {

    private int id;
    private String title;
    private ArrayList<Book> bookList = new ArrayList<>();

    public Librarian(int id){
        this.id = id;
    }


    /**
     * Adds a book to the list of books at the library, or increases the number of copies
     * if the book is already at the library
     */
    public void addBook(Book book){
//      used on type library
        int i;
        boolean there = false;
        for(i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                book.copies++;
                there = true;
            }
        }
        //make sure if not
        if(!there){
            bookList.add(book);
        }
    }

    /**
     * Decreases the count of a book at the library
     */
    public void removeBook(Book book){
//      used on type library
//        int i;
//        boolean there = false;
//        for(i = 0; i < bookList.size(); i++){
//            if(bookList.get(i) == book){
//                book.copies--;
//                there = true;
//            }
//        }
//        if(book.copies == 0){
//            bookList.remove(book);
//        }
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                bookList.remove(book);
            }
        }

        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i) == book){
                if(bookList.get(i).copies > 0){
                    book.copies--;
                }
                bookList.remove(book);
            }
        }
    }

    /**
     * Freezes an account
     * return: True if successful, false if unsuccessful
     */
//    public boolean freezeAccount(){
//      used on type user? or library?
//    }

    /**
     * Unfreezes an account
     * return: True if successful, false if unsuccessful
     */
//    public boolean unfreezeAccount(){
//      used on type user? or library?
//    }

    /**
     * Removes an account from the system
     * return: True if successful, false if unsuccessful
     */
//    public boolean removeAccount(){
//      used on type user
//    }

    /**
     * Gets a list of books currently checked out
     * return: list of books checked out
     */
//    public List<Book> getCheckedOutList(){
//      used on type library
//    }

    /**
     * Gets a list of books the library has
     * return: list of books at the library
     */
//    public List<Book> getBookList(){
//        used on type library
//    }

  /**
     * Gets a list of books the library has
     * return: list of books at the library
     */
    public List<Book> getBookList(){
        return bookList;
    }
}
