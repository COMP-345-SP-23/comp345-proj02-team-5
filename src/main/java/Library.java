import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    public List<Book> bookList = new ArrayList<>();

    public Library(String name){
        this.name = name;
    }

    /**
     * Gets a list of books the library has
     * return: list of books at the library
     */
    public List<Book> getBookList(){
        return bookList;
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
    for(int i = 0; i < bookList.size(); i++){
        if(bookList.get(i) == book){
            bookList.remove(book);
        }
    }
    }
}
