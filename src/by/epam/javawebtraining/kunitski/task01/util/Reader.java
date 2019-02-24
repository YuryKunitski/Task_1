package by.epam.javawebtraining.kunitski.task01.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read from the data file, and return
 */
public class Reader {

  public static List<String> readFromFile(String path) throws FileNotFoundException {
    List<String> stringList = new ArrayList<>();
    if (path != null) {
      Scanner scanner = new Scanner(new FileInputStream(path));
      while (scanner.hasNextLine()) {
          stringList.add(scanner.nextLine());
      }
    }
    return stringList;
  }
}
