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
public interface Home<T> extends Iterable, Collection,Queue, Deque, List {

   T getEquipment();

  Equipment getEquipment(int index) throws WrongIndexHomeException;

  void setEquipment(int index, Equipment other);

  void addEquipment(Equipment newEquipment);

  void removeEquipment(Equipment oldEquipment);

  void removeEquipment(int index);
}
