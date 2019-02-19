package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

import java.util.ArrayList;
import java.util.List;

public class Home {
  private List<Equipment> equipmentList;

  public Home() {
    equipmentList = new ArrayList<>();
  }

  public Home(List<Equipment> equipmentList) {
    this.equipmentList = equipmentList;
  }

  public List<Equipment> getEquipmentList() {
    return equipmentList;
  }

  public Equipment getEquipmentList(int index) throws CorrectDataMyException {

    if (index < 0 || index >= equipmentList.size()) {
      throw new CorrectDataMyException("Incorrect index");
    }
    return equipmentList.get(index);
  }

  public void setEquipmentList(List<Equipment> equipmentList) {
    if (equipmentList != null) {
      this.equipmentList = equipmentList;
    }
  }

  public void setEquipmentList(int index, Equipment other) {
    if (index >= 0 && index < equipmentList.size() && other != null) {
      equipmentList.set(index, other);
    }
  }

  public void addEquipment(Equipment newEquipment) {
    if (newEquipment != null) {
      equipmentList.add(newEquipment);
    }
  }

  public void removeEquipment(Equipment oldEquipment) {
    if (equipmentList.contains(oldEquipment)) {
      equipmentList.remove(oldEquipment);
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("EquipmentList:\n");
    for (Equipment e : equipmentList) {
      result.append(e).append("\n");
    }
    return result + "";
  }
}
