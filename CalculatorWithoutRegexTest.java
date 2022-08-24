import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.api.Assert.assertEquals;

public class CalculatorWithoutRegexTest {
  @Test
  @DisplayName("Addition Test w/o White Spaces")
  void additionTestWithoutWhiteSpaces() {
    assertEquals(333.1, CalculatorWithoutRegex.calculate("111.0+222.1"), "Addition w/o spaces should work."); 
  }

  @Test
  @DisplayName("Addition Test With White Spaces")
  void additionTestWithWhiteSpaces() {
    assertEquals(400.44, CalculatorWithoutRegex.calculate("220.22 + 180.22"), "Addition with spaces should work."); 
  }
  
  @Test
  @DisplayName("Subtraction Test")
  void subtractionTest() {
    assertEquals(100.2, CalculatorWithoutRegex.calculate("1000.50 - 900.3"), "Subtraction should work."); 
  }

  @Test
  @DisplayName("Multiplication Test")
  void multiplicationTest() {
    assertEquals(3450.0, CalculatorWithoutRegex.calculate("10 * 345.0"), "Multiplication should work."); 
  }

  @Test
  @DisplayName("Division Test")
  void divisionTest() {
    assertEquals(9.0, CalculatorWithoutRegex.calculate("81 / 9.00"), "Division should work."); 
  }
}
