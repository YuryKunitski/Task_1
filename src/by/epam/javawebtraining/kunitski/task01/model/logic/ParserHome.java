package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeArray;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeList;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;

public class ParserHome {

  /**
   * @param home This method checks the type of "home"
   * @return array from Home accordance with the necessary type.
   */
  public static Equipment[] getArray(Home home) {

    if (home instanceof HomeList) {
      HomeList homeList = (HomeList) home;
      int size = homeList.getEquipment().size();
      return homeList.getEquipment().toArray(new Equipment[size]);
    } else {
      HomeArray homeArray = (HomeArray) home;
      int size = homeArray.getEquipment().length;
      return homeArray.getEquipment();
    }
  }
}
