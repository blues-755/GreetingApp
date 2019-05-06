package net.greet;

public class CommandProcessor {
  public String execute(String output) {

    GreetLogic put = new GreetLogic();// MAP
//    DatabaseBuilder put = new DatabaseBuilder(); //DATABASE

    CommandExtractor extractor = new CommandExtractor(output);

    // GREETING WITH DEFAULT LANGUAGE AND USER LANGUAGE
    if (extractor.getCommander().equalsIgnoreCase("greet") && extractor.tabLength() == 2) {

      if (extractor.tabLength() == 3){
        return put.storeName(extractor.getUsername(), extractor.getLanguage()).toUpperCase();
      }
      return put.storeName(extractor.getUsername(), String.valueOf(Languages.ISIXHOSA));
    }

    //GREETED LIST OF USERS AND GREETED FOR A SINGLE USER
    else if (extractor.getCommander().equalsIgnoreCase("greeted")) {
      if (extractor.tabLength() == 2) {
        System.out.println(
              extractor.getUsername() + " " +
              "greeted" + " " + put.counterName(extractor.getUsername()) + " " +
              "times(s)");
      } else {
        System.out.println(put.greetedList());
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
        System.out.println(put.clearName(extractor.getUsername()));
      }
      else {
        return String.valueOf(put.clear());
        }
      }
    else if (extractor.getCommander().equalsIgnoreCase("help")) {
      put.help();
    }
    else if (extractor.getCommander().equalsIgnoreCase("exit")) {
      put.exit();
    }

    else if(extractor.getCommander().equalsIgnoreCase("greet") && extractor.tabLength() == 1){
      return extractor.getCommander() + put.greetComm();
    }
    else {
      System.out.println("INVALID COMMAND >> " + " " + extractor.getCommander() + " "+
                          "\nType 'help' display list of valid commands");
    }
      return "";
    }
}
