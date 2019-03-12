package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public class MaxPriceFinder extends PriseFinder {

  @Override
  public Equipment find(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    double max = 0;

    for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
      if (e.getPrice() > max) {
        max = e.getPrice();
      }
    }
    return findNeedPrice(home, max);
  }
}
