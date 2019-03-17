package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class EquipmentArrayQueue extends AbstractEquipmentArray implements EquipmentQueue {

  public EquipmentArrayQueue() {
  }

  public EquipmentArrayQueue(int initialCapacity) {
    super(initialCapacity);
  }

  public EquipmentArrayQueue(EquipmentArrayQueue other) {
    super(other);
  }

  @Override
  public boolean offer(Equipment e) { //paste the element into queue
    return super.add(e);
  }


  @Override
  public Equipment poll() {   //remove the first element

    int index = 0;

    Equipment temp = equipmentArray[index];
    super.fastRemove(index);

    return temp;
  }

  @Override
  public Equipment peek() {   //show the first element
    return equipmentArray[0];
  }
}
