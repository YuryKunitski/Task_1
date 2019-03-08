package by.epam.javawebtraining.kunitski.task01.model.logic.comparator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.Comparator;

/**
 * This class is required  for sort Equipments according to their powers.
 */
public class ComparatorPower implements Comparator<Equipment> {

  @Override
  public int compare(Equipment o1, Equipment o2) {
    return Integer.compare(o1.getPower(), o2.getPower());
  }
}
