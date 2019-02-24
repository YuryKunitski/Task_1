package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import java.util.Comparator;

/**
 * This class for sort equipments.
 */

public class Sort {
  public static void sortPowerEquipment(Home home) {
    if (home.getEquipment() != null) {
      ComparatorPower comp = new ComparatorPower();
      home.getEquipment().sort(comp);
    }
  }

  public static void sortPriceEquipment(Home home) {
    if (home.getEquipment() != null) {
      ComparatorPrice comp = new ComparatorPrice();
      home.getEquipment().sort(comp);
    }
  }

  public static void sortPricePowerEquipment(Home home) {
    if (home.getEquipment() != null) {
      Comparator<Equipment> comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      home.getEquipment().sort(comp);
    }
  }
}

