package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

/**
 * This a universal container for collection and array.
 */
public interface Home<T> {

   T getEquipment();

  Equipment getEquipment(int index) throws CorrectDataMyException;

  void setEquipment(int index, Equipment other);

  void addEquipment(Equipment newEquipment);

  void removeEquipment(Equipment oldEquipment);
}
