package net.greet;
import java.util.Scanner;

public class GreetMain {
    public static void main(String[] args) {

      GreetLogic greetLogic = new GreetLogic();

        Scanner console = new Scanner(System.in);
        System.out.println("You can also type 'help' to view list of valid commands");

        while (true) {
            try{
                System.out.println("Type in your command >>: ");
                String command = console.nextLine();
                String[] tab = command.trim().split(" ");

                if (tab[ 0 ].equalsIgnoreCase("greet") && tab.length == 2) {
                    String name = tab[ 1 ].toUpperCase();
                    System.out.println(greetLogic.greetPerson(name, "ISIXHOSA"));
                }

                //GREET COMMAND FOLLOWED BY USER NAME AND LANGUAGE
                else if(tab[0].equalsIgnoreCase("greet") && tab.length == 3){
                    String name = tab[1].toUpperCase();
                    String greetType = tab[2].toUpperCase();
                    greetLogic.greetPerson(name, greetType);
                    System.out.println(Languages.valueOf(greetType).getLang() + name);
                }

                //GREETED LIST OF USERS and GREETED FOR A SINGLE USER
                else if(tab[ 0 ].equalsIgnoreCase("greeted")){
                    if(tab.length == 2){
                        String name = tab[ 1 ].toUpperCase();
                        greetLogic.greetedName(tab[1].toUpperCase());
                        System.out.println(greetLogic.greetedName(name));
                    }else {
                        System.out.println(greetLogic.greetedList());
                    }
                }

                //CHECKING THE GREETED USERNAME
                else if(tab.length > 2){
                    String name = tab[ 1 ];
                    String greetLang = tab[ 2 ].toUpperCase();
                    Languages.valueOf(greetLang);
                    System.out.println(Languages.valueOf(greetLang).getLang() + name);
                }

                //COUNTER FOR ALL USER NAMES IN THE SYSTEM
                else if ("counter".equalsIgnoreCase(command)) {
                    System.out.println(greetLogic.counterAll() + " user(s) in the list");
                }

                //COUNTER FOR SPECIFIED USER NAME
                else if (tab[0].equalsIgnoreCase("counter")) {
                    console.nextLine();
                    String name = tab[1].toUpperCase();
                    if(!greetLogic.usernameMap.containsKey(name)){
                        System.out.println(name + " is not in the system");
                    }
                    else {
                        System.out.println(name + " counted "+ greetLogic.counter(name) + " time(s)");
                    }

                }

                //AN OVERVIEW OF VALID COMMANDS
                else if ("help".equalsIgnoreCase(command)) {
                    greetLogic.help();
                }

                //CLEARS ALL THE USER NAMES IN THE LIST
                else if ("clear".equalsIgnoreCase(command)) {
                    greetLogic.clear();
                }

                //CLEARS A SPECIFIED USER NAME FROM THE SYSTEM
                else if (tab[ 0 ].equalsIgnoreCase("clear") && tab.length == 2) {
                    String name = tab[ 1 ].toUpperCase();
                    if(!greetLogic.usernameMap.containsKey(name)){
                        System.out.println(name + " " +"is not in the system");
                    }
                    else{
                        greetLogic.clearName(name);
                        System.out.println(name + " cleared from system");
                    }

                }

                //EXITS THE APPLICATION
                else if ("exit".equalsIgnoreCase(command)) {
                    greetLogic.exit();
                }

                //DISPLAYS AN 'INVALID OPTION' STATEMENT IF A USER MISTYPED A COMMAND
                else{
                    System.out.println("Invalid option please type again");
                }
            }catch (IllegalArgumentException e) {
                System.out.println("OOPS...ERROR OCCURRED, Please type 'help' to display list valid of commands");
            }
        }
    }
}

