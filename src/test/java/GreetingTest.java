import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {
    @Test
    public void testGreetingWithDefaultLanguage(){
        GreetLogic in = new GreetLogic();


        assertEquals(in.greetPerson("Lunga", null), "Mholo Lunga");
        assertEquals(in.greetPerson("Lunga", "english"), "Mholo Lunga");
    }

    @Test
    public void testIfICanGreetAUser(){

    }

    @Test
    public void testGreeting() {
        GreetLogic gLogic = new GreetLogic();
        gLogic.greetPerson("Lunga", "Mholo");
        gLogic.greetPerson("Lunga", "Hello");
        gLogic.greetPerson("Lunga", "Sawbona");
        gLogic.greetPerson("Lunga", "Hello");
        gLogic.greetPerson("Tshila", "Hello");

        assertEquals(gLogic.greetedList(), gLogic.greetedList());
    }

    @Test
    public void testIfICanRemoveUsers() {
        GreetLogic gLogic = new GreetLogic();
        gLogic.greetPerson("Lunga", "Hello");
        gLogic.greetPerson("Lunga", "Sawbona");
        assertEquals(gLogic.clearName("Lunga"), 2);
    }
}