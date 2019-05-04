package net.greet;
import java.util.Scanner;

public class GreetMain {

    public static void main(String[] args) {

      CommandProcessor processor = new CommandProcessor();
      Scanner console = new Scanner(System.in);
      System.out.println("You can also type 'help' to view list of valid commands");

      while (true) try {
        System.out.println("Type in your command >>: ");
        String command = console.nextLine();
        System.out.println(processor.execute(command));

      } catch (IllegalArgumentException e) {
        System.out.println("OOPS...ERROR OCCURRED, Please type 'help' to display list valid of commands");
      }
        }
    }

