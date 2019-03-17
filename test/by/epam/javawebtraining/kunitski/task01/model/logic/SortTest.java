package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArrayQueue;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.entity.TV.TVType.ZALA;
import static org.junit.Assert.assertEquals;

public class SortTest {

  private Home homeListActual;
  private Home homeListExpected;

  Equipment e1;
  Equipment e2;
  Equipment e3;
  Equipment e4;
  Equipment e5;

  @Before
  public void initialization() {

    homeListActual = new Home(new EquipmentArrayQueue());
    homeListExpected = new Home(new EquipmentArrayQueue());

    e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    e2 = new Microwave("LG", 300, 2000, false, 2, true);
    e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    e4 = new TV("Sumsung", 100, 1800, true, 2, ZALA);
    e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    homeListActual.getEquipmentHomeCatalog().add(e1);
    homeListActual.getEquipmentHomeCatalog().add(e2);
    homeListActual.getEquipmentHomeCatalog().add(e3);
    homeListActual.getEquipmentHomeCatalog().add(e4);
    homeListActual.getEquipmentHomeCatalog().add(e5);
  }

  @Test
  public void sortPowerEquipment() {

    homeListExpected.getEquipmentHomeCatalog().add(e5);
    homeListExpected.getEquipmentHomeCatalog().add(e3);
    homeListExpected.getEquipmentHomeCatalog().add(e4);
    homeListExpected.getEquipmentHomeCatalog().add(e2);
    homeListExpected.getEquipmentHomeCatalog().add(e1);

    Sort.sortPowerEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }

  @Test
  public void sortPriceEquipment() {

    homeListExpected.getEquipmentHomeCatalog().add(e1);
    homeListExpected.getEquipmentHomeCatalog().add(e4);
    homeListExpected.getEquipmentHomeCatalog().add(e2);
    homeListExpected.getEquipmentHomeCatalog().add(e3);
    homeListExpected.getEquipmentHomeCatalog().add(e5);

    Sort.sortPriceEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }

  @Test
  public void sortPricePowerEquipment() {

    homeListExpected.getEquipmentHomeCatalog().add(e4);
    homeListExpected.getEquipmentHomeCatalog().add(e1);
    homeListExpected.getEquipmentHomeCatalog().add(e2);
    homeListExpected.getEquipmentHomeCatalog().add(e3);
    homeListExpected.getEquipmentHomeCatalog().add(e5);

    Sort.sortPricePowerEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }
}