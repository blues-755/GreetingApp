import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserClearance {

    GreetLogic clearLogi = new GreetLogic();

    @Test
    public void testUserClearance(){
        clearLogi.greetPerson("Lunga", "Mholo");
        clearLogi.greetPerson("Ovayo", "Hello");
        clearLogi.greetPerson("Thembela", "Hello");
        assertEquals(clearLogi.clearName("Lunga"), 1);

    }

    @Test
    public void testShouldRemoveAll(){
        clearLogi.greetPerson("Ovayo", "Hello");
        clearLogi.greetPerson("Lunga", "Mholo");
        clearLogi.greetPerson("Tshila", "Mholo");
        clearLogi.clear();
        assertEquals(clearLogi.counterAll(), 0);
    }
}
