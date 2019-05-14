package net.greet;

import net.greet.GreetLogic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {
    @Test
    public void testGreetingWithDefaultLanguage(){
       GreetLogic greetLogic = new GreetLogic();
       assertEquals(greetLogic.storeName("Lunga", "ISIXHOSA"), "MHOLO  Lunga");

    }
    @Test
    public void testIfICanGreetAUser(){
        GreetLogic in = new GreetLogic();
        assertEquals("MHOLO  Ovayo", in.storeName("Ovayo","ISIXHOSA"));
    }
    @Test
    public void testGreetedList() {
        GreetLogic greeter = new GreetLogic();
        greeter.storeName("Ntando", "ISIZULU");
        greeter.storeName("Ndiras", "ENGLISH");
        greeter.storeName("Lunga", "ISIXHOSA");
        assertEquals(greeter.greetedList().size(), 3);
    }

    @Test
    public  void ShouldBeAbleToGreetWithIsiZulu(){
        GreetLogic greetLogic = new GreetLogic();
        assertEquals("SAWUBONA  anele", greetLogic.storeName("anele", "ISIZULU"));
    }
    @Test
    public  void ShouldBeAbleToGreetWithIsiXhosa(){
        GreetLogic greetLogic = new GreetLogic();
        assertEquals("MHOLO  anele", greetLogic.storeName("anele", "ISIXHOSA"));
    }
    @Test
    public  void ShouldBeAbleToGreetWithEnglish(){
        GreetLogic greetLogic = new GreetLogic();
        assertEquals("HELLO  anele", greetLogic.storeName("anele", "ENGLISH"));
    }

    @Test
    public void testIfICanRemoveUsers() {
        GreetLogic greetLogic = new GreetLogic();
        greetLogic.storeName("Lunga", "ENGLISH");
        greetLogic.storeName("Thembela", "ISIXHOSA");
        assertEquals(greetLogic.clearName("Lunga"), "Lunga" + " cleared from system");
    }

}