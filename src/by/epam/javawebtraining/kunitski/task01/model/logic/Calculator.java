package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.KitchenEquipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.ViewingEquipment;

/**
 * This class calculates the required values.
 */
public class Calculator {

  public static int calcSumPower(EquipmentCollection home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        counter += e.getPower();
      }
    }
    return counter;
  }

  public static int calcWorkingPower(EquipmentCollection home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e.isWorking()) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcKitchenPower(EquipmentCollection home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e instanceof KitchenEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcWiewingPower(EquipmentCollection home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        if (e instanceof ViewingEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcAllPrice(EquipmentCollection home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home)) {
        counter += e.getPrice();
      }
    }
    return counter;
  }
}