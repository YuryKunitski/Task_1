package by.epam.javawebtraining.kunitski.task01.data;

import by.epam.javawebtraining.kunitski.task01.util.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

  boolean expectedTrue = true;
  boolean expectedFalse = false;

  @Test
  public void isValidKettleTrue() {
    String[] expected = new String[]{ "Kettle", "Tefal", "50.0", "800", "true", "1.8", "0.3"};
    assertEquals(expectedTrue, Validator.isValidKettle(expected));
  }


  @Test
  public void isValidKettleFalse() {
    String[] expected = new String[]{ "Kettle", "Tefal", "five", "800", "true", "1.8", "0.3"};
    assertEquals(expectedFalse, Validator.isValidKettle(expected));
  }

  @Test
  public void isValidMicrowaveTrue() {
    String[] expected = new String[]{ "Microwave", "Tefal", "50.0", "800", "true", "1.8", "true"};
    assertEquals(expectedTrue, Validator.isValidMicrowave(expected));
  }


  @Test
  public void isValidMicrowaveFalse() {
    String[] expected = new String[]{ "Microwave", "Tefal", "five", "800", "true", "1.8", "true"};
    assertEquals(expectedFalse, Validator.isValidMicrowave(expected));
  }

  @Test
  public void isValidMultiCookerTrue() {
    String[] expected = new String[]{ "Multicooker", "Tefal", "50.0", "800", "true", "1.8", "24"};
    assertEquals(expectedTrue, Validator.isValidMultiCooker(expected));
  }


  @Test
  public void isValidMultiCookerFalse() {
    String[] expected = new String[]{ "Multicooker", "Tefal", "five", "800", "true", "1.8", "24"};
    assertEquals(expectedFalse, Validator.isValidMultiCooker(expected));
  }

  @Test
  public void isValidComputerTrue() {
    String[] expected = new String[]{ "Computer", "Tefal", "50.0", "800", "true", "18", "2048"};
    assertEquals(expectedTrue, Validator.isValidComputer(expected));

  }


  @Test
  public void isValidComputerFalse() {
    String[] expected = new String[]{ "Computer", "Tefal", "50.0", "800", "true", "18", "two"};
    assertEquals(expectedFalse, Validator.isValidComputer(expected));

  }

  @Test
  public void isValidTvTrue() {
    String[] expected = new String[]{ "TV", "Tefal", "50.0", "800", "true", "18", "ZALA"};
    assertEquals(expectedTrue, Validator.isValidTv(expected));

  }

  @Test
  public void isValidTvFalse() {
    String[] expected = new String[]{ "TV", "Tefal", "50.0", "800", "true", "18", "text"};
    assertEquals(expectedFalse, Validator.isValidTv(expected));

  }
}