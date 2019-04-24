package net.greet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;

public class JDBC_Implementer implements JDBC_Interface {

  final String INSERT_USERNAME = "insert into Users (NAME, counter) values(?, ?)";

  final String FIND_USERNAME = "select counter from Users where NAME = ?";

  final String UPDATE_USERNAME = "update Users set counter = ? where NAME = ?";

  Connection connctn;
  PreparedStatement createNewUserName;
  PreparedStatement findUserCounter;
  PreparedStatement updateUserCounter;

  public JDBC_Implementer(){
    try {
      connctn = DriverManager.getConnection("jdbc:h2:./db/Users", "sa", "");

      createNewUserName = connctn.prepareStatement(INSERT_USERNAME);
      findUserCounter = connctn.prepareStatement(FIND_USERNAME);
      updateUserCounter = connctn.prepareStatement(UPDATE_USERNAME);

    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String greetPerson(String name, String langType) {
    return null;
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
