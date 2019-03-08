package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TVType.ZALA;
import static org.junit.Assert.assertEquals;

public class FinderTest {
  private EquipmentCollection home;

  @Before
  public void initialization() {
    home = new EquipmentList();
    Equipment e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    Equipment e2 = new Microwave("LG", 300, 2000, false, 2, true);
    Equipment e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    Equipment e4 = new Tv("Sumsung", 2000, 1800, true, 2, ZALA);
    Equipment e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    home.addEquipment(e1);
    home.addEquipment(e2);
    home.addEquipment(e3);
    home.addEquipment(e4);
    home.addEquipment(e5);

  }

  @Test
  public void findMaxPrice() throws NullHomeLogicException {
    Equipment actual = Finder.findMaxPrice(home);
    Equipment expected = new Tv("Sumsung", 2000, 1800, true, 2, ZALA);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMaxPriceByException() throws NullHomeLogicException {
    Equipment actual = Finder.findMaxPrice(home = null);
  }

  @Test
  public void findMinPrice() throws NullHomeLogicException {
    Equipment actual = Finder.findMinPrice(home);
    Equipment expected =  new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMinPriceByNull() throws NullHomeLogicException {
    Equipment actual = Finder.findMinPrice(home = null);

  }

  @Test
  public void findMaxPower() throws NullHomeLogicException {
    Equipment actual = Finder.findMaxPower(home);
    Equipment expected = new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMaxPowerByException() throws NullHomeLogicException {
    Equipment actual = Finder.findMaxPower(home = null);
  }

  @Test
  public void findMinPower() throws NullHomeLogicException {
    Equipment actual = Finder.findMinPower(home);
    Equipment expected = new Computer("LG", 1000, 500, true, 2, 2048);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMinPowerByException() throws NullHomeLogicException {
    Equipment actual = Finder.findMinPower(home = null);
  }

  @Test
  public void findNeedPrice() {
    Equipment actual = Finder.findNeedPrice(home, 400);
    Equipment expected = new MultiCooker("LG", 400, 1500, true, 2, 24);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPriceNotFound() {
    Equipment actual = Finder.findNeedPrice(home, 40_000);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPriceByNull() {
    Equipment actual = Finder.findNeedPrice(home = null, 400);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPriceByZero() {
    Equipment actual = Finder.findNeedPrice(home, 0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPower() {
    Equipment actual = Finder.findNeedPower(home, 2000);
    Equipment expected = new Microwave("LG", 300, 2000, false, 2, true);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPowerNotFound() {
    Equipment actual = Finder.findNeedPower(home, 20_000);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPowerByNull() {
    Equipment actual = Finder.findNeedPower(home = null, 2000);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPowerByZero() {
    Equipment actual = Finder.findNeedPower(home, 0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmName() {
    Equipment actual = Finder.findNeedFirmName(home, "Sumsung");
    Equipment expected = new Tv("Sumsung", 2000, 1800, true, 2, ZALA);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedFirmNameNotFound() {
    Equipment actual = Finder.findNeedFirmName(home, "Horizont");
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmNameByHomeNull() {
    Equipment actual = Finder.findNeedFirmName(home = null, "Sumsung");
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmNameByValueNull() {
    Equipment actual = Finder.findNeedFirmName(home, null);
    assertEquals(null, actual);
  }
}