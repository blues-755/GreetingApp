import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGreetedUsers {

    @Test
    public void countGreetedUsers(){
        GreetLogic logic = new GreetLogic();
        logic.greetPerson("Lunga", "ISIXHOSA");
        logic.greetPerson("Lunga", "ENGLISH");
        logic.greetPerson("Thembela", "ISIZULU");
        logic.greetPerson("Ovayo", "ISIXHOSA");
        logic.counterAll();
        assertEquals(logic.counterAll(), 3);
    }
    @Test
    public void testNoUsersGreeted(){
        GreetLogic noGreet = new GreetLogic();
        assertEquals(noGreet.greetedList().size(), 0);

    }

    @Test
    public void testCountForGreetedName(){
        GreetLogic greetLogic = new GreetLogic();
        greetLogic.greetPerson("Lunga", "ISIXHOSA");
        greetLogic.greetPerson("Lunga", "ENGLISH");
        greetLogic.greetPerson("Thera", "ISIZULU");
        greetLogic.greetPerson("Ovayo", "ENGLISH");
        assertEquals(greetLogic.counter("Ovayo"), 1);
    }
}
