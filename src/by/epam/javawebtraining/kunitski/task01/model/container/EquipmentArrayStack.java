package by.epam.javawebtraining.kunitski.task01.model.container;


import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class EquipmentArrayStack extends AbstractEquipmentArray implements EquipmentStack {

  public EquipmentArrayStack() {
  }

  public EquipmentArrayStack(int initialCapacity) {
    super(initialCapacity);
  }

  public EquipmentArrayStack(EquipmentArrayStack other) {
    super(other);
  }

  @Override
  public Equipment push(Equipment e) {
    super.add(e);
    return e;
  }

  @Override
  public Equipment pop() {

    int index = size() - 1;

    Equipment temp = equipmentArray[index];
    super.fastRemove(index);

    return temp;
  }

  @Override
  public Equipment peek() {
    return equipmentArray[size() - 1];
  }
}
