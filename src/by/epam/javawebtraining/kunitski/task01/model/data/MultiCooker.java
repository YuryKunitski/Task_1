package by.epam.javawebtraining.kunitski.task01.model.data;

import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

public class MultiCooker extends KitchenEquipment {
  private int numbPrograms;

  public MultiCooker() {
  }

  public MultiCooker(String firmName, double price, int power, boolean working, double volume, int numbPrograms) {
    super(firmName, price, power, working, volume);
    this.numbPrograms = numbPrograms;
  }

  public MultiCooker(MultiCooker other) {
    super(other);
    numbPrograms = other.numbPrograms;
  }

  public int getNumbPrograms() {
    return numbPrograms;
  }

  public void setNumbPrograms(int numbPrograms) throws CorrectDataMyException {
    if (numbPrograms <= 0 ){throw new CorrectDataMyException("Incorrect value of numbPrograms");
    }
    this.numbPrograms = numbPrograms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    MultiCooker that = (MultiCooker) o;

    return numbPrograms == that.numbPrograms;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + numbPrograms;
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ":"+  super.toString() + ", numbPrograms=" + numbPrograms;
  }
}
