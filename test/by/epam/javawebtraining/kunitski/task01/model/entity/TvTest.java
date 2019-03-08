package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.Tv.TVType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TvTest {
  private Tv tvActual;

  @Before
  public void initialization() {
    tvActual = new Tv("Horizont", 1, 1, false,
            1, TVType.BELTELECOM);
  }


  @Test
  public void setFirmName() throws WrongFirmNameLogicException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TVType.ZALA);
    tvActual.setFirmName("Atlant");
    assertEquals(tvExpected.getFirmName(), tvActual.getFirmName());
  }

  @Test(expected = WrongFirmNameLogicException.class)
  public void setFirmNameByException() throws WrongFirmNameLogicException {
    tvActual.setFirmName(null);
  }

  @Test
  public void setPrice() throws WrongPriceLogicException {
    Tv tvExpected = new Tv("Atlant", 100, 100, true, 52, TVType.ZALA);
    tvActual.setPrice(100);
    assertEquals(tvExpected.getPrice(), tvActual.getPrice(), 0.0000001);
  }

  @Test(expected = WrongPriceLogicException.class)
  public void setPriceByExceptionZero() throws WrongPriceLogicException {
    tvActual.setPrice(0);
  }

  @Test(expected = WrongPriceLogicException.class)
  public void setPriceByExceptionNegativ() throws WrongPriceLogicException {
    tvActual.setPrice(-100);
  }

  @Test
  public void setPower() throws WrongPowerLogicException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TVType.ZALA);
    tvActual.setPower(100);
    assertEquals(tvExpected.getPower(), tvActual.getPower());
  }

  @Test(expected = WrongPowerLogicException.class)
  public void setPowerByExceptionZero() throws WrongPowerLogicException {
    tvActual.setPower(0);
  }

  @Test(expected = WrongPowerLogicException.class)
  public void setPowerByExceptionNegativ() throws WrongPowerLogicException {
    tvActual.setPower(-100);
  }

  @Test
  public void setWorking() {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 52, TVType.ZALA);
    tvActual.setWorking(true);
    assertEquals(tvExpected.isWorking(), tvActual.isWorking());
  }

  @Test
  public void setSizeDisplay() throws WrongSizeDisplayLogicException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 36, TVType.ZALA);
    tvActual.setSizeDisplay(36);
    assertEquals(tvExpected.getSizeDisplay(), tvActual.getSizeDisplay());
  }

  @Test(expected = WrongSizeDisplayLogicException.class)
  public void setSizeDisplayByExceptionZero() throws WrongSizeDisplayLogicException {
    tvActual.setSizeDisplay(0);
  }

  @Test(expected = WrongSizeDisplayLogicException.class)
  public void setSizeDisplayByExceptionNegativ() throws WrongSizeDisplayLogicException {
    tvActual.setSizeDisplay(-36);
  }

  @Test
  public void setTypeTV() throws WrongTVTypeLogicException {
    Tv tvExpected = new Tv("Atlant", 1, 100, true, 36, TVType.ZALA);
    tvActual.setTvType(TVType.ZALA);
    assertEquals(tvExpected.getTypeTV(), tvActual.getTypeTV());
  }

  @Test(expected = WrongTVTypeLogicException.class)
  public void setTypeTVByException() throws WrongTVTypeLogicException {
    tvActual.setTvType(null);
  }
}