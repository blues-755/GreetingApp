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
                    String langType = "ISIXHOSA";
                   greetLogic.greetPerson(name, langType);
                    System.out.println(Languages.valueOf(langType).getUsername(name));
                }

                //GREET COMMAND FOLLOWED BY USER NAME AND LANGUAGE
                else if(tab[0].equalsIgnoreCase("greet") && tab.length == 3){
                    String name = tab[1].toUpperCase();
                    String langType = tab[2].toUpperCase();
                    greetLogic.greetPerson(name, langType);
                    System.out.println(Languages.valueOf(langType).getUsername(name));
                }

                //GREETED LIST OF USERS and GREETED FOR A SINGLE USER
                else if(tab[ 0 ].equalsIgnoreCase("greeted")){
                    if(tab.length == 2){
                        greetLogic.greetedName(tab[1].toUpperCase());
                    }else {
                        System.out.println(greetLogic.usernameMap);
                    }
                }
                //CHECKING THE GREETED USERNAME
                else if(tab.length > 2){
                    String name = tab[ 1 ];
                    String langType = tab[ 2 ].toUpperCase();
                    Languages.valueOf(langType);
                    System.out.println(Languages.valueOf(langType).getUsername(name));
                }

                //COUNTER FOR ALL USER NAMES IN THE SYSTEM
                else if ("counter".equalsIgnoreCase(command)) {
                    greetLogic.counterAll();
                }

                //COUNTER FOR SPECIFIED USER NAME
                else if (tab[0].equalsIgnoreCase("counter")) {
                    console.nextLine();
                    String name = tab[1].toUpperCase();
                    greetLogic.counter(name);
                    System.out.println(greetLogic.counter(name));

                }

                //AN OVERVIEW OF VALID COMMANDS
                else if ("help".equalsIgnoreCase(command)) {
                    greetLogic.help();
                }

                //CLEARS ALL THE USER NAMES IN THE LIST
                else if ("clear".equalsIgnoreCase(command)) {
                    greetLogic.clear();
                }

                //EXITS THE APPLICATION
                else if ("exit".equalsIgnoreCase(command)) {
                    greetLogic.exit();
                }

                //CLEARS A SPECIFIED USER NAME FROM THE SYSTEM
                else if (tab[ 0 ].equalsIgnoreCase("clear") && tab.length == 2) {
                    String name = tab[ 1 ];
                    greetLogic.clearName(name);
                }

                //DISPLAYS AN 'INVALID OPTION' STATEMENT IF A USER MISTYPED A COMMAND
                else{
                    System.out.println("Invalid option please type again");
                }
            }catch (IllegalArgumentException e){
                System.out.println("OOPS...ERROR OCCURRED\n" + "Type 'help' to view list of valid commands");
            }

        }
    }
}
