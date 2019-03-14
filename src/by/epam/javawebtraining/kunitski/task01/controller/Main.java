package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.Calculator;
import by.epam.javawebtraining.kunitski.task01.model.logic.EquipmentFinder;
import by.epam.javawebtraining.kunitski.task01.model.logic.Sort;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.view.ConsolePrinter;
import by.epam.javawebtraining.kunitski.task01.view.FilePrinter;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

public class Main {

  private static String outputPath = "data//output//output.txt";
  private static String inputPath = "data//input//data.txt";

  public static void main(String[] args) {

    Parser parser = new Parser();

    try {

      Home home = new Home(parser.totalEquipmentList(inputPath));

      Printable filePrinter = new FilePrinter(outputPath);
      Printable consolePrinter = new ConsolePrinter();
      Printable logPrinter = new LogPrinter();

      filePrinter.print(home);

      consolePrinter.print(home);

      logPrinter.print("Equipment with max power - " + EquipmentFinder.findMaxPower(home)+"\n");


      logPrinter.print("Equipment with max price - " + EquipmentFinder.findMaxPrice(home)+"\n");

      logPrinter.print("Equipment with min price - " + EquipmentFinder.findMinPrice(home)+"\n");

      logPrinter.print("Equipment with firm name: LG - " + EquipmentFinder.findFirmName(home, "LG")+"\n");

      logPrinter.print("General power - " + Calculator.calcSumPower(home)+"\n");

      Sort.sortPricePowerEquipment(home);
      consolePrinter.print("Sorted by price and power - " + home+"\n");

      Sort.sortPowerEquipment(home);
      consolePrinter.print("Sorted by only power - " + home+"\n");
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}