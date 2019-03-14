package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.KitchenEquipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.ViewingEquipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

/**
 * This class calculates the required values.
 */
public class Calculator {

  private static Printable logPrinter = new LogPrinter();

  public static int calcSumPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        logPrinter.print("loop iteration in method - calcSumPower");
        counter += e.getPower();
      }
    }

    logPrinter.print("the end of method - calcSumPower");
    return counter;
  }

  public static int calcWorkingPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        logPrinter.print("loop iteration in method - calcWorkingPower");
        if (e.isWorking()) {
          counter += e.getPower();
        }
      }
    }

    logPrinter.print("the end of method - calcWorkingPower");
    return counter;
  }

  public static int calcKitchenPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        logPrinter.print("loop iteration in method - calcKitchenPower");
        if (e instanceof KitchenEquipment) {
          counter += e.getPower();
        }
      }
    }

    logPrinter.print("the end of method - calcKitchenPower");
    return counter;
  }

  public static int calcViewingPower(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        logPrinter.print("loop iteration in method - calcViewingPower");
        if (e instanceof ViewingEquipment) {
          counter += e.getPower();
        }
      }
    }

    logPrinter.print("the end of method - calcViewingPower");
    return counter;
  }

  public static int calcAllPrice(Home home) {
    int counter = 0;
    if (home != null) {
      for (Equipment e : ParserHome.getArray(home.getEquipmentHomeCatalog())) {
        logPrinter.print("loop iteration in method - calcAllPrice");
        counter += e.getPrice();
      }
    }

    logPrinter.print("the end of method - calcAllPrice");
    return counter;
  }
}