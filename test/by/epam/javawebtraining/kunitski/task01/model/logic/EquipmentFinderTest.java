package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.exception.NullHomeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArrayQueue;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.model.logic.finder.*;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.entity.TV.TVType.ZALA;
import static org.junit.Assert.assertEquals;

public class EquipmentFinderTest {

  private Home home;
  private PriseFinder priseFinder = new MaxPriceFinder();
  private PowerFinder powerFinder = new MaxPowerFinder();

  @Before
  public void initialization() {

    home = new Home(new EquipmentArrayQueue());

    Equipment e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    Equipment e2 = new Microwave("LG", 300, 2000, false, 2, true);
    Equipment e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    Equipment e4 = new TV("Sumsung", 2000, 1800, true, 2, ZALA);
    Equipment e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    home.getEquipmentHomeCatalog().add(e1);
    home.getEquipmentHomeCatalog().add(e2);
    home.getEquipmentHomeCatalog().add(e3);
    home.getEquipmentHomeCatalog().add(e4);
    home.getEquipmentHomeCatalog().add(e5);

  }

  @Test
  public void findMaxPrice() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMaxPrice(home);
    Equipment expected = new TV("Sumsung", 2000, 1800, true, 2, ZALA);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMaxPriceByException() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMaxPrice(home = null);
  }

  @Test
  public void findMinPrice() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMinPrice(home);
    Equipment expected =  new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMinPriceByNull() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMinPrice(home = null);

  }

  @Test
  public void findMaxPower() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMaxPower(home);
    Equipment expected = new Kettle("LG", 100, 3000, false, 2, 0.3);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMaxPowerByException() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMaxPower(home = null);
  }

  @Test
  public void findMinPower() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMinPower(home);
    Equipment expected = new Computer("LG", 1000, 500, true, 2, 2048);
    assertEquals(expected, actual);
  }

  @Test(expected = NullHomeLogicException.class)
  public void findMinPowerByException() throws NullHomeLogicException {
    Equipment actual = EquipmentFinder.findMinPower(home = null);
  }

  @Test
  public void findNeedPrice() {
    Equipment actual = priseFinder.findNeedValue(home, 400.0);
    Equipment expected = new MultiCooker("LG", 400.0, 1500, true, 2, 24);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPriceNotFound() {
    priseFinder = new  MinPriceFinder();
    Equipment actual = priseFinder.findNeedValue(home, 40_000.0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPriceByNull() {
    Equipment actual = priseFinder.findNeedValue(home = null, 400.0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPriceByZero() {
    Equipment actual = priseFinder.findNeedValue(home, 0.0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPower() {
    Equipment actual = powerFinder.findNeedValue(home, 2000);
    Equipment expected = new Microwave("LG", 300, 2000, false, 2, true);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedPowerNotFound() {
    Equipment actual = powerFinder.findNeedValue(home, 20_000);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPowerByNull() {
    Equipment actual = powerFinder.findNeedValue(home = null, 2000);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedPowerByZero() {
    Equipment actual = powerFinder.findNeedValue(home, 0);
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmName() {
    Equipment actual = EquipmentFinder.findFirmName(home, "Sumsung");
    Equipment expected = new TV("Sumsung", 2000, 1800, true, 2, ZALA);
    assertEquals(expected, actual);
  }

  @Test
  public void findNeedFirmNameNotFound() {
    Equipment actual = EquipmentFinder.findFirmName(home, "Horizont");
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmNameByHomeNull() {
    Equipment actual = EquipmentFinder.findFirmName(home = null, "Sumsung");
    assertEquals(null, actual);
  }

  @Test
  public void findNeedFirmNameByValueNull() {
    Equipment actual = EquipmentFinder.findFirmName(home, null);
    assertEquals(null, actual);
  }
}