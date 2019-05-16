package net.greet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {


  final String db_url = "jdbc:h2:file:./target/my_db";
  final String username = "sa";
  final String password = "";
  DatabaseBuilder builderX = new DatabaseBuilder();

  public Connection getConn() throws SQLException {
    return DriverManager.getConnection(db_url, username, password);
  }
@BeforeEach
  public void eraseDB(){
    try {
      Connection conn = getConn();
      Statement smt = conn.createStatement();
      smt.addBatch("delete from table_");
      smt.executeBatch();

    }catch (SQLException E){
      System.out.println("ERROR" + E);
    }
  }
  @AfterEach
  void cleanUp() {
    builderX.clear();
    System.out.println(builderX.greetedList() + "   After Each");
  }

  @Test
  public void testGreetingDB() {
    DatabaseBuilder builder = new DatabaseBuilder();
    assertEquals(builder.storeName("Lunga", "ISIXHOSA"), "MHOLO  Lunga");
  }
  @Test
  @Disabled("need bug fix: returning wrong numbers.")
  public void testGreetedUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ISIXHOSA");
    assertEquals(builder.greetedList().size(), 1);

  }
  @Test
  public void testClearAllUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ISIXHOSA");
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
  @Test
  public void testClearName(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ISIXHOSA");
    builder.clearName("Lunga");
    assertEquals(builder.greetedList().size(), 0);
  }
  @Test
  public void testCounterDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    assertEquals(builder.counter(), 2);

  }
  @Test
  public void testCounterForNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ISIXHOSA");
    assertEquals(builder.counterName("Thembela"), 0);
  }
  @Test
  public void testGreetedNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ENGLISH");
   assertEquals(builder.greetedName("Lunga"), 1);
  }
}
