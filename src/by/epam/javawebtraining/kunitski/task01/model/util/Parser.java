package by.epam.javawebtraining.kunitski.task01.model.util;

import by.epam.javawebtraining.kunitski.task01.model.data.TypeTV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
  /**
   * @param lineFromFile Split the "lineFromFile" by regex
   * @return List arguments for our objects without first value because first value isn't included
   * in our objects
   */
  public static List<String> splitLine(String lineFromFile) {
    String regex = " ";
    String[] arrayArgs = lineFromFile.split(regex);
    List<String> listArgs = new ArrayList<>(Arrays.asList(arrayArgs));

    return listArgs;
  }

  public static int parserInt(String value) {
    int result = 0;
    if (Validator.isValidNumber(value)) {
      result = Integer.parseInt(value);
    }
    return result;
  }

  public static double parserDouble(String value) {
    double result = 0;
    if (Validator.isValidNumber(value)) {
      result = Double.parseDouble(value);
    }
    return result;
  }

  public static boolean parserBoolen(String value) {
    boolean result = false;
    if (Validator.isValidBoolen(value)) {
      result = Boolean.parseBoolean(value);
    }
    return result;
  }

  public static TypeTV parserTypeTv(String value) {
    TypeTV result = null;
    if (Validator.isValidTypeTv(value)) {
      result = TypeTV.valueOf(value.toUpperCase());
    }
    return result;
  }
}
