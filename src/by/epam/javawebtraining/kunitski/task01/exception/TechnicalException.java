package by.epam.javawebtraining.kunitski.task01.exception;

public class TechnicalException extends MainProjectException {

  public TechnicalException() {
  }

  public TechnicalException(String massage, Throwable cause) {
    super(massage, cause);
  }

  public TechnicalException(String massage) {
    super(massage);
  }

  public TechnicalException(Throwable cause) {
    super(cause);
  }

}
