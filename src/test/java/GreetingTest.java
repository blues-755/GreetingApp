import net.greet.GreetLogic;
import net.greet.Languages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {
    @Test
    public void testGreetingWithDefaultLanguage(){
        GreetLogic in = new GreetLogic();
        in.greetPerson("Lunga", null);
        assertEquals(Languages.valueOf("ISIXHOSA").getLang() + "Lunga", in.greetPerson("Lunga", null));

        assertEquals("Hello, Lunga", in.greetPerson("Lunga", "ENGLISH"));
        assertEquals("Mholo, Lunga", in.greetPerson("Lunga", "ISIXHOSA"));
        assertEquals("Mholo, Lunga", in.greetPerson("Lunga", "ZULU"));

        assertEquals(1, in.greetedList().size());
        in.greetPerson("Yan", "ISIZULU");
        assertEquals(2, in.greetedList().size());
    }
    @Test
    public void testIfICanGreetAUser(){
        GreetLogic in = new GreetLogic();
        in.greetPerson("Ovayo","ISIZULU");
        assertEquals(in.greetPerson("Ovayo", "Sawbona"),"Mholo, Ovayo");
    }
    @Test
    public void testGreeting() {
        GreetLogic gLogic = new GreetLogic();
        gLogic.greetPerson("Lunga", "ISIXHOSA");
        gLogic.greetPerson("Thembela", "ENGLISH");
        gLogic.greetPerson("Ovayo", "ISIZULU");
        assertEquals(gLogic.greetedList().size(), 3);
    }

    @Test
    public void testIfICanRemoveUsers() {
        GreetLogic gLogic = new GreetLogic();
        gLogic.greetPerson("Lunga", "ENGLISH");
        gLogic.greetPerson("Thembela", "ISIXHOSA");
        assertEquals(gLogic.clearName("Lunga"), 1);
    }
}