package by.epam.javawebtraining.kunitski.task01.exception;

public class MainProjectException extends Exception {

  public MainProjectException() {
  }

  public MainProjectException(String massage, Throwable cause) {
    super(massage, cause);
  }

  public MainProjectException(String massage) {
    super(massage);
  }

  public MainProjectException(Throwable cause) {
    super(cause);
  }

}


