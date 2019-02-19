package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;

public interface AbstractCreator {
  String path = "src//file//file.txt";
  Equipment create();

////  Equipment create(String firmName, double price, int power, boolean working, int volume, double minWaterLevel);
////
////  Equipment create(String firmName, int price, int power, boolean working, double volume, boolean touchControl);
//
//  Equipment create(String firmName, int price, int power, boolean working, double volume, int numbPrograms);
//
//  Equipment create(String firmName, int price, int power, boolean working, int sizeDisplay, int ram);
//
//  Equipment create(String firmName, int price, int power, boolean working, int sizeDisplay, TypeTV typeTV);
}
