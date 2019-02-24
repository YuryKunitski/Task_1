package by.epam.javawebtraining.kunitski.task01.util;


public class Validator {
  /**
   * @param value
   * @return is value a number?
   */
  public static boolean isValidNumber(String value) {
    if (value != null) {
      if (value.matches("-?\\d+(\\.\\d+)?")) {
        return true;
      }
    }
    return false;
  }

  public static boolean isValidBoolen(String value) {
    if (value != null) {
      if (value.equals("true") || value.equals("false")) {
        return true;
      }
    }
    return false;
  }

  public static boolean isValidTypeTv(String value) {
    if (value != null) {
      if (value.equalsIgnoreCase("COSMOSTV") || value.equalsIgnoreCase("ZALA")
              || value.equalsIgnoreCase("VOKATV")
              || value.equalsIgnoreCase("BELTELECOM")) {
        return true;
      }
    }
    return false;
  }
}
