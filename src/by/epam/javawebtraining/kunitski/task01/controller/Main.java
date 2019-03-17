package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArrayStack;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentLinkedStack;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.view.ConsolePrinter;
import by.epam.javawebtraining.kunitski.task01.view.Printable;

public class Main {
  private static String outputPath = "data//output//output.txt";
  private static String inputPath = "data//input//data.txt";

  public static void main(String[] args) {
    Parser parser = new Parser();

    try {
     // EquipmentList list = new EquipmentArrayQueue();
      EquipmentList list = new EquipmentArrayStack();

      EquipmentList linkStack = new EquipmentLinkedStack();
      ((EquipmentLinkedStack) linkStack).push(new TV());
      ((EquipmentLinkedStack) linkStack).push(new Computer());
      ((EquipmentLinkedStack) linkStack).push(new MultiCooker());

      System.out.println(((EquipmentLinkedStack) linkStack).pop()+"pop");
      System.out.println(((EquipmentLinkedStack) linkStack).pop() +"pop");
      System.out.println(((EquipmentLinkedStack) linkStack).pop() +"pop");
      System.out.println(((EquipmentLinkedStack) linkStack).pop() +"pop");

       ((EquipmentArrayStack) list).push(new Kettle());
       ((EquipmentArrayStack) list).push(new Microwave());
       ((EquipmentArrayStack) list).push(new Computer());
       ((EquipmentArrayStack) list).push(new TV());

      //Home home = new Home(list);
     // Home home = new Home(parser.totalEquipmentList(inputPath));

    //  Printable printerFile = new FilePrinter(outputPath);
      Printable printerConsole = new ConsolePrinter();


      printerConsole.print(list+"\n");
      printerConsole.print(list.size()+"\n");

    //  printerConsole.print(home.toString()+"\n");

//      printerFile.print(home);
//
//      printerConsole.print(home);
//
//      printerConsole.print("Equipment with max power - " + EquipmentFinder.findMaxPower(home)+"\n");
//
//      printerConsole.print("General power - " + Calculator.calcSumPower(home)+"\n");
//
//      Sort.sortPricePowerEquipment(home);
//      printerConsole.print("Sorted by price and power - " + home+"\n");
//
//      Sort.sortPowerEquipment(home);
//      printerConsole.print("Sorted by only power - " + home+"\n");
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}