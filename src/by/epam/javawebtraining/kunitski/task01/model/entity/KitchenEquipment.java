package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongVolumeLogicException;

/**
 * The base class for all kitchen equipments.
 */
public class KitchenEquipment extends Equipment {
  private double volume;

  public KitchenEquipment() {
  }

  public KitchenEquipment(String firmName, double price, int power, boolean working, double volume) {
    super(firmName, price, power, working);
    this.volume = volume;
  }

  public KitchenEquipment(KitchenEquipment other) {
    super(other);
    volume = other.volume;
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) throws WrongVolumeLogicException {
    if (volume > 0) {
      this.volume = volume;
    } else {
      throw new WrongVolumeLogicException("Incorrect value of volume");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    KitchenEquipment that = (KitchenEquipment) o;

    return Double.compare(that.volume, volume) == 0;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(volume);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return super.toString() + ", volume=" + volume;
  }
}
