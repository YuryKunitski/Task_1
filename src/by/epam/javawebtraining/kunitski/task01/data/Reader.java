package by.epam.javawebtraining.kunitski.task01.data;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Read data from the data file, and return list of data.
 */
public class Reader {

  public static String readFromFile(String dataPath) throws WrongDataPathTechnicalException {

    StringBuilder stringBuilder = new StringBuilder();

    if (dataPath != null) {
      try {
        Scanner scanner = new Scanner(new FileInputStream(dataPath));
        while (scanner.hasNextLine()) {
          stringBuilder.append(scanner.nextLine()).append("\n");
        }
      } catch (FileNotFoundException e){
          throw new WrongDataPathTechnicalException(e);
      }
    }
    return stringBuilder.toString();
  }

}
