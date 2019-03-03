package by.epam.javawebtraining.kunitski.task01.exception;

public class WrongDataPathTechnicalException extends TechnicalException {

  public WrongDataPathTechnicalException() {
  }

  public WrongDataPathTechnicalException(String massage, Throwable cause) {
    super(massage, cause);
  }

  public WrongDataPathTechnicalException(String massage) {
    super(massage);
  }

  public WrongDataPathTechnicalException(Throwable cause) {
    super(cause);
  }
}

