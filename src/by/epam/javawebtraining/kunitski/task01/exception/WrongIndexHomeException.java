package by.epam.javawebtraining.kunitski.task01.exception;

public class WrongIndexHomeException extends LogicException{

  public WrongIndexHomeException() {
  }

  public WrongIndexHomeException(String massage) {
    super(massage);
  }
}
