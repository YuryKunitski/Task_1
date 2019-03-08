package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface QueueEquipment extends CollectionEquipment {

  boolean offer(Equipment e); //paste the element into queue

  Equipment remove(); // remove the last element

  Equipment poll(); //remove the first element

  Equipment element(); // return the last element

  Equipment peek(); // return the first element

}
