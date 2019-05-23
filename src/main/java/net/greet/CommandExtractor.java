package net.greet;

public class CommandExtractor {

   String[] commander;
   String username;
   String language;

   public CommandExtractor(String command){
    this.commander = command.trim().split(" ");
  }
  public String getCommander() {
       return commander[0];
  }
  public boolean hasName() {
       return !getUsername().isEmpty();
  }
   public String getUsername() {
     if (commander.length >= 2){
       return this.username = commander[1];
     }
     else{
       return this.username = "";
     }
  }
   public String getLanguage() {
     if(commander.length == 3) {
       this.language = commander[2].toUpperCase();
     } else {
       this.language = "ISIXHOSA";
     }
     return this.language;
  }
}