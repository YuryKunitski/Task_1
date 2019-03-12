package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPower;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPrice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class for sort equipments.
 */

public class Sort {

  public static void sortPowerEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      ComparatorPower comp = new ComparatorPower();
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }

  public static void sortPriceEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      ComparatorPrice comp = new ComparatorPrice();
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }

  public static void sortPricePowerEquipment(Home home) {
    if (home.getEquipmentHomeCatalog().getEquipment() != null) {
      Comparator comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      if (home.getEquipmentHomeCatalog() instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipmentHomeCatalog().getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipmentHomeCatalog().getEquipment(), comp);
      }
    }
  }
}

