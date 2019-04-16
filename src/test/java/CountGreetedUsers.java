import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGreetedUsers {

    @Test
    public void countGreetedUsers(){
        GreetLogic logic = new GreetLogic();
        logic.greetPerson("Lunga", "Mholo");
        logic.greetPerson("Lunga", "Mholo");
        logic.greetPerson("Thembela", "Hello");
        logic.greetPerson("Ovayo", "Sawubona");
        logic.counterAll();
        assertEquals(logic.greetedList(), logic.greetedList());
        System.out.println(logic.greetedList());
    }
    @Test
    public void testNoUsersGreeted(){
        GreetLogic noGreet = new GreetLogic();
        noGreet.greetedList();
        assertEquals(noGreet.greetedList(), noGreet.greetedList());
        System.out.println("Greeted Users: " + noGreet.counterAll());
        System.out.println(noGreet.greetedList());
    }

    @Test
    public void testCountForGreetedName(){
        GreetLogic greetLogic = new GreetLogic();
        greetLogic.greetPerson("Lunga", "Mholo");
        greetLogic.greetPerson("Lunga", "Hello");
        greetLogic.greetPerson("Thera", "Mholo");
        greetLogic.greetPerson("Ovayo", "Hello");
        assertEquals(greetLogic.counter("Ovayo"), 1);
        System.out.println(greetLogic.counter("Ovayo"));
    }
}
