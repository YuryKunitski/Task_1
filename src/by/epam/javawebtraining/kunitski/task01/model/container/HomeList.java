package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.ArrayList;
import java.util.List;

public class HomeList implements Home<List<Equipment>> {

  private List<Equipment> equipmentList;

  public HomeList() {
    equipmentList = new ArrayList<>();
  }

  public HomeList(List<Equipment> equipmentList) {
    this.equipmentList = equipmentList;
  }

  @Override
  public List<Equipment> getEquipment() {
    return equipmentList;
  }

  @Override
  public Equipment getEquipment(int index) throws WrongIndexHomeException {

    if (index < 0 || index >= equipmentList.size()) {
      throw new WrongIndexHomeException("Incorrect index");
    }
    return equipmentList.get(index);
  }

  @Override
  public void setEquipment(int index, Equipment other) {
    if (index >= 0 && index < equipmentList.size() && other != null) {
      equipmentList.set(index, other);
    }
  }

  @Override
  public void addEquipment(Equipment newEquipment) {
    if (newEquipment != null) {
      equipmentList.add(newEquipment);
    }
  }

  @Override
  public void removeEquipment(Equipment oldEquipment) {
    if (oldEquipment != null) {
      equipmentList.remove(oldEquipment);
    }
  }

  @Override
  public void removeEquipment(int index) {
    if (index >= 0) {
      equipmentList.remove(index);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    HomeList homeList = (HomeList) o;

    return equipmentList != null ? equipmentList.equals(homeList.equipmentList) : homeList.equipmentList == null;
  }

  @Override
  public int hashCode() {
    return equipmentList != null ? equipmentList.hashCode() : 0;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("EquipmentList:\n");
    for (Equipment e : equipmentList) {
      result.append(e).append("\n");
    }
    return result.toString();
  }
}
