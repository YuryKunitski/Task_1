package by.epam.javawebtraining.kunitski.task01.model.logic;


import by.epam.javawebtraining.kunitski.task01.model.container.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class ParserHome {

  public static Equipment[] getArray(EquipmentList list) {

    if (list instanceof AbstractEquipmentArray) {
      AbstractEquipmentArray homeArray = (AbstractEquipmentArray) list;
      int size = homeArray.get().length;
      return homeArray.get();
//    } else {
//      AbstractEquipmentLinked homeLinked = (AbstractEquipmentLinked) list;
//      int size = homeLinked.get().length;
//      return homeLinked.getEquipment();
//    }
    }
    return null;
  }
}
