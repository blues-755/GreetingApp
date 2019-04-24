package net.greet;

import java.util.Map;

public interface JDBC_Interface {
  String greetPerson(String name, String langType);
  Integer greetedName(String name);
  Map<String, Integer> greetedList();
  void clear();
  Integer clearName(String name);
  void exit();
}
