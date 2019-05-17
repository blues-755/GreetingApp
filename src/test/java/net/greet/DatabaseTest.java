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
      Statement smt = conn.createStatement();
      smt.addBatch("delete from table_");
      smt.executeBatch();

    }catch (SQLException E){
      System.out.println("ERROR" + E);
    }
  }

  @Test
  public void testGreetingDB() {
    DatabaseBuilder builder = new DatabaseBuilder();
    assertEquals(builder.storeName("Lunga", "ISIXHOSA"), "MHOLO  Lunga");
  }
  @Test
  public void testClearAllUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Thembela", "ISIXHOSA");
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
  @Test
  public void testClearName(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Nelly", "ISIXHOSA");
    builder.clearName("Nelly");
    assertEquals(builder.greetedList().size(), 0);
  }
  @Test
  public void testCounterDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Mla", "ISIXHOSA");
    builder.storeName("Banks", "ENGLISH");
    assertEquals(builder.counter(), 2);

  }
  @Test
  public void testCounterForNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Saider", "ISIXHOSA");
    builder.storeName("Inga",  "ISIXHOSA");
    assertEquals(builder.counterName("Inga"), 1);
  }

  @Test
  public void testGreetedNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Ntando", "ENGLISH");
   assertEquals(builder.greetedName("Ntanda"), null);
  }
}
