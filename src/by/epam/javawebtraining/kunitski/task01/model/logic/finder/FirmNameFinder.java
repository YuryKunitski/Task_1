package by.epam.javawebtraining.kunitski.task01.model.logic.finder;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.ParserHome;

public class FirmNameFinder extends AbstractFirmNameFinder {

  @Override
  public Equipment findNeedValue(Home home, Object value) {

    Equipment findEquipment = null;

    if (home != null && value != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e.getFirmName().equals(value)) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }
}
