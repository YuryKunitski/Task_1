package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.KitchenEquipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.ViewingEquipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;

/**
 * This class calculates the required values.
 */
public class Calculator {

  public static int calcSumPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        counter += e.getPower();
      }
    }
    return counter;
  }

  public static int calcWorkingPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e.isWorking()) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcKitchenPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e instanceof KitchenEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcWiewingPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        if (e instanceof ViewingEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcAllPrice(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        counter += e.getPrice();
      }
    }
    return counter;
  }
}