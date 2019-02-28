package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;
import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
  private Equipment equipmentActual;
  private String firmName = "Atlant";

  @Before
  public void initialization() {
    equipmentActual = new Equipment("LG", 1, 1, false);
  }


  @Test
  public void setFirmName() throws NullReferenceMyException {
    Equipment equipmentExpected = new Equipment("Atlant", 1, 1, false);
    equipmentActual.setFirmName("Atlant");
    assertEquals(equipmentExpected.getFirmName(), equipmentActual.getFirmName());
  }

  @Test(expected = NullReferenceMyException.class)
  public void setFirmNameByException() throws NullReferenceMyException {
    equipmentActual.setFirmName(null);
  }

  @Test
  public void setPrice() throws CorrectDataMyException {
    Equipment equipmentExpected = new Equipment("Atlant", 100, 1, false);
    equipmentActual.setPrice(100);
    assertEquals(equipmentExpected.getPrice(), equipmentActual.getPrice(), 0.0000001);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPriceByExceptionZero() throws CorrectDataMyException {
    equipmentActual.setPrice(0);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPriceByExceptionNegativ() throws CorrectDataMyException {
    equipmentActual.setPrice(-100);
  }

  @Test
  public void setPower() throws CorrectDataMyException {
    Equipment equipmentExpected = new Equipment("Atlant", 1, 100, false);
    equipmentActual.setPower(100);
    assertEquals(equipmentExpected.getPower(), equipmentActual.getPower());
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPowerByExceptionZero() throws CorrectDataMyException {
    equipmentActual.setPower(0);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPowerByExceptionNegativ() throws CorrectDataMyException {
    equipmentActual.setPower(-100);
  }

  @Test
  public void setWorking() {
    Equipment equipmentExpected = new Equipment("Atlant", 1, 100, true);
    equipmentActual.setWorking(true);
    assertEquals(equipmentExpected.isWorking(), equipmentActual.isWorking());
  }
}