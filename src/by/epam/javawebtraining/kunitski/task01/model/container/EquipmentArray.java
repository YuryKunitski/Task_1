package by.epam.javawebtraining.kunitski.task01.model.container;

/**
 * Container of dynamic array
 */
//public class EquipmentArray implements EquipmentCollection<Equipment[]> {
//
//
//
//  public static final int LENGTH_DEFAULT = 0;
//  private int length;
//  private int currentIndex = 0;
//  private Equipment[] equipmentArray;
//
//  public EquipmentArray() {
//    length = LENGTH_DEFAULT;
//    equipmentArray = new Equipment[length];
//  }
//
//  public EquipmentArray(int length) {
//    this.length = length;
//    equipmentArray = new Equipment[this.length];
//  }
//
//
//  public EquipmentArray(EquipmentArray other) {
//    length = other.length;
//    currentIndex = other.currentIndex;
//    equipmentArray = Arrays.copyOf(other.equipmentArray, other.length);
//  }
//
//  @Override
//  public int size() {
//    return length;
//  }
//
//  @Override
//  public boolean isEmpty() {
//    return size() == 0;
//  }
//
//  @Override
//  public Equipment[] getEquipment() {
//    return equipmentArray;
//  }
//
//  @Override
//  public Equipment get(int index) throws WrongIndexHomeException {
//    if (index >= 0 && index < length) {
//      return equipmentArray[index];
//    } else {
//      throw new WrongIndexHomeException("Incorrect index");
//    }
//  }
//
//  @Override
//  public void set(int index, Equipment other) {
//    if (index >= 0 && index < length && other != null)
//      equipmentArray[index] = other;
//
//  }
//
//  @Override
//  public void add(Equipment otherEquipment) {
//    if (otherEquipment != null) {
//      if (currentIndex >= length) {
//        equipmentArray = Arrays.copyOf(equipmentArray, ++length);
//      }
//      equipmentArray[currentIndex] = otherEquipment;
//      currentIndex++;
//    }
//  }
//
//  @Override
//  public void remove(Equipment oldEquipment) {
//    if (oldEquipment != null) {
//
//      for (int i = 0; i < length; i++) {
//        if (equipmentArray[i].equals(oldEquipment)) {
//          fastRemove(i);
//        }
//      }
//
//    }
//  }
//
//  @Override
//  public void remove(int index) {
//    if (index >= 0 && index < length) {
//      fastRemove(index);
//    }
//  }
//
//  private void fastRemove(int index) {
//
//    int numMoved = length - index - 1;
//
//    System.arraycopy(equipmentArray, index + 1, equipmentArray, index, numMoved);
//    equipmentArray = Arrays.copyOf(equipmentArray, --length);
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    EquipmentArray homeArray = (EquipmentArray) o;
//
//    if (length != homeArray.length) return false;
//    if (currentIndex != homeArray.currentIndex) return false;
//    return Arrays.equals(equipmentArray, homeArray.equipmentArray);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = length;
//    result = 31 * result + currentIndex;
//    result = 31 * result + Arrays.hashCode(equipmentArray);
//    return result;
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder result = new StringBuilder("EquipmentArray:\n");
//    for (Equipment e : equipmentArray) {
//      result.append(String.valueOf(e)).append("\n");
//    }
//    return result.toString();
//  }
//}
//
