import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserClearance {

    GreetLogic clearLogi = new GreetLogic();

    @Test
    public void testUserClearance(){
//        clearLogi.greetPerson("Lunga");
//        clearLogi.greetPerson("Ovayo");
//        clearLogi.greetPerson("Thembela");
        assertEquals(clearLogi.clearName("Lunga"), 1);

    }

    @Test
    public void testShouldRemoveAll(){
//        clearLogi.greetPerson("Ovayo");
//        clearLogi.greetPerson("Lunga");
//        clearLogi.greetPerson("Tshila");
//        clearLogi.clear();
//        assertEquals(clearLogi.counterAll(), 0);
    }
}
