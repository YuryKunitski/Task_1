package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Microwave;

public class CreatorMicrowave  implements AbstractCreator {
  @Override
  public Microwave create() {
    return new Microwave();
  }
}
