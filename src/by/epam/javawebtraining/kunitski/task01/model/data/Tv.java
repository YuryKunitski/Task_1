package by.epam.javawebtraining.kunitski.task01.model.data;

import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;

public class Tv extends ViewingEquipment {
  private TypeTV typeTV;

  public enum TypeTV {
    COSMOSTV, ZALA, VOKATV, BELTELECOM
  }

  public Tv() {
  }

  public Tv(String firmName, double price, int power, boolean working, int sizeDisplay, TypeTV typeTV) {
    super(firmName, price, power, working, sizeDisplay);
    this.typeTV = typeTV;
  }

  public Tv(Tv other) {
    typeTV = other.typeTV;
  }

  public TypeTV getTypeTV() {
    return typeTV;
  }

  public void setTypeTV(TypeTV typeTV) throws NullReferenceMyException {
    if (typeTV == null) {
      throw new NullReferenceMyException("Incorrect value of TypeTV");
    }
    this.typeTV = typeTV;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Tv tv = (Tv) o;

    return typeTV == tv.typeTV;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (typeTV != null ? typeTV.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + ":" + super.toString() + ", TypeTV=" + typeTV;
  }
}




