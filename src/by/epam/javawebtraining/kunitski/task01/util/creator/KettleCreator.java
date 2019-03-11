package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Kettle;

/**
 * Read the data from file (PATH_FILE), then split necessary line and put it in listArgs,
 * then parse each value (value is validated in class Parser!) and create required equipment.
 */

public class KettleCreator implements AbstractCreator {

  @Override
  public Kettle create() {
    return new Kettle();
  }
}

