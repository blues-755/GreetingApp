package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {

  @Test
  public void shouldTestExecuteMethod() throws SQLException {
    CommandProcessor cmd = new CommandProcessor(new GreetLogic());

    assertEquals(cmd.execute("greet Thabang"), "MHOLO  Thabang");

    assertEquals(cmd.execute("greeted"), "{Thabang=1}");
    assertEquals(cmd.execute("greeted Thabang"), "Thabang greeted 1 times(s)");
    assertEquals(cmd.execute("clear Thabang"), "Thabang cleared from system");
  }

  @Test
  public void shouldTestGreetingInEnglish(){
    CommandProcessor cmd = new CommandProcessor(new GreetLogic());
    try {
      assertEquals(cmd.execute("greet Thabang ENGLISH"), "HELLO  Thabang");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Test
  public void shouldTestGreetingWithIsiXhosa(){
    CommandProcessor cmd = new CommandProcessor(new GreetLogic());
    try {
      assertEquals(cmd.execute("greet Thabang ISIXHOSA"), "MHOLO  Thabang");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void shouldTestGreetingWithIsiZulu(){
    CommandProcessor cmd = new CommandProcessor(new GreetLogic());
    try {
      assertEquals(cmd.execute("greet Thabang ISIZULU"), "SAWUBONA  Thabang");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
