package edu.ithaca.barr;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    public boolean frozen;
    ArrayList<User> user = new ArrayList<>();


    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.user = new ArrayList<>();
        boolean frozen = false;
    }

    /**
     * Checks to see if an account is frozen
     * return: True if frozen, false if unfrozen
     */
    public boolean isFrozen(){
        return frozen;
    }
}
