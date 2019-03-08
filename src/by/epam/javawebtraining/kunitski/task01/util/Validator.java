package by.epam.javawebtraining.kunitski.task01.util;


public class Validator {
  /**
   * @return is value a number?
   */
  public static boolean isValidNumber(String value) {
    if (value != null) {
      return value.matches("-?\\d+(\\.\\d+)?");
    }
    return false;
  }

  public static boolean isValidBoolen(String value) {
    if (value != null) {
        return value.equals("true") || value.equals("false");
    }
    return false;
  }

  public static boolean isValidTvType(String value) {
    if (value != null) {
        return value.equalsIgnoreCase("COSMOSTV") || value.equalsIgnoreCase("ZALA")
                || value.equalsIgnoreCase("VOKATV")
                || value.equalsIgnoreCase("BELTELECOM");
    }
    return false;
  }
}
