
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.ithaca.barr.User;

public class UserTest {

    @Test
    void changePasswordUsernameTest(){
        //create a bunch of user objects
        User user1 = new User(237, "Vanessa", "vmpofu", "vmpofU_21");
        User user3 = new User(268, "Vicky ", "Conrad", "Vconrad/25");
        User user2 = new User(123, "Cody", "Carnes", "Ccordy74");

        assertEquals("Vanessa99", user1.changePassword(user1, "Vanessa99", "vmpofU_21"));
        assertEquals("VictoriaConrad", user3.changeUsername(user3, "VictoriaConrad", "Conrad"));
        assertEquals("Ccordy74", user2.changePassword(user2, "Cordy2022", "CCarnes74"));
        assertEquals("vmpofu", user1.changeUsername(user1, "VanessaMpofu", "VMpofu"));

    }

}
