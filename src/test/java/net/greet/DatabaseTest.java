package net.greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

  GreetInterface greetInterface = mock(GreetInterface.class);

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
    builder.storeName("Blue", "ISIXHOSA");
    builder.storeName("Aya", "ISIXHOSA");
    assertEquals(builder.greetedList().size(), 2);
  }
  @Test
  public void testCounterForNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Lunga", "ENGLISH");
    assertEquals(builder.counterName("Lunga"), 1);
  }
  @Test
  public void testCounterDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");
    assertEquals(builder.counter(), 5);

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
    builder.storeName("Nelly", "ISIZULU");
    assertEquals(builder.clearName("Nelly"), "Nelly cleared from system");
  }

  @Test
  public void testClearAllUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.storeName("thabang", "ENGLISH");
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
}
