package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.creator.AbstractCreator;
import by.epam.javawebtraining.kunitski.task01.model.creator.CreatorKettle;
import by.epam.javawebtraining.kunitski.task01.model.data.*;
import by.epam.javawebtraining.kunitski.task01.model.logic.Finder;
import by.epam.javawebtraining.kunitski.task01.view.Printer;


public class Main {
  public static void main(String[] args) {
    try {
      Equipment ke1 = new Kettle("LG", 2000, 300, false, 2,
              0.3);
      Equipment ke2 = new Tv("Sony", 2000, 900, true, 42,
              null);
      Equipment ke3 = new Microwave("Sony", 500, 400, true, 42,
              true);
      Equipment ke4 = new Computer("Sony", 1000, 900, true, 42,
              1024);
      Equipment ke5 = new MultiCooker("Sony", 300, 250, true, 42,
              24);

      Home home = new Home();
      home.addEquipment(ke1);
      home.addEquipment(ke2);
      home.addEquipment(ke3);
      home.addEquipment(ke4);
      home.addEquipment(ke5);
      AbstractCreator creator1 = new CreatorKettle();
      Equipment e1 = creator1.create();
      Printer.print(e1);
//      System.out.println(Calculator.calcWorkingPower(home.getEquipmentList()));
//      System.out.println(Calculator.calcWiewingPower(home.getEquipmentList()));
//      System.out.println(Calculator.calcKitchenPower(home.getEquipmentList()));
//      Sort.sortPowerPriceEquipment(home.getEquipmentList());
//      System.out.println(home);
      Printer.print(Finder.findMaxPower(home));
      Printer.print(Finder.findMinPrice(home));
      Printer.print(Finder.findNeedFirmName(home,"LG"));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}