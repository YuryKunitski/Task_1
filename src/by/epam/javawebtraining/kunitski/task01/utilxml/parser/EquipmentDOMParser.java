package by.epam.javawebtraining.kunitski.task01.utilxml.parser;

import by.epam.javawebtraining.kunitski.task01.exception.LogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.utilxml.equipmentenum.EquipmentEnum;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class EquipmentDOMParser implements AbstractParser{
  private Set<Equipment> equipments;
  private DocumentBuilder docBuilder;

  public EquipmentDOMParser() {
    this.equipments = new HashSet<>();
    // create domparser-analizator
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
      docBuilder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      LogPrinter.LOGGER.error("Error configuration of parser: " + e);
    }
  }

  @Override
  public Home getHome() {
    return new Home(equipments);
  }

  @Override
  public void buildEquipmentSet(String fileName) {
    Document doc = null;
    try {
// parsing XML-document and create tree structure
      doc = docBuilder.parse(fileName);
      Element root = doc.getDocumentElement();

      //getting the list of daughter elements
      NodeList equipmentList = root.getChildNodes();

      for (int i = 0; i < equipmentList.getLength(); i++) {

        Node element = equipmentList.item(i);

        if (element instanceof Element) {
          Element equipmentElement = (Element) element;
          Equipment equipment = buildEquipment(equipmentElement);
          equipments.add(equipment);
        }
      }
    } catch (IOException e) {
      LogPrinter.LOGGER.error("File error or I/O error: " + e);
    } catch (SAXException e) {
      LogPrinter.LOGGER.error("Parsing failure: " + e);
    }
  }

  private Equipment buildEquipment(Element equipmentElement) {
    String elementName = equipmentElement.getNodeName();
    EquipmentEnum type = EquipmentEnum.valueOf(elementName.toUpperCase());
    Equipment equipment = null;
    // filling equipment object
    try {
      switch (type) {
        case KETTLE: {
          equipment = new Kettle();
          Kettle kettle = (Kettle) equipment;
          kettle.setVolume(Double.parseDouble(equipmentElement.getElementsByTagName("volume").item(0)
                  .getTextContent()));
          kettle.setMinWaterLevel(Double.parseDouble(equipmentElement.getElementsByTagName("minWaterLevel")
                  .item(0).getTextContent()));
        }
        break;
        case MICROWAVE: {
          equipment = new Microwave();
          Microwave microwave = (Microwave) equipment;
          microwave.setVolume(Double.parseDouble(equipmentElement.getElementsByTagName("volume").item(0)
                  .getTextContent()));
          microwave.setTouchControl(Boolean.parseBoolean(equipmentElement.getElementsByTagName("touchControl")
                  .item(0).getTextContent()));
        }
        break;
        case MULTICOOKER: {
          equipment = new MultiCooker();
          MultiCooker multiCooker = (MultiCooker) equipment;
          multiCooker.setVolume(Double.parseDouble(equipmentElement.getElementsByTagName("volume").item(0)
                  .getTextContent()));
          multiCooker.setNumbPrograms(Integer.parseInt(equipmentElement.getElementsByTagName("numbPrograms")
                  .item(0).getTextContent()));
        }
        break;
        case COMPUTER: {
          equipment = new Computer();
          Computer computer = (Computer) equipment;
          computer.setSizeDisplay(Integer.parseInt(equipmentElement.getElementsByTagName("sizeDisplay").item(0)
                  .getTextContent()));
          computer.setRam(Integer.parseInt(equipmentElement.getElementsByTagName("ram").item(0)
                  .getTextContent()));
        }
        break;
        case TV: {
          equipment = new TV();
          TV tv = (TV) equipment;
          tv.setSizeDisplay(Integer.parseInt(equipmentElement.getElementsByTagName("sizeDisplay").item(0)
                  .getTextContent()));
          tv.setTvType(TV.TVType.valueOf(equipmentElement.getElementsByTagName("tvType").item(0)
                  .getTextContent()));
        }
        break;
        default: {
          equipment = null;
        }
      }

      if (equipment != null) {
        equipment.setFirmName(equipmentElement.getElementsByTagName("firmName").item(0).getTextContent());
        equipment.setPrice(Double.parseDouble(equipmentElement.getElementsByTagName("price").item(0)
                .getTextContent()));
        equipment.setPower(Integer.parseInt(equipmentElement.getElementsByTagName("power").item(0)
                .getTextContent()));
        equipment.setWorking(Boolean.parseBoolean(equipmentElement.getElementsByTagName("price").item(0)
                .getTextContent()));
      }

    } catch (LogicException e) {
      LogPrinter.LOGGER.error("Exception in set method" + e);
    }

    return equipment;
  }

}


