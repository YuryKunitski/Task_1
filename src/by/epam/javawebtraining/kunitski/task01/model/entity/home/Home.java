package by.epam.javawebtraining.kunitski.task01.model.entity.home;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArrayQueue;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;

public class Home {

  private EquipmentList equipmentHomeCatalog;

  public Home(){
    equipmentHomeCatalog = new EquipmentArrayQueue(); ////////////////////////
  }

  public Home(EquipmentList equipmentList) {
    equipmentHomeCatalog = equipmentList;
  }

  public Home(Home other){
    if (other != null){
      equipmentHomeCatalog = other.equipmentHomeCatalog;
    }
  }
//
//  public void addEquipment(Equipment e){
//    equipmentHomeCatalog.add(e);
//  }

  public EquipmentList getEquipmentHomeCatalog() {
    return equipmentHomeCatalog;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("EquipmentHomeCatalog:\n");
//    try {
      for (int i = 0; i < equipmentHomeCatalog.size(); i++) {
        result.append(String.valueOf(equipmentHomeCatalog.get(i))).append("\n");
      }
//    }catch (WrongIndexHomeException e) {
//      System.out.println(e);
//    }
    return result.toString();
  }
}
