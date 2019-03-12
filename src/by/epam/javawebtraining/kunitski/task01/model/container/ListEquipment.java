package by.epam.javawebtraining.kunitski.task01.model.container;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

public interface ListEquipment extends CollectionEquipment {

  Equipment getEquipment(int index);

  Equipment setEquipment(int index, Equipment e);

  boolean addEquipment(int index, Equipment e);
}
