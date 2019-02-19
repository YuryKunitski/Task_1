package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.MultiCooker;

public class CreatorMultiCooker implements AbstractCreator {
  @Override
  public MultiCooker create() {
    return new MultiCooker();
  }
}
