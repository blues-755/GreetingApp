package net.greet;

public class CommandExtractor {

   String[] commander;
   String username;
   String language;

   public CommandExtractor(String command){
    this.commander = command.trim().split(" ");
  }

  String getCommander() {
    return commander[0];
  }

   String getUsername() {
     this.username = commander[1];
     return this.username;
  }

   public String getLanguage() {
     this.language = commander[2];
     return this.language.toUpperCase();
  }

   int tabLength() {
    return commander.length;
  }


}