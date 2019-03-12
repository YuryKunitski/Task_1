package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongMinWaterLavelLogicException;

public class Kettle extends KitchenEquipment {
  private double minWaterLevel;

  public Kettle() {
  }

  public Kettle(String firmName, double price, int power, boolean working, double volume, double minWaterLevel) {
    super(firmName, price, power, working, volume);
    this.minWaterLevel = minWaterLevel;
  }

  public Kettle(Kettle other) {
    super(other);
    minWaterLevel = other.minWaterLevel;
  }

  public double getMinWaterLevel() {
    return minWaterLevel;
  }

  public void setMinWaterLevel(double minWaterLevel) throws WrongMinWaterLavelLogicException {
    if (minWaterLevel > 0) {
      this.minWaterLevel = minWaterLevel;
    } else {
      throw new WrongMinWaterLavelLogicException("Incorrect value of minWaterLevel");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Kettle kettle = (Kettle) o;

    return Double.compare(kettle.minWaterLevel, minWaterLevel) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(minWaterLevel);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ":" + super.toString() + ", minWaterLevel=" + minWaterLevel;
  }
}
