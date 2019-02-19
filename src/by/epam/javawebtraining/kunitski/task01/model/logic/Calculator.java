package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.data.KitchenEquipment;
import by.epam.javawebtraining.kunitski.task01.model.data.ViewingEquipment;

public class Calculator {

  public static int calcSumPower(Home home) {
    int counter = 0;
    if (home.getEquipmentList() != null) {
      for (Equipment e : home.getEquipmentList()) {
        counter += e.getPower();
      }
    }
    return counter;
  }

  public static int calcWorkingPower(Home home) {
    int counter = 0;
    if (home.getEquipmentList() != null) {
      for (Equipment e : home.getEquipmentList()) {
        if (e.isWorking()) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcKitchenPower(Home home) {
    int counter = 0;
    if (home.getEquipmentList() != null) {
      for (Equipment e : home.getEquipmentList()) {
        if (e instanceof KitchenEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int calcWiewingPower(Home home) {
    int counter = 0;
    if (home.getEquipmentList() != null) {
      for (Equipment e : home.getEquipmentList()) {
        if (e instanceof ViewingEquipment) {
          counter += e.getPower();
        }
      }
    }
    return counter;
  }

  public static int allPrice(Home home) {
    int counter = 0;
    if (home.getEquipmentList() != null) {
      for (Equipment e : home.getEquipmentList()) {
        counter += e.getPrice();
      }
    }
    return counter;
  }
}