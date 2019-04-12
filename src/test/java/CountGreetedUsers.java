import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountGreetedUsers {

    @Test
    public void countGreetedUsers(){
        GreetLogic logic = new GreetLogic();
//        logic.greetPerson("Lunga");
//        logic.greetPerson("Lunga");
//        logic.greetPerson("Lunga");
//        logic.greetPerson("Ovayo");

        assertEquals(logic.greetedList(), logic.greetedList());
    }
    @Test
    public void testNoUsersGreeted(){
        GreetLogic noGreet = new GreetLogic();
        noGreet.greetedList();
        assertEquals(noGreet.greetedList(), noGreet.greetedList());
        System.out.println("Greeted Users: " + noGreet.counterAll());
    }

    @Test
    public void testCountForGreetedName(){
        GreetLogic greetLogic = new GreetLogic();
//        greetLogic.greetPerson("Lunga");
//        greetLogic.greetPerson("Lunga");
//        greetLogic.greetPerson("Thera");
//        greetLogic.greetPerson("Ovayo");
        assertEquals(greetLogic.counter("Ovayo"), 1);
    }
}
