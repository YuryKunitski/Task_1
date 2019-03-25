package by.epam.javawebtraining.kunitski.task01.view;

import by.epam.javawebtraining.kunitski.task01.exception.WrongOutputPathTechnicalException;

import java.io.FileOutputStream;
import java.io.IOException;

public class FilePrinter implements Printable {

  private String outputPath;

  public FilePrinter(String output_path) {
    outputPath = output_path;
  }

  @Override
  public void print(Object massage) {
    try {
      try {
        FileOutputStream fos = new FileOutputStream(outputPath);
        byte[] bytes = massage.toString().getBytes();
        fos.write(bytes);
        fos.flush();
        fos.close();
      } catch (IOException e) {
        throw new WrongOutputPathTechnicalException(e);
      }
    } catch (WrongOutputPathTechnicalException e) {
      System.out.println(e);
      LogPrinter.LOGGER.error(e);
    }
  }
}
