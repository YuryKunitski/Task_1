package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.io.Serializable;

/**
 * This a universal container for collection and array.
 */
public interface EquipmentCollection<T> extends Serializable {

   T getEquipment();

  Equipment get(int index) throws WrongIndexHomeException;

  void set(int index, Equipment other);

  void add(Equipment newEquipment);

  void remove(Equipment oldEquipment);

  void remove(int index);

  int size();

  boolean isEmpty();
}
