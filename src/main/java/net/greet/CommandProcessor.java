package net.greet;

public class CommandProcessor {
  HelpInfo help = new HelpInfo();
//  GreetLogic put = new GreetLogic();// MAP
  DatabaseBuilder put = new DatabaseBuilder();
  public String execute(String output) {
    CommandExtractor extractor = new CommandExtractor(output);

    // GREETING WITH DEFAULT LANGUAGE AND USER LANGUAGE
    if ("greet".equalsIgnoreCase(extractor.getCommander()) && extractor.hasName()) {
      return put.storeName(extractor.getUsername(), extractor.getLanguage());
    }

    //GREETED LIST OF USERS AND GREETED FOR A SINGLE USER
    else if ("greeted".equalsIgnoreCase(extractor.getCommander())) { if (extractor.hasName()) {
        return
              extractor.getUsername() + " " +
              "greeted" + " " + put.counterName(extractor.getUsername()) + " " +
              "times(s)"; } else { return put.greetedList().toString(); }}

    //CHECKING THE GREETED USERNAME
    else if (extractor.getLanguage().isEmpty()) { //extractor.tabLength > 2
      Languages.valueOf(extractor.getLanguage());
      return Languages.valueOf(extractor.getLanguage()).getLang() + extractor.getUsername(); }

    //COUNTER FOR SPECIFIED USER NAME
    else if ("counter".equalsIgnoreCase(extractor.getCommander()) && extractor.tabLength() == 2) {
      return  extractor.getUsername() + " counted  " + put.counter() + " time(s)"; }

    //COUNTER FOR ALL USER NAMES IN THE SYSTEM
    else if ("counter".equalsIgnoreCase(extractor.getCommander())) { return put.counter() + " user(s) in the list";}

      //CLEARS ALL THE USER NAMES IN THE LIST
    else if ("clear".equalsIgnoreCase(extractor.getCommander())) { if (extractor.tabLength() == 2) {
      return put.clearName(extractor.getUsername());} else { return put.clear();}}
    else if ("help".equalsIgnoreCase((extractor.getCommander()))) {help.help(); }
    else if ("exit".equalsIgnoreCase(extractor.getCommander())) {put.exit(); }
    else if("greet".equalsIgnoreCase(extractor.getCommander())){ return extractor.getCommander() + help.greetComm();}
    else { System.out.println("INVALID COMMAND >> " + " " + extractor.getCommander() + " "+
                              "\nType 'help' display list of valid commands");} return "";}}
