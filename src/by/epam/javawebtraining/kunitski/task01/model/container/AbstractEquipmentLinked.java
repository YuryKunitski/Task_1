package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public abstract class AbstractEquipmentLinked implements EquipmentList {

  protected int size;
  protected Node first;
  protected Node last;


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
    if (e != null) {
      final Node l = last;
      final Node newNode = new Node(l, e, null);

      last = newNode;

      if (l != null) {
        l.next = newNode;

      } else {
        first = newNode;
      }
      size++;

      return true;

    } else {
      return false;
    }
  }

  @Override
  public Equipment[] get() {  ///////
    return new Equipment[0];
  }

  @Override
  public Equipment get(int index) { ///////
    return null;
  }


  protected static class Node {
    Equipment item;
    Node next;
    Node prev;

    public Node(Node prev, Equipment element, Node next) {
      this.prev = prev;
      this.item = element;
      this.next = next;
    }
  }
}
