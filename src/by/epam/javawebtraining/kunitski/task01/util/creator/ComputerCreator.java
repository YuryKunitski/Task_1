package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Computer;

/**
 * Read the entity from file (PATH_FILE), then split necessary line and put it in listArgs,
 * then parse each value (value is validated in class Parser) and create required equipment.
 */
public class ComputerCreator implements AbstractCreator {

  @Override
  public Computer create() {
    return new Computer();
  }
}
