package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongTVTypeLogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.constants.EquipmentConsts;

public class TV extends ViewingEquipment {

  private TVType tvType;

  public enum TVType {
    COSMOSTV, ZALA, VOKATV, BELTELECOM
  }

  public TV() {
  }

  public TV(String firmName, double price, int power, boolean working, int sizeDisplay, TVType tvType) {
    super(firmName, price, power, working, sizeDisplay);
    this.tvType = tvType;
  }

  public TV(TV other) {
    tvType = other.tvType;
  }

  public TVType getTypeTV() {
    return tvType;
  }

  public void setTvType(TVType typeTV) throws WrongTVTypeLogicException {
    if (typeTV != null) {
      this.tvType = typeTV;
    } else {
      throw new WrongTVTypeLogicException("Incorrect value of TypeTV");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    TV TV = (TV) o;

    return tvType == TV.tvType;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (tvType != null ? tvType.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return EquipmentConsts.TV + ":" + super.toString()
            + ", "+EquipmentConsts.TVTYPE +"=" + tvType;
  }
}




