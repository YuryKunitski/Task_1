package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.entity.constants.EquipmentConsts;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.view.ConsolePrinter;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

import java.util.Locale;

public class Main {

  private static String outputPath = "data//output//output.txt";
  private static String inputPath = "data//input//data.txt";
  private static String serializPath = "data//serialization//equipment.bin";

  public static void main(String[] args) {

    Parser parser = new Parser();
    Printable consolePrinter = new ConsolePrinter();

    try {
      EquipmentCollection list = parser.totalEquipmentList(inputPath);

      Home home = new Home(list);

      EquipmentConsts.changeLocale(new Locale("ru","RU"));

      consolePrinter.print(home);

//      EquipmentSerializator.write(home ,serializPath);


//      Home home2 = new Home(home);
//
//      Printable filePrinter = new FilePrinter(outputPath);

//      consolePrinter.print(EquipmentSerializator.read(serializPath));
//      Printable logPrinter = new LogPrinter();
//
//      filePrinter.print(home);
//
//      consolePrinter.print(home+"\n");
//     consolePrinter.print(home2+"\n");
//
//      consolePrinter.print("Equals - "+home.equals(home2)+"\n");

//      logPrinter.print("Equipment with max power - " + EquipmentFinder.findMaxPower(home)+"\n");
//
//      logPrinter.print("Equipment with max price - " + EquipmentFinder.findMaxPrice(home)+"\n");
//
//      logPrinter.print("Equipment with min price - " + EquipmentFinder.findMinPrice(home)+"\n");
//
//      logPrinter.print("Equipment with firm name: LG - " + EquipmentFinder.findFirmName(home, "LG")+"\n");
//
//      logPrinter.print("General power - " + Calculator.calcSumPower(home)+"\n");
//
//      Sort.sortPricePowerEquipment(home);
//      consolePrinter.print("Sorted by price and power - " + home+"\n");
//
//      Sort.sortPowerEquipment(home);
//      consolePrinter.print("Sorted by only power - " + home+"\n");
    }
    catch (Exception e) {
      LogPrinter.LOGGER.error(e);
    }
  }
}