package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TVType.ZALA;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
  private EquipmentCollection home;

  @Before
  public void initialization() {
    home = new EquipmentList();
    Equipment e1 = new Kettle("LG", 100, 1000, false, 2, 0.3);
    Equipment e2 = new Microwave("LG", 100, 1000, false, 2, true);
    Equipment e3 = new MultiCooker("LG", 100, 1000, true, 2, 24);
    Equipment e4 = new Tv("LG", 100, 1000, true, 2, ZALA);
    Equipment e5 = new Computer("LG", 100, 1000, true, 2, 2048);

    home.addEquipment(e1);
    home.addEquipment(e2);
    home.addEquipment(e3);
    home.addEquipment(e4);
    home.addEquipment(e5);

  }

  @Test
  public void calcSumPower() {
    int actual = Calculator.calcSumPower(home);
    int expected = 5000;
    assertEquals(expected, actual);
  }

  @Test
  public void calcSumPowerByNull() {
    int actual = Calculator.calcSumPower(home = null);
    int expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void calcWorkingPower() {

    int actual = Calculator.calcWorkingPower(home);
    int expected = 3000;
    assertEquals(expected, actual);
  }

  @Test
  public void calcWorkingPowerByNull() {

    int actual = Calculator.calcWorkingPower(home = null);
    int expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void calcKitchenPower() {

    int actual = Calculator.calcKitchenPower(home);
    int expected = 3000;
    assertEquals(expected, actual);
  }

  @Test
  public void calcKitchenPowerByNull() {

    int actual = Calculator.calcKitchenPower(home = null);
    int expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void calcWiewingPower() {

    int actual = Calculator.calcWiewingPower(home);
    int expected = 2000;
    assertEquals(expected, actual);
  }

  @Test
  public void calcWiewingPowerByNull() {

    int actual = Calculator.calcWiewingPower(home = null);
    int expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void calcAllPrice() {

    int actual = Calculator.calcAllPrice(home);
    int expected = 500;
    assertEquals(expected, actual);
  }

  @Test
  public void calcAllPriceByNull() {

    int actual = Calculator.calcAllPrice(home = null);
    int expected = 0;
    assertEquals(expected, actual);
  }
}
