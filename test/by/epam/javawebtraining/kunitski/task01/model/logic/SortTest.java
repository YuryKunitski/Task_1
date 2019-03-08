package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentList;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TVType.*;
import static org.junit.Assert.assertEquals;

public class SortTest {

  private EquipmentCollection<List<Equipment>> equipmentListActual;
  private EquipmentCollection<List<Equipment>> equipmentListExpected;

  Equipment e1;
  Equipment e2;
  Equipment e3;
  Equipment e4;
  Equipment e5;

  @Before
  public void initialization() {

    equipmentListActual = new EquipmentList();
    equipmentListExpected = new EquipmentList();

    e1 = new Kettle("LG", 100, 3000, false, 2, 0.3);
    e2 = new Microwave("LG", 300, 2000, false, 2, true);
    e3 = new MultiCooker("LG", 400, 1500, true, 2, 24);
    e4 = new Tv("Sumsung", 100, 1800, true, 2, ZALA);
    e5 = new Computer("LG", 1000, 500, true, 2, 2048);

    equipmentListActual.addEquipment(e1);
    equipmentListActual.addEquipment(e2);
    equipmentListActual.addEquipment(e3);
    equipmentListActual.addEquipment(e4);
    equipmentListActual.addEquipment(e5);
  }

  @Test
  public void sortPowerEquipment() {

    equipmentListExpected.addEquipment(e5);
    equipmentListExpected.addEquipment(e3);
    equipmentListExpected.addEquipment(e4);
    equipmentListExpected.addEquipment(e2);
    equipmentListExpected.addEquipment(e1);

    Sort.sortPowerEquipment(equipmentListActual);
    assertEquals(equipmentListExpected, equipmentListActual);
  }

  @Test
  public void sortPriceEquipment() {

    equipmentListExpected.addEquipment(e1);
    equipmentListExpected.addEquipment(e4);
    equipmentListExpected.addEquipment(e2);
    equipmentListExpected.addEquipment(e3);
    equipmentListExpected.addEquipment(e5);

    Sort.sortPriceEquipment(equipmentListActual);
    assertEquals(equipmentListExpected, equipmentListActual);
  }

  @Test
  public void sortPricePowerEquipment() {

    equipmentListExpected.addEquipment(e4);
    equipmentListExpected.addEquipment(e1);
    equipmentListExpected.addEquipment(e2);
    equipmentListExpected.addEquipment(e3);
    equipmentListExpected.addEquipment(e5);

    Sort.sortPricePowerEquipment(equipmentListActual);
    assertEquals(equipmentListExpected, equipmentListActual);
  }
}