package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Computer;

public class CreatorComputer implements AbstractCreator {
  @Override
  public Computer create() {
    return new Computer();
  }
}
