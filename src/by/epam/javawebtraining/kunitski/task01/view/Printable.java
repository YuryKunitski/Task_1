package by.epam.javawebtraining.kunitski.task01.view;

import by.epam.javawebtraining.kunitski.task01.exception.WrongOutputPathTechnicalException;

public interface Printable {

  void print(Object massage) throws WrongOutputPathTechnicalException;
}
