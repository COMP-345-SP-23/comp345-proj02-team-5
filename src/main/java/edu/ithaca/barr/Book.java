package edu.ithaca.barr;

public class Book {
    
    private int id;
    private String title;
    private String author;
    public int numCopies;
    public int durationRentalDays = 21;

    public Book(int id, String title, String author, int numCopies){
        this.id=id;
        this.title=title;
        this.author=author;
        this.numCopies=numCopies;
    }

    public int getNumCopies(){
        return numCopies;
    }

    public int getID(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

   
    public String returnInfo(){
        return "ID: "+id+", Title: "+title+", Author: "+author+", Number of Copies: "+numCopies;
    }

    public int setNumCopies(Book book){
        int currNumCopies = book.getNumCopies() - 1;
        numCopies = currNumCopies;
        return currNumCopies;
    }

    
    public void checkOutBook(boolean b) {
    }


}
