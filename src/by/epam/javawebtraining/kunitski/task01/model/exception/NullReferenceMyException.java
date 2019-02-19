package by.epam.javawebtraining.kunitski.task01.model.exception;

public class NullReferenceMyException extends Exception {

  public NullReferenceMyException() {
  }

  public NullReferenceMyException(String massage) {
    super(massage);
  }

  public NullReferenceMyException(String massage, Exception e) {
    super(massage, e);
  }

}
