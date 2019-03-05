package by.epam.javawebtraining.kunitski.task01.view;

import by.epam.javawebtraining.kunitski.task01.exception.WrongOutputPathTechnicalException;

import java.io.FileOutputStream;
import java.io.IOException;

public class PrinterFile implements Printable {
  private final String OUTPUT_PATH = "output//output.txt";

  @Override
  public void print(Object massage) throws WrongOutputPathTechnicalException {
    try {
      FileOutputStream fos = new FileOutputStream(OUTPUT_PATH);
      byte[] bytes = massage.toString().getBytes();
      fos.write(bytes);
    } catch (IOException e) {
      throw new WrongOutputPathTechnicalException(e);
    }
  }
}
