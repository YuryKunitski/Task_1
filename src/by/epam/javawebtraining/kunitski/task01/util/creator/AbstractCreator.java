package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

/**
 * Base interface for all creators.
 * PATH_FILE - path to the data file.
 */
public interface AbstractCreator {

  String DATA_PATH = "src//file//data.txt";

  Equipment create() throws WrongDataPathTechnicalException;
}
