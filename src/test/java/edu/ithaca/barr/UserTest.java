package edu.ithaca.barr;

import edu.ithaca.barr.Librarian;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void getUserListTest(){
        ArrayList<User> userList = new ArrayList<>();

        User test = new User(1, "John", "abc", "123"); //Tests when there is a single user
        userList.add(test);
        assertEquals(userList, test.getUserList());

        User test2 = new User(2, "Barr", "def", "456"); //Tests when there are two users
        userList.add(test2);
        assertEquals(userList, test2.getUserList());

        User test3 = new User(3, "jBarr", "ghi", "789"); //Test when there are three user
        userList.add(test3);
        assertEquals(userList, test3.getUserList());

    }
}
