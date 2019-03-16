package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * This a universal container for collection and array.
 */
public interface EquipmentCollection<T> {

   T getEquipment();

  Equipment get(int index) throws WrongIndexHomeException;

  void set(int index, Equipment other);

  void add(Equipment newEquipment);

  void remove(Equipment oldEquipment);

  void remove(int index);

  int size();

  boolean isEmpty();
}
