package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;

import java.util.Comparator;

public class ComparatorPower implements Comparator<Equipment> {

    @Override
    public int compare(Equipment o1, Equipment o2) {
      if (o1.getPower() > o2.getPower()) {
        return 1;
      } else if (o1.getPower() < o2.getPower()) {
        return -1;
      } else {
        return 0;
      }
    }
}
