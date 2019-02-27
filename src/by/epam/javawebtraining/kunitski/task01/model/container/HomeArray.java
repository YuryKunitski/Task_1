package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

import java.util.Arrays;

public class HomeArray implements Home<Equipment[]> {

  public static final int LENGTH_DEFOULT = 5;
  private int length;
  private int currentIndex = 0;
  private Equipment[] equipmentArray;

  public HomeArray() {
    length = LENGTH_DEFOULT;
    equipmentArray = new Equipment[length];
  }

  public HomeArray(int length) {
    this.length = length;
    equipmentArray = new Equipment[this.length];
  }

  public int getLength() {
    return length;
  }

  @Override
  public Equipment[] getEquipment() {
    return equipmentArray;
  }

  @Override
  public Equipment getEquipment(int index) throws CorrectDataMyException {
    if (index < 0 || index >= length) {
      throw new CorrectDataMyException("Incorrect index");
    }
    return equipmentArray[index];
  }

  @Override
  public void setEquipment(int index, Equipment other) {
    if (index >= 0 && index < length && other != null)
      equipmentArray[index] = other;

  }

  @Override
  public void addEquipment(Equipment newEquipment) {
    if (newEquipment != null && currentIndex >= 0 && currentIndex < length) {
      equipmentArray[currentIndex] = newEquipment;
      currentIndex++;
    }
  }

  @Override
  public void removeEquipment(Equipment oldEquipment) {
    if (oldEquipment != null) {
      for (int i = 0; i < length; i++) {
        if (oldEquipment.equals(equipmentArray[i])) {
          equipmentArray[i] = null;
        }
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    HomeArray homeArray = (HomeArray) o;

    if (length != homeArray.length) return false;
    if (currentIndex != homeArray.currentIndex) return false;
    return Arrays.equals(equipmentArray, homeArray.equipmentArray);
  }

  @Override
  public int hashCode() {
    int result = length;
    result = 31 * result + currentIndex;
    result = 31 * result + Arrays.hashCode(equipmentArray);
    return result;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("EquipmentArray:\n");
    for (Equipment e : equipmentArray) {
      result.append(String.valueOf(e)).append("\n");
    }
    return result.toString();
  }
}

