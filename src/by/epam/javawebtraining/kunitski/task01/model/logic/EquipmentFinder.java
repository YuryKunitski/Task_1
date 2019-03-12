package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.finder.*;

/**
 * This class find the required equipments according to their parameters.
 * Throwing my own exceptions I can show my knowledge in it.
 */

public class EquipmentFinder {

  private static Finder finder;

  public static Equipment findMaxPrice(Home home) throws NullHomeLogicException {
    finder = new MaxPriceFinder();
    return finder.find(home);
  }

  public static Equipment findMinPrice(Home home) throws NullHomeLogicException {
    finder = new MinPriceFinder();
    return finder.find(home);
  }

  public static Equipment findMaxPower(Home home) throws NullHomeLogicException {
    finder = new MaxPowerFinder();
    return finder.find(home);
  }

  public static Equipment findMinPower(Home home) throws NullHomeLogicException {
    finder = new MinPowerFinder();
    return finder.find(home);
  }

  public static Equipment findNeedFirmName(Home home, String value) {
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
