package by.epam.javawebtraining.kunitski.task01.exception;

public class WrongPriceLogicException extends LogicException {

  public WrongPriceLogicException() {
  }

  public WrongPriceLogicException(String massage) {
    super(massage);
  }
}
