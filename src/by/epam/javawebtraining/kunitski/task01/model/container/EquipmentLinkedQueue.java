package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class EquipmentLinkedQueue extends AbstractEquipmentLinked implements EquipmentQueue {
  @Override
  public boolean offer(Equipment e) {
    return super.add(e);
  }

  @Override
  public Equipment poll() {

    final Node f = first;
    if (first != null) {

      Equipment e = f.item;
      Node next = f.next;

      f.item = null;
      f.next = null;

      first = next;

      if (next == null) {
        last = null;
      } else {
        next.prev = null;
      }
      size--;

      return e;
    } else {
      return null;
    }
  }

  @Override
  public Equipment peek() {
    return first.item;
  }
}
