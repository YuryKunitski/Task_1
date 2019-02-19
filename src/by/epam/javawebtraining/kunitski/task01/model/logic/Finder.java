package by.epam.javawebtraining.kunitski.task01.model.logic;

import by.epam.javawebtraining.kunitski.task01.model.container.Home;
import by.epam.javawebtraining.kunitski.task01.model.data.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.exception.NullReferenceMyException;

import java.util.List;

public class Finder {
  public static Equipment findMaxPrice(Home home) throws NullReferenceMyException {
    if (home.getEquipmentList() == null) {
      throw new NullReferenceMyException();
    }
    double max = 0;
    Equipment result = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPrice() > max) {
        max = e.getPrice();
      }
    }
    result = findNeedPrice(home, max);
    return result;
  }

  public static Equipment findMinPrice(Home home) throws NullReferenceMyException {
    if (home.getEquipmentList() == null) {
      throw new NullReferenceMyException();
    }
    double min = home.getEquipmentList().get(0).getPrice();
    Equipment result = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPrice() < min) {
        min = e.getPrice();
      }
    }
    result = findNeedPrice(home, min);
    return result;
  }

  public static Equipment findMaxPower(Home home) throws NullReferenceMyException {
    if (home.getEquipmentList() == null) {
      throw new NullReferenceMyException();
    }
    int max = 0;
    Equipment result = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPower() > max) {
        max = e.getPower();
      }
    }
    result = findNeedPower(home, max);
    return result;
  }

  public static Equipment findMinPower(Home home) throws NullReferenceMyException {
    if (home.getEquipmentList() == null) {
      throw new NullReferenceMyException();
    }
    int min = home.getEquipmentList().get(0).getPower();
    Equipment result = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPower() < min) {
        min = e.getPower();
      }
    }
    result = findNeedPower(home, min);
    return result;
  }

  public static Equipment findNeedPrice(Home home, double value) {
    Equipment findEquipment = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPrice() == value) {
        findEquipment = e;
      }
    }
    return findEquipment;
  }

  public static Equipment findNeedPower(Home home, int value) {
    Equipment findEquipment = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getPower() == value) {
        findEquipment = e;
      }
    }
    return findEquipment;
  }

  public static Equipment findNeedFirmName(Home home, String value) {
    Equipment findEquipment = null;
    for (Equipment e : home.getEquipmentList()) {
      if (e.getFirmName().equals(value)) {
        findEquipment = e;
      }
    }
    return findEquipment;
  }
}
