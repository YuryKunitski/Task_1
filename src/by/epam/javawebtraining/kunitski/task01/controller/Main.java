package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeArray;
import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.logic.Calculator;
import by.epam.javawebtraining.kunitski.task01.model.logic.Finder;
import by.epam.javawebtraining.kunitski.task01.model.logic.Sort;
import by.epam.javawebtraining.kunitski.task01.util.creator.*;
import by.epam.javawebtraining.kunitski.task01.view.Printer;

public class Main {
  public static void main(String[] args) {
    try {
      Home<Equipment[]> homeList = new HomeArray();
//      Home<List<Equipment>> homeList = new HomeList();

      AbstractCreator e1 = new CreatorKettle();
      AbstractCreator e2 = new CreatorMicrowave();
      AbstractCreator e3 = new CreatorComputer();
      AbstractCreator e4 = new CreatorMultiCooker();
      AbstractCreator e5 = new CreatorTv();

      homeList.addEquipment(e1.create());
      homeList.addEquipment(e2.create());
      homeList.addEquipment(e3.create());
      homeList.addEquipment(e4.create());
      homeList.addEquipment(e5.create());

      homeList.removeEquipment(0);
      homeList.removeEquipment(e2.create());

      Printer.print(homeList+"\n");
      Printer.print("Equipment with max power - " + Finder.findMaxPower(homeList)+"\n");
      Printer.print("General power - " + Calculator.calcSumPower(homeList)+"\n");
      Sort.sortPricePowerEquipment(homeList);
      Printer.print("Sorted by price and power - " + homeList+"\n");
      Sort.sortPowerEquipment(homeList);
      Printer.print("Sorted by only power - " + homeList+"\n");
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}