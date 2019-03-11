package by.epam.javawebtraining.kunitski.task01.model.entity;

import by.epam.javawebtraining.kunitski.task01.exception.WrongTVTypeLogicException;

public class Tv extends ViewingEquipment {

  private TVType tvType;

  public enum TVType {
    COSMOSTV, ZALA, VOKATV, BELTELECOM
  }

  public Tv() {
  }

  public Tv(String firmName, double price, int power, boolean working, int sizeDisplay, TVType tvType) {
    super(firmName, price, power, working, sizeDisplay);
    this.tvType = tvType;
  }

  public Tv(Tv other) {
    tvType = other.tvType;
  }

  public TVType getTypeTV() {
    return tvType;
  }

  public void setTvType(TVType typeTV) throws WrongTVTypeLogicException {
    if (typeTV == null) {
      throw new WrongTVTypeLogicException("Incorrect value of TypeTV");
    }
    this.tvType = typeTV;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Tv tv = (Tv) o;

    return tvType == tv.tvType;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (tvType != null ? tvType.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ":" + super.toString()
            + ", TypeTV=" + tvType;
  }
}




