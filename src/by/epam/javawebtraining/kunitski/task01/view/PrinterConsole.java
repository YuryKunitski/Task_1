package by.epam.javawebtraining.kunitski.task01.view;

public class PrinterConsole implements Printable {

  @Override
  public void print(Object arg) {
    System.out.println(arg);
  }
}
