package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface CollectionEquipment extends Iterable  {

  int Size();

  boolean isEmpty();

  boolean contains(Equipment e);

  Equipment[] toArray();

  boolean add(Equipment e);

  boolean remove(Equipment e);

  void clear();

  int hashCode();

  boolean equals(Object o);


}
