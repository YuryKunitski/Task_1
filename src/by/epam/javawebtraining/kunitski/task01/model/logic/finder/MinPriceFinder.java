package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public class MinPriceFinder extends PriseFinder {

  @Override
  public Equipment find(Home home) throws NullHomeLogicException {

    if (home == null) {
      throw new NullHomeLogicException();
    }

    Equipment[] temp = ParserHome.getArray(home.getEquipmentHomeCatalog());
    double min = temp[0].getPrice();

    for (Equipment e : temp) {
      if (e.getPrice() < min) {
        min = e.getPrice();
      }
    }
    return super.findNeedValue(home, min);
  }
}
