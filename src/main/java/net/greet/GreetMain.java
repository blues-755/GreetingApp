package net.greet;
import java.sql.SQLException;
import java.util.Scanner;

public class GreetMain {

    public static void main(String[] args) {

      GreetInterface greetInterface = new  DatabaseBuilder();
      CommandProcessor processor = new CommandProcessor(greetInterface);
      Scanner console = new Scanner(System.in);
      System.out.println("You can also type 'help' to view list of valid commands");

      while (true) try {
        System.out.println("Type in your command >>: ");
        String command = console.nextLine();
        System.out.println(processor.execute(command));
      } catch (IllegalArgumentException e) {
        System.out.println("OOPS...ERROR OCCURRED, Please type 'help' to display list of valid commands");
      } catch (SQLException e) {
        System.out.println("SOME UNEXPECTED ERROR OCCURRED");
      }
    }
    }

