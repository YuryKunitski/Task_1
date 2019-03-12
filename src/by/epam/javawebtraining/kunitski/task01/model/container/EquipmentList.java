package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.exception.WrongIndexHomeException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentList implements EquipmentCollection<List<Equipment>> {

  private List<Equipment> equipmentList;

  public EquipmentList() {
    equipmentList = new ArrayList<>();
  }

  public EquipmentList(List<Equipment> equipmentList) {
    this.equipmentList = equipmentList;
  }

  public EquipmentList(EquipmentList other) {
    equipmentList = other.equipmentList;
  }

  @Override
  public int size() {
    return equipmentList.size();
  }

  @Override
  public List<Equipment> getEquipment() {
    return equipmentList;
  }

  @Override
  public Equipment getEquipment(int index) throws WrongIndexHomeException {

    if (index > 0 && index <= equipmentList.size()) {
      return equipmentList.get(index);
     }else {
      throw new WrongIndexHomeException("Incorrect index");
    }
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

    EquipmentList homeList = (EquipmentList) o;

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
