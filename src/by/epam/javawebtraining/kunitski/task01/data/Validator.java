package by.epam.javawebtraining.kunitski.task01.data;

/**
 * Validates the input data
 */

public class Validator {

  private static final int CORRECT_ARRAY_LENGTH = 7;

  public static boolean isValidKettle(String[] argumentArray) {
    return isValidEquipment(argumentArray) && isValidDouble(argumentArray[5])
            && isValidDouble(argumentArray[6]);
  }

  public static boolean isValidMicrowave(String[] argumentArray) {
    return isValidEquipment(argumentArray) && isValidDouble(argumentArray[5])
            && isValidBoolean(argumentArray[6]);
  }

  public static boolean isValidMultiCooker(String[] argumentArray) {
    return isValidEquipment(argumentArray) && isValidDouble(argumentArray[5])
            && isValidInteger(argumentArray[6]);
  }

  public static boolean isValidComputer(String[] argumentArray) {
    return isValidEquipment(argumentArray) && isValidInteger(argumentArray[5])
            && isValidInteger(argumentArray[6]);
  }

  public static boolean isValidTv(String[] argumentArray) {
    return isValidEquipment(argumentArray) && isValidInteger(argumentArray[5])
            && isValidTvType(argumentArray[6]);
  }

  /**
   * This method validate the first four arguments for each equipments.
   * I missed first and second values of argumentArray because the first value isn't included
   * in argument's list of equipment. Second value of wordArray is first Equipment argument
   * and doesn't need validate because it has type is String. FirmName can has the anything value.
   */

  private static boolean isValidEquipment(String[] argumentArray) {
    return argumentArray != null && argumentArray.length == CORRECT_ARRAY_LENGTH
            && isValidDouble(argumentArray[2]) && isValidInteger(argumentArray[3])
            && isValidBoolean(argumentArray[4]);
  }

  private static boolean isValidInteger(String value) {
    return value != null
            && value.matches("[0-9]+");
  }

  private static boolean isValidDouble(String value) {
    return value != null
            && value.matches("\\d+(\\.\\d+)?");
  }

  private static boolean isValidBoolean(String value) {
    if (value != null) {
      return value.equals("true") || value.equals("false");
    }
    return false;
  }

  private static boolean isValidTvType(String value) {
    if (value != null) {
      return value.equalsIgnoreCase("COSMOSTV") || value.equalsIgnoreCase("ZALA")
              || value.equalsIgnoreCase("VOKATV")
              || value.equalsIgnoreCase("BELTELECOM");
    }
    return false;
  }
}
