package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface EquipmentList extends EquipmentCollection {

  Equipment get(int index);

  Equipment[] get();

  boolean add(Equipment e);

  String toString();
}
