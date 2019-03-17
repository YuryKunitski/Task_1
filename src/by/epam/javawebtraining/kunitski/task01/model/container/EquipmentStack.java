package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface EquipmentStack extends EquipmentList { // Cloneable, Serializable, RandomAccess

  Equipment push(Equipment e); //add element to stack

  Equipment pop(); //remove element from stack

  Equipment peek(); //return last element

}
