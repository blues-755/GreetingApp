import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserClearance {

    GreetLogic clearLogi = new GreetLogic();

    @Test
    public void testUserClearance(){
        GreetLogic cG = new GreetLogic();
        clearLogi.greetPerson("Lunga", "ISIXHOSA");
        clearLogi.greetPerson("Lunga", "ISIXHOSA");
        clearLogi.greetPerson("Ovayo", "ENGLISH");
        clearLogi.greetPerson("Thembela", "ISIZULU");
        cG.clearName("Lunga");
        assertEquals(clearLogi.clearName("Lunga"), 2);
    }
//
    @Test
    public void testShouldRemoveAllUsers(){
        clearLogi.greetPerson("Ovayo", "ENGLISH");
        clearLogi.greetPerson("Lunga", "ISIXHOSA");
        clearLogi.greetPerson("Tshila", "ISIZULU");
        clearLogi.clear();
        assertEquals(clearLogi.counterAll(), 0);
    }
}
