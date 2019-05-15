package net.greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
  DatabaseBuilder builder = new DatabaseBuilder();

  final String db_url = "jdbc:h2:file:./target/my_db";
  final String username = "sa";
  final String password = "";

  public Connection getConn() throws SQLException {
    return DriverManager.getConnection(db_url, username, password);
  }
@BeforeEach
  public void eraseDB(){
    try {
      Connection conn = getConn();
      Statement smt = conn.createStatement();
      smt.addBatch("truncate table table_");
      smt.executeBatch();
    }catch (SQLException E){
      System.out.println("ERROR" + E);
    }
  }
  @Test
  public void testGreetingDB() {
    assertEquals(builder.storeName("Lunga", "ISIXHOSA"), "MHOLO  Lunga");
  }
  @Test
  public void testGreetedUsersInDB(){
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");

    assertEquals(builder.greetedList().size(), 3);

  }
  @Test
  public void testClearAllUsersInDB(){
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
  @Test
  public void testClearName(){
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");
    builder.clearName("Lunga");
    assertEquals(builder.greetedList().size(), 2);
  }
  @Test
  public void testCounterDB(){
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");
    builder.storeName("Nelly", "ISIXHOSA");

    assertEquals(builder.counter(), 4);

  }
  @Test
  public void testCounterForNameDB(){
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");

    assertEquals(builder.counterName("Thembela"), 1);
  }
  @Test
  public void testGreetedNameDB(){

    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Lunga", "ISIXHOSA");
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");

   assertEquals(builder.greetedName("Thembela"), 1);
  }
}
