package by.epam.javawebtraining.kunitski.task01.exception;

public class WrongOutputPathTechnicalException extends TechnicalException {
  public WrongOutputPathTechnicalException() {
    super();
  }

  public WrongOutputPathTechnicalException(String massage, Throwable cause) {
    super(massage, cause);
  }

  public WrongOutputPathTechnicalException(String massage) {
    super(massage);
  }

  public WrongOutputPathTechnicalException(Throwable cause) {
    super(cause);
  }
}
