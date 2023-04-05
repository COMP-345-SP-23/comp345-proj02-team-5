package edu.ithaca.barr;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    public boolean frozen;

    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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