package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.finder.*;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

/**
 * This class find the required equipments according to their parameters.
 * Throwing my own exceptions I can show my knowledge in it.
 */

public class EquipmentFinder {

  private static Finder finder;
  private static Printable logPrinter = new LogPrinter();

  public static Equipment findMaxPrice(Home home) throws NullHomeLogicException {
    finder = new MaxPriceFinder();
    logPrinter.print("the end of method - findMaxPrice");
    return finder.find(home);
  }

  public static Equipment findMinPrice(Home home) throws NullHomeLogicException {
    finder = new MinPriceFinder();
    logPrinter.print("the end of method - findMinPrice");
    return finder.find(home);
  }

  public static Equipment findMaxPower(Home home) throws NullHomeLogicException {
    finder = new MaxPowerFinder();
    logPrinter.print("the end of method - findMaxPower");
    return finder.find(home);
  }

  public static Equipment findMinPower(Home home) throws NullHomeLogicException {
    finder = new MinPowerFinder();
    logPrinter.print("the end of method - findMaxPower");
    return finder.find(home);
  }

  public static Equipment findFirmName(Home home, String value)  {
    finder = new FirmNameFinder();
    logPrinter.print("the end of method - findFirmName");
    return finder.findNeedValue(home, value);
  }
}