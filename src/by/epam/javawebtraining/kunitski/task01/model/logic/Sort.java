package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPower;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPrice;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class for sort equipments.
 */

public class Sort {

  private static Comparator comp;
  private static Printable logPrinter = new LogPrinter();

  public static void sortPowerEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      comp = new ComparatorPower();
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        logPrinter.print("method - sortPowerEquipment - work with ArrayList");
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        logPrinter.print("method - sortPowerEquipment - work with Array");
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }

  public static void sortPriceEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      comp = new ComparatorPrice();
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        logPrinter.print("method - sortPriceEquipment - work with ArrayList");
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        logPrinter.print("method - sortPriceEquipment - work with Array");
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }

  public static void sortPricePowerEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        logPrinter.print("method - sortPricePowerEquipment - work with ArrayList");
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        logPrinter.print("method - sortPricePowerEquipment - work with Array");
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }
}

