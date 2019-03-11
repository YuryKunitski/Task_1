package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.MultiCooker;

/**
 * Read the data from file (PATH_FILE), then split necessary line and put it in listArgs,
 * then parse each value (value is validated in class Parser!) and create required equipment.
 */

public class MultiCookerCreator implements AbstractCreator {

  @Override
  public MultiCooker create() {
    return new MultiCooker();
  }
}
