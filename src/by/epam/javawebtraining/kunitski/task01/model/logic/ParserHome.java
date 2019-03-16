package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArray;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

public class ParserHome {

  private static Printable logPrinter = new LogPrinter();

  /**
   * This method checks the type of "EquipmentCollection"
   * @return array from Home accordance with the necessary type.
   */
  public static Equipment[] getArray(EquipmentCollection list) {

    if (list instanceof EquipmentList) {
      logPrinter.print("method - getArray - work with ArrayList");
      EquipmentList homeList = (EquipmentList) list;
      int size = homeList.getEquipment().size();
      return homeList.getEquipment().toArray(new Equipment[size]);
    } else {
      logPrinter.print("method - getArray - work with Array");
      EquipmentArray homeArray = (EquipmentArray) list;
      int size = homeArray.getEquipment().length;
      return homeArray.getEquipment();
    }
  }
}
