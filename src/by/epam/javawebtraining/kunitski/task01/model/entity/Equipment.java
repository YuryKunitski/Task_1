package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongFirmNameLogicException;
import by.epam.javawebtraining.kunitski.task01.exception.WrongPowerLogicException;
import by.epam.javawebtraining.kunitski.task01.exception.WrongPriceLogicException;

/**
 * The base class of my hierarchy.
 */
public class Equipment {

  private String firmName;
  private double price;
  private int power;
  private boolean working;

  public Equipment() {
  }

  public Equipment(String firmName, double price, int power, boolean working) {

    this.firmName = firmName;
    this.price = price;
    this.power = power;
    this.working = working;
  }

  public Equipment(Equipment other) {
    firmName = other.firmName;
    price = other.price;
    power = other.power;
    working = other.working;
  }

  public String getFirmName() {
    return firmName;
  }

  public double getPrice() {
    return price;
  }

  public int getPower() {
    return power;
  }

  public boolean isWorking() {
    return working;
  }

  public void setFirmName(String firmName) throws WrongFirmNameLogicException {
    if (firmName != null) {
      this.firmName = firmName;
    } else {
      throw new WrongFirmNameLogicException("Firm's name - null");
    }
  }

  public void setPrice(double price) throws WrongPriceLogicException {
    if (price > 0) {
      this.price = price;
    } else {
      throw new WrongPriceLogicException("Incorrect value of price");
    }
  }

  public void setPower(int power) throws WrongPowerLogicException {
    if (power > 0) {
      this.power = power;
    } else {
      throw new WrongPowerLogicException("Incorrect value of power");
    }
  }

  public void setWorking(boolean working) {
    this.working = working;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Equipment equipment = (Equipment) o;

    if (Double.compare(equipment.price, price) != 0) return false;
    if (power != equipment.power) return false;
    if (working != equipment.working) return false;
    return firmName != null ? firmName.equals(equipment.firmName) : equipment.firmName == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = firmName != null ? firmName.hashCode() : 0;
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + power;
    result = 31 * result + (working ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "firmName=" + firmName + ", price=" + price + ", power=" + power
            + ", working=" + working;
  }
}
