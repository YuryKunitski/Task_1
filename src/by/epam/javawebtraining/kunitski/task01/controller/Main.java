package by.epam.javawebtraining.kunitski.task01.controller;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeArray;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.logic.Calculator;
import by.epam.javawebtraining.kunitski.task01.model.logic.Sort;
import by.epam.javawebtraining.kunitski.task01.util.creator.*;
import by.epam.javawebtraining.kunitski.task01.view.Printer;

public class Main {
  public static void main(String[] args) {
    try {
      Home<Equipment[]> homeList = new HomeArray();

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

      Printer.print(homeList);
      System.out.println(Calculator.calcSumPower(homeList));
      Sort.sortPricePowerEquipment(homeList);
      Printer.print(homeList);
      Sort.sortPowerEquipment(homeList);
      Printer.print(homeList);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}