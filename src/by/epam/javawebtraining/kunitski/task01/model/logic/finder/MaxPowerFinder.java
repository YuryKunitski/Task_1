package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public class MaxPowerFinder extends PowerFinder {
  @Override
  public Equipment find(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    int max = 0;

    for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
      if (e.getPower() > max) {
        max = e.getPower();
      }
    }
    return findNeedPower(home, max);
  }
}
