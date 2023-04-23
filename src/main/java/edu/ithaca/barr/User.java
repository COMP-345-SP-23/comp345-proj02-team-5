package edu.ithaca.barr;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    public boolean frozen;
    ArrayList<User> userList = new ArrayList<>();


    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userList = new ArrayList<>();
        boolean frozen = false;
    }

    /**
     * Checks to see if an account is frozen
     * return: True if frozen, false if unfrozen
     */
    public boolean isFrozen(){
        return frozen;
    }
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
    public void setUsername(String newUsername){
        this.username = newUsername;
    }
    
    public String changePassword(User user, String newPassword, String oldPassword){
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            if(user.getPassword().equals(newPassword)){
                System.out.println("password changed");
                return newPassword;
            }
    
            else{
                System.out.println("password change failed!!");
            }
        }
    
       
        System.out.println("Old password is wrong!!");
        String password = user.getPassword();
        return password;
       
    }
    
    public String changeUsername(User user, String newUsername, String oldUsername){
        if(user.getUserName() == oldUsername){
            setUsername(newUsername);
            if(user.getPassword() == newUsername){
                System.out.println("username changed");
                return newUsername;
            }
    
            else{
                System.out.println("username change failed!!");
            }
        }
    
        
        System.out.println("Old username is wrong!!");
        String username = user.getUserName();
        return username;        
    }
}
