package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

import java.io.FileNotFoundException;

/**
 * Base interface for all creators.
 * PATH_FILE - path to the data file.
 */
public interface AbstractCreator {

  String PATH_FILE = "src//file//data.txt";

  Equipment create() throws FileNotFoundException;
}
