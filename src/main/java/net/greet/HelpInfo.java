package net.greet;

public class HelpInfo {

  public String help(){

StringBuilder info = new StringBuilder();

info.append("List of commands you need to follow when using greeting app: ");
info.append("'greet' followed by the name and language greets the user based on a chosen language." + "\n");
info.append( "'greeted' " + "followed by the user name shows you how many times that user had been greeted'\n");
info.append( "'help' shows you a list of commands \n");
info.append( "'exit' exits the application \n");
info.append( "'clear' deletes all users in the system \n");
info.append( "'clear' followed by the username removes the specified name from the system \n");
info.append( "'counter' displays the unique number of users in the system \n");
info.append( "'counter' followed by the username returns how many times that name had been counted");

   return String.valueOf(info);

  }
  public String greetComm(){
    return " " + "command MUST be followed by name and language\n" +
          "Or followed by name only to be greeted with default language";
  }
}
