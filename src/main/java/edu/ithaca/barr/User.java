package edu.ithaca.barr;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    public boolean frozen;
    public List<Book> checkedOutList = new ArrayList<>();
    public List<Book> reservedList = new ArrayList<>();


    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        boolean frozen = false;
        // Library.userList.add(this);
        Library.userList.add(this);
        Library.usernameList.add(username);
        Library.passwordList.add(password);
    }

    /**
     * Checks to see if an account is frozen
     * return: True if frozen, false if unfrozen
     */
    public boolean isFrozen(){
        return frozen;
    }

    /**
     * gets the id
     * @return id of the user
     */
    public int getID(){
        return id;
    }

    /**
     * gets the name
     * @return name of the user
     */
    public String getName(){
        return name;
    }

    /**
     * gets the username
     * @return username of the user
     */
    public String getUserName(){
        return username;
    }

    /**
     * gets the password
     * @return password of the user
     */
    public String getPassword(){
        return password;
    }

    /**
     * gets User's list of checked out books
     * @return list of checked out books
     */
    public List<Book> getCheckedOutList(){
        return checkedOutList;
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
        if(user.getUserName().equals(oldUsername)){
            setUsername(newUsername);
            if(user.getPassword().equals(newUsername)){
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

    /**
     * gets User's list of reserved books
     * @return list of reserved books
     */
    public List<Book> getReservedList(){
        return reservedList;
    }


}


