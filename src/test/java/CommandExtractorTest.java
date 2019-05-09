import net.greet.CommandExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

  @Test
  void testGreetingWithLang() {
    CommandExtractor commandExtractor = new CommandExtractor("greet lunga english");

    assertEquals("greet", commandExtractor.getCommander());
    assertEquals("lunga", commandExtractor.getUsername());
    assertEquals("ENGLISH", commandExtractor.getLanguage());
  }

  @Test
  void testGreetingWithDefaultLang() {
    CommandExtractor commandExtractor = new CommandExtractor("greet lunga");

    assertEquals("greet", commandExtractor.getCommander());
    assertEquals("lunga", commandExtractor.getUsername());
    assertEquals("ISIXHOSA", commandExtractor.getLanguage());
    assertEquals(true, commandExtractor.hasName());
  }

  @Test
  void testGreeted() {
    CommandExtractor commandExtractor = new CommandExtractor("greeted");

    assertEquals("greeted", commandExtractor.getCommander());
    assertEquals("", commandExtractor.getUsername());
    assertEquals("ISIXHOSA", commandExtractor.getLanguage());
  }
  void testClear() {
    CommandExtractor commandExtractor = new CommandExtractor("");

    assertEquals("greet", commandExtractor.getCommander());
    assertEquals("lunga", commandExtractor.getUsername());
    assertEquals("ISIXHOSA", commandExtractor.getLanguage());
  }
}