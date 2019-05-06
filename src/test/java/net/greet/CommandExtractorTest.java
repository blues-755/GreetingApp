package net.greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

  @Test
  void testGreetingWithLang() {
    CommandExtractor commandExtractor = new CommandExtractor("greet thabang english");

    assertEquals("greet", commandExtractor.getCommander());
    assertEquals("lunga", commandExtractor.getUsername());
    assertEquals("ENGLISH", commandExtractor.getLanguage());
  }

  @Test
  void testGreetingWithDefaultLang() {
    CommandExtractor commandExtractor = new CommandExtractor("greet thabang");

    assertEquals("greet", commandExtractor.getCommander());
    assertEquals("lunga", commandExtractor.getUsername());
    assertEquals("ISIXHOSA", commandExtractor.getLanguage());
//    assertEquals(true, commandExtractor.hasName());
  }

  @Test
  void testGreeted() {
    CommandExtractor commandExtractor = new CommandExtractor("greeted");

    assertEquals("greeted", commandExtractor.getCommander());
    assertEquals("", commandExtractor.getUsername());
    assertEquals("ISIXHOSA", commandExtractor.getLanguage());
  }
}