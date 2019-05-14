package net.greet;

public class HelpInfo {
  public void help(){
    System.out.println("list of commands you need to follow when using greeting app:\n"+
          "'greet' followed by the name and language greets the user based on a chosen language.\n" +
          "'greeted' shows you a list of greeted users, \n" +
          "'greeted' " + "followed by the user name shows you how many times that user had been greeted'\n"+
          "'help' shows you a list of commands\n"+
          "'exit' exits the application\n" +
          "'clear' deletes all users in the system\n" +
          "'clear' followed by the username removes the specified name from the system\n" +
          "'counter' displays the unique number of users in the system\n" +
          " counter followed by the username returns how many times that name had been counted");
  }
  public String greetComm(){
    return " " + "command MUST be followed by name and language\n" +
          "Or followed by name only to be greeted with default language";
  }
}
