package net.greet;

import java.util.HashMap;
import java.util.Map;

public class GreetLogic {

    Map<String, Integer> usernameMap = new HashMap<>();

    public void help(){
        System.out.println("list of commands you need to follow when using greeting app:\n"+
                            "'greet' followed by the name and language greets the user based on a chosen language.\n" +
                            "'greeted' shows you a list of greeted users, \n'greeted' " +
                            "followed by the user name shows you how many times that user had been greeted'\n"+
                            "'help' shows you a list of commands\n"+
                            "'exit' exits the application");
    }
    public String greetPerson(String name, String langType) {

        if(usernameMap.containsKey(name)){
            usernameMap.put(name, usernameMap.get(name) + 1);
        } else {
            usernameMap.put(name, 1);
        }
        try{
            return Languages.valueOf(langType).getUsername(name);
        } catch (NullPointerException e) {
           return Languages.valueOf("ISIXHOSA").getUsername(name);
        } catch (IllegalArgumentException e) {
            return Languages.valueOf("ISIXHOSA").getUsername(name);
        }
    }

    public void greetedName(String name){
        System.out.println(usernameMap.get(name));
    }

    public Map<String, Integer> greetedList(){
        return usernameMap;
    }

    public void clear(){
        if(usernameMap.isEmpty()){
            System.out.println("Nothing to clear, List is empty...");
        }
        else
            System.out.println("Users cleared successfully");
        usernameMap.clear();
    }

    public Integer clearName(String name){
        return usernameMap.remove(name);
    }
    public int counterAll(){
        System.out.println();
        System.out.println(usernameMap.size() + " user(s) in the list");
        return usernameMap.size();
    }
    public int counter(String name){
        if(!usernameMap.containsKey(name)){
            return 0;
        }
        return usernameMap.get(name);
    }
    public void exit(){
        System.out.println("Goodbye!....");
        System.exit(0);
    }
}
