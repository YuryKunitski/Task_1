package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

/**
 * This class find the required equipments according to their parameters.
 * Throwing my own exceptions I can show my knowledge in it.
 * Methods: findNeedPrice and findNeedPower I made public because they may be used in controller.
 */
public class Finder {
  public static Equipment findMaxPrice(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    double max = 0;

    for (Equipment e : ParserHome.getArray(home)) {
      if (e.getPrice() > max) {
        max = e.getPrice();
      }
    }
    return findNeedPrice(home, max);
  }

  public static Equipment findMinPrice(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    Equipment[] temp = ParserHome.getArray(home);
    double min = temp[0].getPrice();

    for (Equipment e : ParserHome.getArray(home)) {
      if (e.getPrice() < min) {
        min = e.getPrice();
      }
    }
    return findNeedPrice(home, min);
  }

  public static Equipment findMaxPower(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    int max = 0;

    for (Equipment e : ParserHome.getArray(home)) {
      if (e.getPower() > max) {
        max = e.getPower();
      }
    }
    return findNeedPower(home, max);
  }

  public static Equipment findMinPower(Home home) throws NullHomeLogicException {
    if (home == null) {
      throw new NullHomeLogicException();
    }
    Equipment[] temp = ParserHome.getArray(home);
    int min = temp[0].getPower();

    for (Equipment e : ParserHome.getArray(home)) {
      if (e.getPower() < min) {
        min = e.getPower();
      }
    }
    return findNeedPower(home, min);
  }

  public static Equipment findNeedPrice(Home home, double value) {
    Equipment findEquipment = null;

    if (home != null && value > 0) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e.getPrice() == value) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }

  public static Equipment findNeedPower(Home home, int value) {
    Equipment findEquipment = null;

    if (home != null && value > 0) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e.getPower() == value) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }

  public static Equipment findNeedFirmName(Home home, String value) {
    Equipment findEquipment = null;

    if (home != null && value != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e.getFirmName().equals(value)) {
          findEquipment = e;
        }
      }
    }
    return findEquipment;
  }
}
