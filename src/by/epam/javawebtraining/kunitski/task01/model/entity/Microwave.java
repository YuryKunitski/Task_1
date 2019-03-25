package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.model.entity.constants.EquipmentConsts;

public class Microwave extends KitchenEquipment {
  private boolean touchControl;

  public Microwave() {
  }

  public Microwave(String firmName, double price, int power, boolean working, double volume,
                   boolean touchControl) {
    super(firmName, price, power, working, volume);
    this.touchControl = touchControl;
  }

  public Microwave(Microwave other) {
    super(other);
    touchControl = other.touchControl;
  }

  public boolean isTouchControl() {
    return touchControl;
  }

  public void setTouchControl(boolean touchControl) {
    this.touchControl = touchControl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Microwave microwave = (Microwave) o;

    return touchControl == microwave.touchControl;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (touchControl ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return EquipmentConsts.MICROWAVE + ":" + super.toString()
            + ", "+EquipmentConsts.TOUCHCONTROL +"=" + touchControl;
  }
}
