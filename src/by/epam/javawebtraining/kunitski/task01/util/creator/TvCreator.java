package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.TV;

public class TvCreator implements AbstractCreator {

  @Override
  public TV create() {
    return new TV();
  }
}
