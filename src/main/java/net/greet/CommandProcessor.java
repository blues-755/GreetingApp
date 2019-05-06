package net.greet;

public class CommandProcessor {

//    DatabaseBuilder put; //DATABASE
    HelpInfo help = new HelpInfo();
  GreetLogic put = new GreetLogic();// MAP
  public String execute(String output) {
    CommandExtractor extractor = new CommandExtractor(output);

    // GREETING WITH DEFAULT LANGUAGE AND USER LANGUAGE
    if (extractor.getCommander().equalsIgnoreCase("greet") && extractor.hasName()) {
        return put.storeName(extractor.getUsername(), extractor.getLanguage());
    }

    //GREETED LIST OF USERS AND GREETED FOR A SINGLE USER
    else if (extractor.getCommander().equalsIgnoreCase("greeted")) {
      if (extractor.hasName()) {
        return
              extractor.getUsername() + " " +
              "greeted" + " " + put.counterName(extractor.getUsername()) + " " +
              "times(s)";
      } else {
        return put.greetedList().toString();
      }
    }

    //CHECKING THE GREETED USERNAME
    else if (extractor.tabLength() > 2) {
      Languages.valueOf(extractor.getLanguage());
      return Languages.valueOf(extractor.getLanguage()).getLang() + extractor.getUsername();
    }

    //COUNTER FOR SPECIFIED USER NAME
    else if (extractor.getCommander().equalsIgnoreCase("counter") && extractor.tabLength() == 2) {
      return  extractor.getUsername() + " counted  " + put.counter() + " time(s)";
    }

    //COUNTER FOR ALL USER NAMES IN THE SYSTEM
    else if ("counter".equalsIgnoreCase(extractor.getCommander())) {
      return put.counter() + " user(s) in the list";
    }

      //CLEARS ALL THE USER NAMES IN THE LIST
    else if ("clear".equalsIgnoreCase(extractor.getCommander())) {
      if (extractor.tabLength() == 2) {
        return put.clearName(extractor.getUsername());
      }
      else {
        return put.clear();
        }
      }
    else if (extractor.getCommander().equalsIgnoreCase("help")) {
      help.help();
    }
    else if (extractor.getCommander().equalsIgnoreCase("exit")) {
      put.exit();
    }
    else if(extractor.getCommander().equalsIgnoreCase("greet")){
      return extractor.getCommander() + help.greetComm();
    }
    else {
      System.out.println("INVALID COMMAND >> " + " " + extractor.getCommander() + " "+
                          "\nType 'help' display list of valid commands");
    }
      return "";
    }
}
