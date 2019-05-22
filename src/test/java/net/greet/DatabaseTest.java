package net.greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

  final String db_url = "jdbc:h2:file:./target/my_db";
  final String username = "sa";
  final String password = "";
  DatabaseBuilder builder = new DatabaseBuilder();

  public Connection getConn() throws SQLException {
    return DriverManager.getConnection(db_url, username, password);
  }

  @BeforeEach
  public void eraseDB() {
    builder.clear();
  }

  @Test
  public void testGreetingDB() {
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("Blue", "ISIXHOSA");
    builder.storeName("Aya", "ISIXHOSA");
    assertEquals(builder.greetedList().size(), 2);
  }

  @Test
  public void testCounterForNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("Lunga", "ENGLISH");
    assertEquals(builder.counterName("Lunga"), 1);
  }

  @Test
  public void testCounterDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("Ovayo", "ENGLISH");
    builder.storeName("Thembela", "ISIZULU");
    assertEquals(builder.counter(), 2);
  }

  @Test
  public void testGreetedNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("Ntando", "ISIXHOSA");
   assertEquals(builder.greetedName("Ntando"), 1);
  }
  @Test
  public void testClearNameDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("Nelly", "ISIZULU");
    assertEquals(builder.clearName("Nelly"), "Nelly cleared from system");
  }

  @Test
  public void testClearAllUsersInDB(){
    DatabaseBuilder builder = new DatabaseBuilder();
    builder.clear();
    builder.storeName("thabang", "ENGLISH");
    builder.clear();
    assertEquals(builder.counter(), 0);
  }
}
