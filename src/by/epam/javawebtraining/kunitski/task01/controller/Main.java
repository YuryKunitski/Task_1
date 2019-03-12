package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.Calculator;
import by.epam.javawebtraining.kunitski.task01.model.logic.EquipmentFinder;
import by.epam.javawebtraining.kunitski.task01.model.logic.Sort;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.view.ConsolePrinter;
import by.epam.javawebtraining.kunitski.task01.view.FilePrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

public class Main {
  private static String outputPath = "output//output.txt";
  private static String inputPath = "input//data.txt";

  public static void main(String[] args) {
    Parser parser = new Parser();

    try {

      Home home = new Home(parser.totalEquipmentList(inputPath));

      Printable printerFile = new FilePrinter(outputPath);
      Printable printerConsole = new ConsolePrinter();

      printerFile.print(home);

      printerConsole.print(home);

      printerConsole.print("Equipment with max power - " + EquipmentFinder.findMaxPower(home)+"\n");

      printerConsole.print("General power - " + Calculator.calcSumPower(home)+"\n");

      Sort.sortPricePowerEquipment(home);
      printerConsole.print("Sorted by price and power - " + home+"\n");

      Sort.sortPowerEquipment(home);
      printerConsole.print("Sorted by only power - " + home+"\n");
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}