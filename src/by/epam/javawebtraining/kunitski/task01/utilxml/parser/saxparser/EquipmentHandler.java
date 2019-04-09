package by.epam.javawebtraining.kunitski.task01.utilxml.parser.saxparser;

import by.epam.javawebtraining.kunitski.task01.exception.LogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.utilxml.equipmentenum.EquipmentEnum;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;


public class EquipmentHandler extends DefaultHandler {
  private Set<Equipment> equipments;
  private Equipment current = null;
  private EquipmentEnum currentEnum = null;
  private EnumSet<EquipmentEnum> withText;

  public EquipmentHandler() {
    equipments = new HashSet<>();
    withText = EnumSet.range(EquipmentEnum.FIRMNAME, EquipmentEnum.TVTYPE);
  }

  public Set<Equipment> getEquipments() {
    return equipments;
  }

  public void startElement(String uri, String localName, String qName, Attributes attrs) {

    EquipmentEnum temp = EquipmentEnum.valueOf(localName.toUpperCase());

    switch (temp) {
      case KETTLE:
        current = new Kettle();
        break;

      case MICROWAVE:
        current = new Microwave();
        break;

      case MULTICOOKER:
        current = new MultiCooker();
        break;

      case COMPUTER:
        current = new Computer();
        break;

      case TV:
        current = new TV();
        break;

      default:
        if (withText.contains(temp)) {
          currentEnum = temp;
        }
        break;
    }

  }

  public void endElement(String uri, String localName, String qName) {

    EquipmentEnum temp = EquipmentEnum.valueOf(localName.toUpperCase());

    switch (temp) {
      case KETTLE:
      case MICROWAVE:
      case MULTICOOKER:
      case COMPUTER:
      case TV: {
        if (current != null) {
          equipments.add(current);
        }
      }
      break;
      default: {
        if (withText.contains(temp)) {
          currentEnum = null;
        }
      }
      break;
    }
  }

  public void characters(char[] ch, int start, int length) {

    String s = new String(ch, start, length).trim();
    KitchenEquipment kitchenEquipment = null;
    ViewingEquipment viewingEquipment = null;

    if (currentEnum != null) {
      try {
        switch (currentEnum) {
          case FIRMNAME:
            current.setFirmName(s);
            break;

          case PRICE:
            current.setPrice(Double.valueOf(s));
            break;

          case POWER:
            current.setPower(Integer.valueOf(s));
            break;

          case WORKING:
            current.setWorking(Boolean.valueOf(s));
            break;

          default: {
            if (current instanceof KitchenEquipment) {
              kitchenEquipment = (KitchenEquipment) current;
              if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.VOLUME.toString()))
                kitchenEquipment.setVolume(Double.valueOf(s));
            }

            if (current instanceof ViewingEquipment) {
              viewingEquipment = (ViewingEquipment) current;
              if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.SIZEDISPLAY.toString()))
                viewingEquipment.setSizeDisplay(Integer.valueOf(s));
            }

            if (current instanceof Kettle) {
              if (kitchenEquipment != null) {
                Kettle kettle = (Kettle) kitchenEquipment;
                if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.MINWATERLEVEL.toString()))
                  kettle.setMinWaterLevel(Double.valueOf(s));
              }
            } else if (current instanceof Microwave) {
              if (kitchenEquipment != null) {
                Microwave microwave = (Microwave) kitchenEquipment;
                if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.TOUCHCONTROL.toString()))
                  microwave.setTouchControl(Boolean.valueOf(s));
              }
            } else if (current instanceof MultiCooker) {
              if (kitchenEquipment != null) {
                MultiCooker multiCooker = (MultiCooker) kitchenEquipment;
                if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.NUMBPROGRAMS.toString()))
                  multiCooker.setNumbPrograms(Integer.valueOf(s));
              }
            } else if (current instanceof Computer) {
              if (viewingEquipment != null) {
                Computer computer = (Computer) viewingEquipment;
                if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.RAM.toString()))
                  computer.setRam(Integer.valueOf(s));
              }
            } else if (current instanceof TV) {
              if (viewingEquipment != null) {
                TV tv = (TV) viewingEquipment;
                if (currentEnum.toString().equalsIgnoreCase(EquipmentEnum.TVTYPE.toString()))
                  tv.setTvType(TV.TVType.valueOf(s));
              }
            }

          }

        }
      } catch (LogicException e) {
        LogPrinter.LOGGER.error("Exception in set method"+e);
      }
      currentEnum = null;
    }
  }
}

