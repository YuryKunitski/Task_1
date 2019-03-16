package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public class MaxPriceFinder extends PriseFinder {

  @Override
  public Equipment find(Home home) throws NullHomeLogicException {

    double max = 0;

    if (home != null) {

      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e.getPrice() > max) {
          max = e.getPrice();
        }
      }
    } else {
      throw new NullHomeLogicException();
    }

    return super.findNeedValue(home, max);
  }
}
