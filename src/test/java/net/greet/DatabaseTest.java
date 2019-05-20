package net.greet;
import org.junit.jupiter.api.BeforeEach;
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

  public Connection getConn() throws SQLException {
    return DriverManager.getConnection(db_url, username, password);
  }
@BeforeEach
  public void eraseDB(){
    try {
      Connection conn = getConn();
      Statement connStatement = conn.createStatement();
      connStatement.addBatch("delete from table_");
      connStatement.executeBatch();
    }catch (SQLException E){
      System.out.println("ERROR" + E);
    }
  }

  @Test
  public void testGreetingDB() {
    DatabaseBuilder builder = new DatabaseBuilder();
    assertEquals(builder.storeName("Lunga", "ISIXHOSA"), "MHOLO  Lunga");
    assertEquals(builder.storeName("Aya", "ISIXHOSA"), "MHOLO  Aya");
    System.out.println(builder.greetedList());
  }
  @Test
  public void testCounterForNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    assertEquals(builder.counterName("Lunga"), builder.greetedName("Lunga"));
  }
  @Test
  public void testCounterDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    assertEquals(builder.counter(), 0);

  }

  @Test
  public void testGreetedNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Ntando", "ISIXHOSA");
   assertEquals(builder.greetedName("Ntando"), 1);
  }

  @Test
  public void testClearName(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clearName("Nelly");
    assertEquals(builder.greetedList().size(), 0);
  }

  @Test
  public void testClearAllUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
}
