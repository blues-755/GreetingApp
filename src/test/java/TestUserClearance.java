import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserClearance {

    GreetLogic clearLogi = new GreetLogic();

    @Test
    public void testUserClearance(){
        GreetLogic greetLogic = new GreetLogic();
        clearLogi.storeName("Lunga", "ISIXHOSA");
        clearLogi.storeName("Lunga", "ISIXHOSA");
        clearLogi.storeName("Ovayo", "ENGLISH");
        clearLogi.storeName("Thembela", "ISIZULU");
        greetLogic.clearName("Lunga");
        assertEquals(clearLogi.clearName("Lunga"), 2 + " cleared from system");
    }
//
    @Test
    public void testShouldRemoveAllUsers(){
        clearLogi.storeName("Ovayo", "ENGLISH");
        clearLogi.storeName("Lunga", "ISIXHOSA");
        clearLogi.storeName("Tshila", "ISIZULU");
        clearLogi.clear();
        assertEquals(clearLogi.counter(), 0);
    }
}
