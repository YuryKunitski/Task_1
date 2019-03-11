package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Tv;

public class TvCreator implements AbstractCreator {

  @Override
  public Tv create() {
    return new Tv();
  }
}
