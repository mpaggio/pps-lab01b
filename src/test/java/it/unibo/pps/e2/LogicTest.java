package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  @Test
  public void testInitialSize() {
      Logics logic = new LogicsImpl(5);
      assertEquals(5, logic.getSize());
  }
}
