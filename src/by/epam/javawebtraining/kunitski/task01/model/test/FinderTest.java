package by.epam.javawebtraining.kunitski.task01.model.test;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.container.HomeList;
import by.epam.javawebtraining.kunitski.task01.model.data.*;
import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;
import by.epam.javawebtraining.kunitski.task01.model.logic.Finder;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.data.Tv.TypeTV.*;
import static org.junit.Assert.*;

public class FinderTest {
  private Home home;

  @Before
  public void initialization() {
    home = new HomeList();
    Equipment e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    Equipment e2 = new Microwave("LG", 300, 2000, false, 2, true);
    Equipment e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    Equipment e4 = new Tv("Sumsung", 100, 1800, true, 2, ZALA);
    Equipment e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    home.addEquipment(e1);
    home.addEquipment(e2);
    home.addEquipment(e3);
    home.addEquipment(e4);
    home.addEquipment(e5);

  }

  @Test
  public void findMaxPrice() throws NullReferenceMyException {
    Equipment actual = Finder.findMaxPrice(home);
    Equipment expected = new Tv("LG", 100, 1800, true, 2, ZALA);
    assertEquals(expected, actual);
  }

  @Test
  public void findMinPrice() throws NullReferenceMyException {
    Equipment actual = Finder.findMinPrice(home);
    Equipment expected = new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test
  public void findMaxPower() throws NullReferenceMyException {
    Equipment actual = Finder.findMaxPower(home);
    Equipment expected = new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test
  public void findMinPower() throws NullReferenceMyException {
    Equipment actual = Finder.findMinPower(home);
    Equipment expected = new Computer("LG", 1000, 500, true, 2, 2048);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPrice() throws NullReferenceMyException {
    Equipment actual = Finder.findNeedPrice(home, 400);
    Equipment expected = new MultiCooker("LG", 400, 1500, true, 2, 24);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPower() {
    Equipment actual = Finder.findNeedPower(home, 2000);
    Equipment expected = new Microwave("LG", 300, 2000, false, 2, true);
    assertEquals(expected, actual);

  }

  @Test
  public void findNeedFirmName() {
    Equipment actual = Finder.findNeedFirmName(home, "Sumsung");
    Equipment expected = new Tv("Sumsung", 100, 1800, true, 2, ZALA);
    assertEquals(expected, actual);

  }
}