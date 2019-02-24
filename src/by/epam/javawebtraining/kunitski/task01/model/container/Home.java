package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

/**
 * This I want to create universal container for collection and array,
 * but I can not do exactly method "getEquipment()"
 */
public interface Home {

  <T> T getEquipment();

  Equipment getEquipment(int index) throws CorrectDataMyException;

  void setEquipment(int index, Equipment other);

  void addEquipment(Equipment newEquipment);

  void removeEquipment(Equipment oldEquipment);
}
