package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import org.junit.Before;
import org.junit.Test;

import static by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TVType.ZALA;
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

    homeListActual = new Home(new EquipmentList());
    homeListExpected = new Home(new EquipmentList());

    e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    e2 = new Microwave("LG", 300, 2000, false, 2, true);
    e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    e4 = new Tv("Sumsung", 100, 1800, true, 2, ZALA);
    e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    homeListActual.getEquipmentHomeCatalog().addEquipment(e1);
    homeListActual.getEquipmentHomeCatalog().addEquipment(e2);
    homeListActual.getEquipmentHomeCatalog().addEquipment(e3);
    homeListActual.getEquipmentHomeCatalog().addEquipment(e4);
    homeListActual.getEquipmentHomeCatalog().addEquipment(e5);
  }

  @Test
  public void sortPowerEquipment() {

    homeListExpected.getEquipmentHomeCatalog().addEquipment(e5);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e3);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e4);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e2);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e1);

    Sort.sortPowerEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }

  @Test
  public void sortPriceEquipment() {

    homeListExpected.getEquipmentHomeCatalog().addEquipment(e1);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e4);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e2);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e3);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e5);

    Sort.sortPriceEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }

  @Test
  public void sortPricePowerEquipment() {

    homeListExpected.getEquipmentHomeCatalog().addEquipment(e4);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e1);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e2);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e3);
    homeListExpected.getEquipmentHomeCatalog().addEquipment(e5);

    Sort.sortPricePowerEquipment(homeListActual);
    assertEquals(homeListExpected, homeListActual);
  }
}