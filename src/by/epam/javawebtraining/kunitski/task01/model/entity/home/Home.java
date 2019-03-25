package by.epam.javawebtraining.kunitski.task01.model.entity.home;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArray;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.constants.EquipmentConsts;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;

import java.io.Serializable;

public class Home implements Serializable {

  private EquipmentCollection equipmentHomeCatalog;

  public Home() {
    equipmentHomeCatalog = new EquipmentArray();
  }

  public Home(EquipmentCollection equipmentList) {
    equipmentHomeCatalog = equipmentList;
  }

  public Home(Home other) {
    this();
    if (other != null) {
      try {
        for (int i = 0; i < other.equipmentHomeCatalog.size(); i++) {
          equipmentHomeCatalog.add(other.equipmentHomeCatalog.get(i));
        }
      } catch (WrongIndexHomeException e) {
        LogPrinter.LOGGER.error(e);
      }
    }
  }

  public int size() {
    return equipmentHomeCatalog.size();
  }


  public boolean isEmpty() {
    return equipmentHomeCatalog.isEmpty();
  }

  public void addEquipment(Equipment equipment) {
    equipmentHomeCatalog.add(equipment);
  }

  public EquipmentCollection getEquipmentHomeCatalog() {
    return equipmentHomeCatalog;
  }

  public Equipment getEquipmentHomeCatalog(int index) throws WrongIndexHomeException {
    return equipmentHomeCatalog.get(index);
  }

  public void setEquipmentHomeCatalog(int index, Equipment other) {
    equipmentHomeCatalog.set(index, other);
  }

  public void removeEquipment(Equipment oldEquipment) {
    equipmentHomeCatalog.remove(oldEquipment);
  }

  public void remove(int index) {
    equipmentHomeCatalog.remove(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Home home = (Home) o;

    return equipmentHomeCatalog != null ? equipmentHomeCatalog.equals(home.equipmentHomeCatalog) : home.equipmentHomeCatalog == null;
  }

  @Override
  public int hashCode() {
    return equipmentHomeCatalog != null ? equipmentHomeCatalog.hashCode() : 0;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(EquipmentConsts.EQUIPMENTHOMECOTALOG + ":\n");
    try {
      for (int i = 0; i < equipmentHomeCatalog.size(); i++) {
        result.append(String.valueOf(equipmentHomeCatalog.get(i))).append("\n");
      }
    } catch (WrongIndexHomeException e) {
      System.out.println(e);
      LogPrinter.LOGGER.error(e);
    }
    return result.toString();
  }
}
