package by.epam.javawebtraining.kunitski.task01.model.data;

import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;
import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;

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

  public void setFirmName(String firmName) throws NullReferenceMyException {
    if (firmName == null) {
      throw new NullReferenceMyException("Firm's name - null");
    }
    this.firmName = firmName;
  }

  public void setPrice(double price) throws CorrectDataMyException {
    if (price <= 0) {
      throw new CorrectDataMyException("Incorrect value of price");
    }
    this.price = price;
  }

  public void setPower(int power) throws CorrectDataMyException {
    if (power <= 0) {
      throw new CorrectDataMyException("Incorrect value of power");
    }
    this.power = power;
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
