package by.epam.javawebtraining.kunitski.task01.model.data;

import by.epam.javawebtraining.kunitski.task01.model.exception.CorrectDataMyException;

public class Computer extends ViewingEquipment {
  private int ram;

  public Computer() {
  }

  public Computer(String firmName, double price, int power, boolean working, int sizeDisplay, int ram) {
    super(firmName, price, power, working, sizeDisplay);
    this.ram = ram;
  }

  public Computer(Computer other) {
    super(other);
    ram = other.ram;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) throws CorrectDataMyException {
    if (ram <= 0) {
      throw new CorrectDataMyException("Incorrect value of ram");
    }
    this.ram = ram;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Computer computer = (Computer) o;

    return ram == computer.ram;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + ram;
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ":"+  super.toString() + ", ram=" + ram;
  }
}
