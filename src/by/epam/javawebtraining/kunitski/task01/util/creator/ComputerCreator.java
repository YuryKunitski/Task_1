package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Computer;

public class ComputerCreator implements AbstractCreator {

  @Override
  public Computer create() {
    return new Computer();
  }
}
