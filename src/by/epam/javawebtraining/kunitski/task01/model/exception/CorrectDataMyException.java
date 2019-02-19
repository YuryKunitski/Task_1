package by.epam.javawebtraining.kunitski.task01.model.exception;

public class CorrectDataMyException extends Exception {
  public CorrectDataMyException() {
  }

  public CorrectDataMyException(String massage) {
    super(massage);
  }

  public CorrectDataMyException(String massage, Exception e) {
    super(massage, e);
  }
}
