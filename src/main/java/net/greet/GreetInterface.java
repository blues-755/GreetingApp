package net.greet;
import java.sql.SQLException;
import java.util.Map;

public interface GreetInterface {

  String storeName(String name, String language) throws SQLException;

  Integer greetedName(String name) throws SQLException;

  int counter() throws SQLException;

  Integer counterName(String name) throws SQLException;

  Map<String, Integer> greetedList() throws SQLException;

  String clear() throws SQLException;

  String clearName(String name) throws SQLException;

  void exit() throws SQLException;
}
