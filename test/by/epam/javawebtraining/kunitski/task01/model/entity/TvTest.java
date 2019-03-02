package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TypeTV;
import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;
import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TvTest {
  private Tv tvActual;

  @Before
  public void initialization() {
    tvActual = new Tv("Horizont", 1, 1, false, 1, TypeTV.BELTELECOM);
  }


  @Test
  public void setFirmName() throws NullReferenceMyException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TypeTV.ZALA);
    tvActual.setFirmName("Atlant");
    assertEquals(tvExpected.getFirmName(), tvActual.getFirmName());
  }

  @Test(expected = NullReferenceMyException.class)
  public void setFirmNameByException() throws NullReferenceMyException {
    tvActual.setFirmName(null);
  }

  @Test
  public void setPrice() throws CorrectDataMyException {
    Tv tvExpected = new Tv("Atlant", 100, 100, true, 52, TypeTV.ZALA);
    tvActual.setPrice(100);
    assertEquals(tvExpected.getPrice(), tvActual.getPrice(), 0.0000001);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPriceByExceptionZero() throws CorrectDataMyException {
    tvActual.setPrice(0);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPriceByExceptionNegativ() throws CorrectDataMyException {
    tvActual.setPrice(-100);
  }

  @Test
  public void setPower() throws CorrectDataMyException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TypeTV.ZALA);
    tvActual.setPower(100);
    assertEquals(tvExpected.getPower(), tvActual.getPower());
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPowerByExceptionZero() throws CorrectDataMyException {
    tvActual.setPower(0);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setPowerByExceptionNegativ() throws CorrectDataMyException {
    tvActual.setPower(-100);
  }

  @Test
  public void setWorking() {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TypeTV.ZALA);
    tvActual.setWorking(true);
    assertEquals(tvExpected.isWorking(), tvActual.isWorking());
  }

  @Test
  public void setSizeDisplay() throws CorrectDataMyException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 36, TypeTV.ZALA);
    tvActual.setSizeDisplay(36);
    assertEquals(tvExpected.getSizeDisplay(), tvActual.getSizeDisplay());
  }

  @Test(expected = CorrectDataMyException.class)
  public void setSizeDisplayByExceptionZero() throws CorrectDataMyException {
    tvActual.setSizeDisplay(0);
  }

  @Test(expected = CorrectDataMyException.class)
  public void setSizeDisplayByExceptionNegativ() throws CorrectDataMyException {
    tvActual.setSizeDisplay(-36);
  }

  @Test
  public void setTypeTV() throws NullReferenceMyException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 36, TypeTV.ZALA);
    tvActual.setTypeTV(TypeTV.ZALA);
    assertEquals(tvExpected.getTypeTV(), tvActual.getTypeTV());
  }

  @Test(expected = NullReferenceMyException.class)
  public void setTypeTVByException() throws NullReferenceMyException {
    tvActual.setTypeTV(null);
  }
}