package by.epam.javawebtraining.kunitski.task01.model.entity.constants;

import java.util.Locale;
import java.util.ResourceBundle;

public class EquipmentConsts {

  private static ResourceBundle bundle;
  private static Locale locale;

  static {
    changeLocale(Locale.getDefault());
  }

  public static String EQUIPMENTHOMECOTALOG;
  public static String FIRMNAME;
  public static String PRICE;
  public static String POWER;
  public static String WORKING;
  public static String VOLUME;
  public static String SIZEDISPLAY;
  public static String MINWATERLEVEL;
  public static String TOUCHCONTROL;
  public static String NUMBPROGRAMS;
  public static String TVTYPE;
  public static String RAM;
  public static String KETTLE;
  public static String MICROWAVE;
  public static String MULTICOOKER;
  public static String COMPUTER;
  public static String TV;


  public static void changeLocale(Locale locale) {

    bundle = ResourceBundle.getBundle("localization.l10n", locale);

    EQUIPMENTHOMECOTALOG = bundle.getString("equipmentHomeCotalog");
    FIRMNAME = bundle.getString("firmName");
    PRICE = bundle.getString("price");
    POWER = bundle.getString("power");
    WORKING = bundle.getString("working");
    VOLUME = bundle.getString("volume");
    SIZEDISPLAY = bundle.getString("sizeDisplay");
    MINWATERLEVEL = bundle.getString("minWaterLevel");
    TOUCHCONTROL = bundle.getString("touchControl");
    NUMBPROGRAMS = bundle.getString("numbPrograms");
    TVTYPE = bundle.getString("tvType");
    RAM = bundle.getString("ram");
    KETTLE = bundle.getString("kettle");
    MICROWAVE = bundle.getString("microwave");
    MULTICOOKER = bundle.getString("multicooker");
    COMPUTER = bundle.getString("computer");
    TV = bundle.getString("tv");

  }


}
