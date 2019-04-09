package by.epam.javawebtraining.kunitski.task01.utilxml.parser;

import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;

public interface AbstractParser {

  Home getHome();

  void buildEquipmentSet(String fileName);
}
