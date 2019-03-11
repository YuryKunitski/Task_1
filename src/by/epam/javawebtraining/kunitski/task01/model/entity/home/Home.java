package by.epam.javawebtraining.kunitski.task01.model.entity.home;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArray;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;

public class Home {

  private EquipmentCollection equipmentHomeCatalog;

  public Home(){
    equipmentHomeCatalog = new EquipmentArray();
  }

  public Home(EquipmentCollection equipmentList) {
    equipmentHomeCatalog = equipmentList;
  }

  public Home(Home other){
    if (other != null){
      equipmentHomeCatalog = other.equipmentHomeCatalog;
    }
  }

  public EquipmentCollection getEquipmentHomeCatalog() {
    return equipmentHomeCatalog;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("EquipmentHomeCatalog:\n");
    try {
      for (int i = 0; i < equipmentHomeCatalog.size(); i++) {
        result.append(String.valueOf(equipmentHomeCatalog.getEquipment(i))).append("\n");
      }
    }catch (WrongIndexHomeException e) {
      System.out.println(e);
    }
    return result.toString();
  }
}
