package by.epam.javawebtraining.kunitski.task01.exception;

public class MainEquipmentException extends Exception {

  public MainEquipmentException() {
  }

  public MainEquipmentException(String massage, Throwable cause) {
    super(massage, cause);
  }

  public MainEquipmentException(String massage) {
    super(massage);
  }

  public MainEquipmentException(Throwable cause) {
    super(cause);
  }

}


