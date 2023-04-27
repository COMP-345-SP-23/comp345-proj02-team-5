package edu.ithaca.barr;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    
    private int id;
    private String title;
    private String author;
    public int numCopies;

    @JsonCreator
    public Book(@JsonProperty("id") int id, @JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("numCopies") int numCopies) {
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
