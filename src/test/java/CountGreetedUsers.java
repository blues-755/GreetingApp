import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGreetedUsers {

    @Test
    public void countGreetedUsers(){
        GreetLogic logic = new GreetLogic();
        logic.storeName("Lunga", "ISIXHOSA");
        logic.storeName("Lunga", "ENGLISH");
        logic.storeName("Thembela", "ISIZULU");
        logic.storeName("Ovayo", "ISIXHOSA");
        logic.counter();
        assertEquals(logic.counter(), 3);
    }
    @Test
    public void testNoUsersGreeted(){
        GreetLogic noGreet = new GreetLogic();
        assertEquals(noGreet.greetedList().size(), 0);

    }

    @Test
    public void testCountForGreetedName(){
        GreetLogic greetLogic = new GreetLogic();
        greetLogic.storeName("Lunga", "ISIXHOSA");
        greetLogic.storeName("Lunga", "ENGLISH");
        greetLogic.storeName("Thera", "ISIZULU");
        greetLogic.storeName("Ovayo", "ENGLISH");
        assertEquals(greetLogic.counterName("Lunga"), 2);
    }
}
