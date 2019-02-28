package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class for sort equipments.
 */

public class Sort {
  public static void sortPowerEquipment(Home home) {
    if (home.getEquipment() != null) {
      ComparatorPower comp = new ComparatorPower();
      if (home instanceof HomeList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }

  public static void sortPriceEquipment(Home home) {
    if (home.getEquipment() != null) {
      ComparatorPrice comp = new ComparatorPrice();
      if (home instanceof HomeList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }

  public static void sortPricePowerEquipment(Home home) {
    if (home.getEquipment() != null) {
      Comparator<Equipment> comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      if (home instanceof HomeList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }
}

