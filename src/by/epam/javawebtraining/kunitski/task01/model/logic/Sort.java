package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import java.util.Comparator;


public class Sort {
  public static void sortPowerEquipment(Home home) {
    if (home.getEquipmentList() != null) {
      ComparatorPower comp = new ComparatorPower();
      home.getEquipmentList().sort(comp);
    }
  }

  public static void sortPriceEquipment(Home home) {
    if (home.getEquipmentList() != null) {
      ComparatorPrice comp = new ComparatorPrice();
      home.getEquipmentList().sort(comp);
    }
  }

  public static void sortPowerPriceEquipment(Home home) {
    if (home.getEquipmentList() != null) {
      Comparator<Equipment> comp = new ComparatorPrice().thenComparing(new ComparatorPower());
      home.getEquipmentList().sort(comp);
    }
  }
}

