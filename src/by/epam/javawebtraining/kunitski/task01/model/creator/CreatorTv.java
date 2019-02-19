package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Tv;

public class CreatorTv implements AbstractCreator {
  @Override
  public Tv create() {
    return new Tv();
  }
}
