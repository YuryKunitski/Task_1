package by.epam.javawebtraining.kunitski.task01.util;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Read data from the data file, and return list of data.
 */
public class Reader {

  public static String readFromFile(String dataPath) throws WrongDataPathTechnicalException {

    Scanner scanner = null;
    StringBuilder stringBuilder = new StringBuilder();
    String lineSeparator = "\n";

    if (dataPath != null) {
      try {
        scanner = new Scanner(new FileInputStream(dataPath));
        while (scanner.hasNextLine()) {
          stringBuilder.append(scanner.nextLine()).append(lineSeparator);
        }
      } catch (FileNotFoundException e){
          throw new WrongDataPathTechnicalException(e);
      }
    }
    return stringBuilder.toString();
  }

}
