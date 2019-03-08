package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArray;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class ParserHome {

  /**
   * @param home This method checks the type of "home"
   * @return array from Home accordance with the necessary type.
   */
  public static Equipment[] getArray(EquipmentCollection home) {

    if (home instanceof EquipmentList) {
      EquipmentList homeList = (EquipmentList) home;
      int size = homeList.getEquipment().size();
      return homeList.getEquipment().toArray(new Equipment[size]);
    } else {
      EquipmentArray homeArray = (EquipmentArray) home;
      int size = homeArray.getEquipment().length;
      return homeArray.getEquipment();
    }
  }
}
