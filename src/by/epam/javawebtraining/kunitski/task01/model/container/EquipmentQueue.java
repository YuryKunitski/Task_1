package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface EquipmentQueue extends EquipmentCollection {

  boolean offer(Equipment e); //paste the element into queue

  Equipment poll(); //remove the first element

  Equipment peek(); // return the first element







}
