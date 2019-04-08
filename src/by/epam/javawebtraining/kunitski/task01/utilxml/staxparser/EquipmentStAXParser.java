package by.epam.javawebtraining.kunitski.task01.utilxml.staxparser;

import by.epam.javawebtraining.kunitski.task01.exception.LogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.constants.EquipmentConsts;
import by.epam.javawebtraining.kunitski.task01.utilxml.equipmentenum.EquipmentEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class EquipmentStAXParser {
  private Set<Equipment> equipments;
  private XMLInputFactory inputFactory;
  private EnumSet<EquipmentEnum> equipmentEnums;


  public EquipmentStAXParser() {
    equipments = new HashSet<>();
    inputFactory = XMLInputFactory.newInstance();
    equipmentEnums = EnumSet.range(EquipmentEnum.KETTLE, EquipmentEnum.TV);
  }

  public Set<Equipment> getEquipments() {
    return equipments;
  }

  public void buildEquipmentSet(String fileName) {

    FileInputStream inputStream = null;
    XMLStreamReader reader = null;
    String name;

    try {
      inputStream = new FileInputStream(new File(fileName));
      reader = inputFactory.createXMLStreamReader(inputStream);

      while (reader.hasNext()) {
        int type = reader.next();

        if (type == XMLStreamConstants.START_ELEMENT) {
          name = reader.getLocalName();

          if (equipmentEnums.contains(EquipmentEnum.valueOf(name.toUpperCase()))) {
            Equipment equipment = buildEquipment(reader);
            equipments.add(equipment);
          }
        }
      }
    } catch (XMLStreamException ex) {
      System.out.println("StAX parsing error! " + ex);
    } catch (FileNotFoundException ex) {
      System.out.println("File " + fileName + " not found! " + ex);
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException e) {
        System.out.println("Impossible to close file " + fileName + " : " + e);
      }
    }
  }

  private Equipment buildEquipment(XMLStreamReader reader) throws XMLStreamException {

    Equipment equipment = null;
    KitchenEquipment kitchenEquipment = null;
    ViewingEquipment viewingEquipment = null;

    if (reader.getLocalName().equalsIgnoreCase(EquipmentEnum.KETTLE.toString())) {
      equipment = new Kettle();
    } else if (reader.getLocalName().equalsIgnoreCase(EquipmentEnum.MICROWAVE.toString())) {
      equipment = new Microwave();
    } else if (reader.getLocalName().equalsIgnoreCase(EquipmentEnum.MULTICOOKER.toString())) {
      equipment = new MultiCooker();
    } else if (reader.getLocalName().equalsIgnoreCase(EquipmentEnum.COMPUTER.toString())) {
      equipment = new Computer();
    } else if (reader.getLocalName().equalsIgnoreCase(EquipmentEnum.TV.toString())) {
      equipment = new TV();
    } else {
      return null;
    }

//    item.setID(reader.getAttributeValue(null, ItemEnum.MODEL.getValue()));

    String name = "";
    try {
      while (reader.hasNext()) {
        int type = reader.next();

        switch (type) {
          case XMLStreamConstants.START_ELEMENT:
            name = reader.getLocalName();

            switch (EquipmentEnum.valueOf(name.toUpperCase())) {
              case FIRMNAME:
                equipment.setFirmName(getXMLText(reader));
              break;

              case PRICE:
                equipment.setPrice(Double.parseDouble(getXMLText(reader)));
              break;

              case POWER:
                equipment.setPower(Integer.parseInt(getXMLText(reader)));
              break;

              case WORKING:
                equipment.setWorking(Boolean.parseBoolean(getXMLText(reader)));
              break;

              default:
                if (equipment instanceof KitchenEquipment) {
                  kitchenEquipment = (KitchenEquipment) equipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.VOLUME.toString())) {
                    kitchenEquipment.setVolume(Double.parseDouble(getXMLText(reader)));
                  }
                }


                if (equipment instanceof ViewingEquipment) {
                  viewingEquipment = (ViewingEquipment) equipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.SIZEDISPLAY.toString())) {
                    viewingEquipment.setSizeDisplay(Integer.parseInt(getXMLText(reader)));
                  }
                }

                if (equipment instanceof Kettle) {
                  Kettle kettle = (Kettle) kitchenEquipment;

                  if (name.equalsIgnoreCase(EquipmentEnum.MINWATERLEVEL.toString())) {
                    kettle.setMinWaterLevel(Double.parseDouble(getXMLText(reader)));
                  }

                } else if (equipment instanceof Microwave) {
                  Microwave microwave = (Microwave) kitchenEquipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.TOUCHCONTROL.toString())) {
                    microwave.setTouchControl(Boolean.parseBoolean(getXMLText(reader)));
                  }

                } else if (equipment instanceof MultiCooker) {
                  MultiCooker multiCooker = (MultiCooker) kitchenEquipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.NUMBPROGRAMS.toString())) {
                    multiCooker.setNumbPrograms(Integer.parseInt(getXMLText(reader)));
                  }
                }

                else if (equipment instanceof Computer) {
                  Computer computer = (Computer) viewingEquipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.RAM.toString())) {
                    computer.setRam(Integer.parseInt(getXMLText(reader)));
                  }
                }

                else if (equipment instanceof TV) {
                  TV tv = (TV) viewingEquipment;
                  if (name.equalsIgnoreCase(EquipmentEnum.TVTYPE.toString())) {
                    tv.setTvType(TV.TVType.valueOf(getXMLText(reader)));
                  }
                }
                break;
            }

          case XMLStreamConstants.END_ELEMENT:
            if (reader.isEndElement()) {
              name = reader.getLocalName();
              if (equipmentEnums.contains(EquipmentEnum.valueOf(name.toUpperCase()))) {
                return equipment;
              }
            }
            break;
        }
      }
    } catch (LogicException e) {
      System.out.println(e);
    }
    throw new XMLStreamException("Unknown element");

  }

  private String getXMLText(XMLStreamReader reader) throws XMLStreamException {

    String text = null;

    if (reader.hasNext()) {
      reader.next();
      text = reader.getText().trim();
    }
    return text;
  }

  public static void main(String[] args) {
    EquipmentStAXParser stAXParser = new EquipmentStAXParser();
    stAXParser.buildEquipmentSet("src//equipment_res.xml");
    for (Equipment equipment : stAXParser.getEquipments()){
      System.out.println(equipment);
    }

  }

}

