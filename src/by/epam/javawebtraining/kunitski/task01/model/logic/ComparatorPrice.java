package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.Comparator;

/**
 * This class is required for sort Equipments according to their prices.
 */

public class ComparatorPrice implements Comparator<Equipment> {
  @Override
  public int compare(Equipment o1, Equipment o2) {
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
