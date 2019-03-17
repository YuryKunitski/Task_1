package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.util.Arrays;

public abstract class AbstractEquipmentArray implements EquipmentList {

  private static final int DEFAULT_CAPACITY = 0;
  private int currentIndex = 0;
  protected int size;
  protected Equipment[] equipmentArray;

  public AbstractEquipmentArray() {
    size = DEFAULT_CAPACITY;
    equipmentArray = new Equipment[DEFAULT_CAPACITY];
  }

  public AbstractEquipmentArray(int initialCapacity) {
    if (initialCapacity > 0) {
      size = initialCapacity;
      equipmentArray = new Equipment[initialCapacity];
    }
  }

  public AbstractEquipmentArray(AbstractEquipmentArray other) {
    size = other.size;
    currentIndex = other.currentIndex;
    equipmentArray = Arrays.copyOf(other.equipmentArray, other.size);
  }


  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean add(Equipment e) {
    return add(currentIndex, e);
  }

  private boolean add(int index, Equipment e) {
    if (e != null && rangeCheck(index)) {

      equipmentArray = Arrays.copyOf(equipmentArray, ++size);

      equipmentArray[index] = e;
      currentIndex++;

      return true;
    } else {
      return false;
    }
  }

  //@Override
  public Equipment[] get() {
    return equipmentArray;
  }

  public Equipment get(int index) {

    if (rangeCheck(index)) {
      return equipmentArray[index];

    } else return null;
  }

  protected void fastRemove(int index) {

    int numMoved = size - index - 1;

    System.arraycopy(equipmentArray, index + 1, equipmentArray, index, numMoved);
    equipmentArray = Arrays.copyOf(equipmentArray, --size);
  }

  private boolean rangeCheck(int index) {
    return  (index >= 0 && index <= size);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractEquipmentArray that = (AbstractEquipmentArray) o;

    if (size != that.size) return false;
    if (currentIndex != that.currentIndex) return false;
    return Arrays.equals(equipmentArray, that.equipmentArray);
  }

  @Override
  public int hashCode() {
    int result = size;
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
