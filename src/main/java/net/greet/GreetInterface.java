package net.greet;
import java.sql.SQLException;
import java.util.Map;

public interface GreetInterface {

  String storeName(String name, String language) throws SQLException;

  Integer greetedName(String name);

  int counter();

  Integer counterName(String name);

  Map<String, Integer> greetedList();

  String clear();

  String clearName(String name) throws SQLException;

  void exit();
}
