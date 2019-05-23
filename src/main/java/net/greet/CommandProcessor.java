package net.greet;

import java.sql.SQLException;

public class CommandProcessor {
  GreetInterface put;

  CommandProcessor(GreetInterface greetInterface){
      this.put = greetInterface;
  }
  HelpInfo help = new HelpInfo();
//  GreetLogic put = new GreetLogic();// MAP
//  DatabaseBuilder put = new DatabaseBuilder();//DATABASE
    String execute(String output) throws SQLException {
    CommandExtractor extractor = new CommandExtractor(output);

    // GREETING WITH DEFAULT LANGUAGE AND USER LANGUAGE
    if ("greet".equalsIgnoreCase(extractor.getCommander()) && extractor.hasName()) {
      return put.storeName(extractor.getUsername(), extractor.getLanguage());
    }

    //GREETED LIST OF USERS AND GREETED FOR A SINGLE USER
    else if ("greeted".equalsIgnoreCase(extractor.getCommander())) {
      if (extractor.hasName()) {
        return
              extractor.getUsername() + " " +
              "greeted" + " " + put.counterName(extractor.getUsername()) + " " +
              "times(s)";
      }
      else { return put.greetedList().toString();
      }
    }

    //CHECKING THE GREETED USERNAME
    else if (extractor.getLanguage().isEmpty()) {
      Languages.valueOf(extractor.getLanguage());
      return Languages.valueOf(extractor.getLanguage()).getLang() + extractor.getUsername(); }

    //COUNTER FOR SPECIFIED USER NAME
    else if ("counter".equalsIgnoreCase(extractor.getCommander()) && extractor.hasName()) {
      return  extractor.getUsername() + " counted  " + put.counterName(extractor.getUsername()) + " time(s)"; }

    //COUNTER FOR ALL USER NAMES IN THE SYSTEM
    else if ("counter".equalsIgnoreCase(extractor.getCommander())) { return put.counter() + " user(s) in the list";}

      //CLEAR ALL USERS
    else if ("clear".equalsIgnoreCase(extractor.getCommander())) { if (extractor.hasName()) {
      return put.clearName(extractor.getUsername());} else { return put.clear();}}

    //HELP INFO
    else if ("help".equalsIgnoreCase((extractor.getCommander()))) {return help.help();}

    //EXITS THE APP
    else if ("exit".equalsIgnoreCase(extractor.getCommander())) {put.exit(); }

    //VALIDATING 'greet' COMMAND
    else if("greet".equalsIgnoreCase(extractor.getCommander())){ return extractor.getCommander() + help.greetComm();}
    else {return "INVALID COMMAND >> " + " " + extractor.getCommander() + " "+
                              "\nType 'help' display list of valid commands";} return "";
    }
}
