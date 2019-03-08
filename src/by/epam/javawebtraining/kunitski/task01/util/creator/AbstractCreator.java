package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;

/**
 * Base interface for all creators.
 */
public interface AbstractCreator {

  Equipment create(String dataPath) throws WrongDataPathTechnicalException;
}
