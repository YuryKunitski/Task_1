package by.epam.javawebtraining.kunitski.task01.util;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read data from the data file, and return list of data.
 */
public class Reader {

  public static List<String> readFromFile(String path) throws WrongDataPathTechnicalException {
    List<String> stringList = new ArrayList<>();
    if (path != null) {
      try {
        Scanner scanner = new Scanner(new FileInputStream(path));
        while (scanner.hasNextLine()) {
          stringList.add(scanner.nextLine());
        }
      } catch (FileNotFoundException e){
          throw new WrongDataPathTechnicalException(e);
      }
    }
    return stringList;
  }
}
