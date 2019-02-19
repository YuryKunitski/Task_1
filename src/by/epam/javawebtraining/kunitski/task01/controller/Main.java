package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.creator.AbstractCreator;
import by.epam.javawebtraining.kunitski.task01.model.creator.CreatorKettle;
import by.epam.javawebtraining.kunitski.task01.model.data.*;
import by.epam.javawebtraining.kunitski.task01.view.Printer;


public class Main {
  public static void main(String[] args) {
    try {


      Home home = new Home();

      AbstractCreator creator1 = new CreatorKettle();
      Equipment e1 = creator1.create();
      Printer.print(e1);
//      System.out.println(Calculator.calcWorkingPower(home.getEquipmentList()));
//      System.out.println(Calculator.calcWiewingPower(home.getEquipmentList()));
//      System.out.println(Calculator.calcKitchenPower(home.getEquipmentList()));
//      Sort.sortPowerPriceEquipment(home.getEquipmentList());
//      System.out.println(home);
//      Printer.print(Finder.findMaxPower(home));
//      Printer.print(Finder.findMinPrice(home));
//      Printer.print(Finder.findNeedFirmName(home,"LG"));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}