package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public abstract class PriseFinder implements Finder {

  @Override
  public Equipment findNeedValue(Home home, Object value) {

    Equipment findEquipment = null;

    if (home != null && (Double)value > 0) {

      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e.getPrice() == (Double) value) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }
}
