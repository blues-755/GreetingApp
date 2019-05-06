package net.greet;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

public class GreetLogic implements GreetInterface {

  Map<String, Integer> usernameMap = new HashMap<>();

  public void help(){
    System.out.println("list of commands you need to follow when using greeting app:\n"+
          "'greet' followed by the name and language greets the user based on a chosen language.\n" +
          "'greeted' shows you a list of greeted users, \n" +
          "'greeted' " + "followed by the user name shows you how many times that user had been greeted'\n"+
          "'help' shows you a list of commands\n"+
          "'exit' exits the application\n" +
          "'clear' deletes all users in the system\n" +
          "'clear' followed by the username removes the specified name from the system\n" +
          "'counter' displays the unique number of users in the system\n");
  }

  @Override
  public String storeName(String name, String language) {

    if(usernameMap.containsKey(name)) {
      usernameMap.put(name, usernameMap.get(name) + 1);
    }
    else {
      usernameMap.put(name, 1);
    }
   switch (Languages.valueOf(language)){
     case ISIXHOSA:
     case ENGLISH:
     case ISIZULU:
       return Languages.valueOf(language).getLang().toUpperCase() + " " + name;
      }
    return usernameMap.get(name) + " " + language;
  }

  public Integer greetedName(String name){
    if(!usernameMap.containsKey(name)){
      return 0;
    }
    return usernameMap.get(name);
  }

  public Map<String, Integer> greetedList(){
    return usernameMap;
  }

  public String clear(){
    usernameMap.clear();
    return "All users cleared successfully";
  }

  public String clearName(String name){

    if(!usernameMap.containsKey(name)){
     return name + " " +"is not in the system";
    }
    else{
      return usernameMap.remove(name) + " cleared from system";
    }
  }
  public int counter(){
    return usernameMap.size();
  }
  public Integer counterName(String name){
    if (!usernameMap.containsKey(name)){
      return 0;
    }
    return usernameMap.get(name);
  }
  public String greetComm(){
    return " " + "command MUST be followed by name and language\n" + "Or followed by name only to be greeted with default language";
  }
  public void exit(){
    System.out.println("Goodbye...!!");
    System.exit(0);
  }
}
