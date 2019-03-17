package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public class EquipmentLinkedStack extends AbstractEquipmentLinked implements EquipmentStack {

  @Override
  public Equipment push(Equipment e) {
    super.add(e);
    return e;
  }

  @Override
  public Equipment pop() {

    final Node l = last;
    if (last != null) {

      Equipment e = l.item;
      Node prev = l.prev;

      l.item = null;
      l.prev = null;

      last = prev;

      if (prev == null) {
        first = null;
      } else {
        prev.next = null;
      }
      size--;

      return e;
    } else {
      return null;
    }
  }

  @Override
  public Equipment peek() {
    return last.item;
  }
}
