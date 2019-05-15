package net.greet;
import java.util.HashMap;
import java.util.Map;

public class GreetLogic implements GreetInterface {

  Map<String, Integer> usernameMap = new HashMap<>();

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

    if(usernameMap.containsKey(name)){
      usernameMap.remove(name);
      return name + " cleared from system";
    }
    else { return name + " " +"is not in the system\n" + "Run 'greeted' command to display list of names in the system"; }
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
  public void exit(){
    System.out.println("Goodbye...!!");
    System.exit(0);
  }
}
