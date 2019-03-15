package by.epam.javawebtraining.kunitski.task01.view;

import org.apache.log4j.Logger;

/**
 * I made this class for my printer's hierarchy and I don't know how do it exactly.
 */

public class LogPrinter implements Printable {

  public static final Logger LOGGER = Logger.getRootLogger();

  @Override
  public void print(Object massage) {
    LOGGER.info(massage);
  }
}
