package by.epam.javawebtraining.kunitski.task01.view;

public class ConsolePrinter implements Printable {

  @Override
  public void print(Object arg) {
    System.out.println(arg);
  }
}
