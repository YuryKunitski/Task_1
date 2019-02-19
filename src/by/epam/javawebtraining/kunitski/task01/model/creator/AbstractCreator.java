package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;

import java.io.FileNotFoundException;

public interface AbstractCreator {
  String path = "src//file//data.txt";

  Equipment create() throws FileNotFoundException;
}
