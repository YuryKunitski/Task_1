package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TypeTV.ZALA;
import static org.junit.Assert.assertEquals;

public class SortTest {

  private Home<List<Equipment>> homeActual;

  Equipment e1;
  Equipment e2;
  Equipment e3;
  Equipment e4;
  Equipment e5;

  @Before
  public void initialization() {

    homeActual = new HomeList();
    e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    e2 = new Microwave("LG", 300, 2000, false, 2, true);
    e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    e4 = new Tv("Sumsung", 100, 1800, true, 2, ZALA);
    e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    homeActual.addEquipment(e1);
    homeActual.addEquipment(e2);
    homeActual.addEquipment(e3);
    homeActual.addEquipment(e4);
    homeActual.addEquipment(e5);
  }

  @Test
  public void sortPowerEquipment() {
    Home<List<Equipment>> homeExpected = new HomeList();

    homeExpected.addEquipment(e5);
    homeExpected.addEquipment(e3);
    homeExpected.addEquipment(e4);
    homeExpected.addEquipment(e2);
    homeExpected.addEquipment(e1);

    Sort.sortPowerEquipment(homeActual);
    assertEquals(homeExpected, homeActual);
  }

  @Test
  public void sortPriceEquipment() {
    Home<List<Equipment>> homeExpected = new HomeList();

    homeExpected.addEquipment(e1);
    homeExpected.addEquipment(e4);
    homeExpected.addEquipment(e2);
    homeExpected.addEquipment(e3);
    homeExpected.addEquipment(e5);

    Sort.sortPriceEquipment(homeActual);
    assertEquals(homeExpected, homeActual);
  }

  @Test
  public void sortPricePowerEquipment() {
    Home<List<Equipment>> homeExpected = new HomeList();

    homeExpected.addEquipment(e4);
    homeExpected.addEquipment(e1);
    homeExpected.addEquipment(e2);
    homeExpected.addEquipment(e3);
    homeExpected.addEquipment(e5);

    Sort.sortPricePowerEquipment(homeActual);
    assertEquals(homeExpected, homeActual);
  }
}