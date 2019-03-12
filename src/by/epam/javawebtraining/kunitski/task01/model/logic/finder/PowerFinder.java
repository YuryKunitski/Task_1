package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public abstract class PowerFinder implements Finder {

  public static Equipment findNeedPower(Home home, int value) {

    Equipment findEquipment = null;

    if (home != null && value > 0) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e.getPower() == value) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }

}
