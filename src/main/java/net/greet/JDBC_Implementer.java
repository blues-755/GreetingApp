package net.greet;
import java.sql.*;
import java.util.Map;

public class JDBC_Implementer implements JDBC_Interface {

  final String INSERT_USERNAME = "INSERT INTO userTable (NAME, counter) VALUES(?, ?)";

  final String FIND_USERNAME = "SELECT counter FROM userTable WHERE NAME = ?";

  final String UPDATE_USERNAME = "UPDATE userTable SET counter = ? WHERE NAME = ?";

  Connection connctn;
  PreparedStatement createNewUserName;
  PreparedStatement findUserCounter;
  PreparedStatement updateUserCounter;

  public JDBC_Implementer() {
    try {

      Class.forName("org.h2.Driver");
      final String JDBC_URL = "jdbc:h2:file:./target/GreetingApp";
      connctn = DriverManager.getConnection(JDBC_URL, "sa", "");

      createNewUserName = connctn.prepareStatement(INSERT_USERNAME);
      findUserCounter = connctn.prepareStatement(FIND_USERNAME);
      updateUserCounter = connctn.prepareStatement(UPDATE_USERNAME);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String greetPerson(String name, String langType) {

    try {
      findUserCounter.setString(1, name);
      ResultSet rsUserCount = findUserCounter.executeQuery();

      if (!rsUserCount.next()){
        createNewUserName.setString(1, name);
        createNewUserName.setInt(2,1);
        System.out.println(createNewUserName.execute());
      }else {
        int user_counter = rsUserCount.getInt("counter");
        updateUserCounter.setInt(1, ++user_counter);
        updateUserCounter.setString(2, name);
        updateUserCounter.execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return "??";
  }

  @Override
  public Integer greetedName(String name) {
    return null;
  }

  @Override
  public Map<String, Integer> greetedList() {
    return null;
  }

  @Override
  public void clear() {

  }

  @Override
  public Integer clearName(String name) {
    return null;
  }

  @Override
  public void exit() {

  }
}
