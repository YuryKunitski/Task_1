package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongSizeDisplayLogicException;

/**
 * The base class for all viewing equipments.
 */
public class ViewingEquipment extends Equipment {
  private int sizeDisplay;

  public ViewingEquipment() {
  }

  public ViewingEquipment(String firmName, double price, int power, boolean working, int sizeDisplay) {
    super(firmName, price, power, working);
    this.sizeDisplay = sizeDisplay;
  }

  public ViewingEquipment(ViewingEquipment other) {
    super(other);
    sizeDisplay = other.sizeDisplay;
  }

  public int getSizeDisplay() {
    return sizeDisplay;
  }

  public void setSizeDisplay(int sizeDisplay) throws WrongSizeDisplayLogicException {
    if (sizeDisplay <= 0) {
      throw new WrongSizeDisplayLogicException("Incorrect value of sizeDisplay");
    }

    this.sizeDisplay = sizeDisplay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    ViewingEquipment that = (ViewingEquipment) o;

    return sizeDisplay == that.sizeDisplay;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + sizeDisplay;
    return result;
  }

  @Override
  public String toString() {
    return super.toString() + ", sizeDisplay=" + sizeDisplay;
  }
}
