//import net.greet.DatabaseBuilder;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConnectionTest {
  @Test
  public void testConnection() throws ClassNotFoundException{
    Connection con;
    Class.forName("org.h2.Driver");
  }

}
