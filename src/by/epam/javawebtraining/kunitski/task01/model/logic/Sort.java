package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPower;
import by.epam.javawebtraining.kunitski.task01.model.logic.comparator.ComparatorPrice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class for sort equipments.
 */

public class Sort {
  public static void sortPowerEquipment(EquipmentCollection home) {
    if (home.getEquipment() != null) {
      ComparatorPower comp = new ComparatorPower();
      if (home instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }

  public static void sortPriceEquipment(EquipmentCollection home) {
    if (home.getEquipment() != null) {
      ComparatorPrice comp = new ComparatorPrice();
      if (home instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }

  public static void sortPricePowerEquipment(EquipmentCollection home) {
    if (home.getEquipment() != null) {
      Comparator<Equipment> comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      if (home instanceof EquipmentList) {
        ((List<Equipment>) home.getEquipment()).sort(comp);
      } else {
        Arrays.sort((Equipment[]) home.getEquipment(), comp);
      }
    }
  }
}

