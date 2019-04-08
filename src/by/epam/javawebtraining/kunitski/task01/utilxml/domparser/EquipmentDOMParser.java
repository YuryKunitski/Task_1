package by.epam.javawebtraining.kunitski.task01.utilxml.domparser;

import by.epam.javawebtraining.kunitski.task01.exception.LogicException;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.utilxml.equipmentenum.EquipmentEnum;
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

public class EquipmentDOMParser {
  private Set<Equipment> equipments;
  private DocumentBuilder docBuilder;

  public EquipmentDOMParser() {
    this.equipments = new HashSet<>();
    // создание domparser-анализатора
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
      docBuilder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      System.err.println("Error configuration of parser: " + e);
    }
  }

  public Set<Equipment> getEquipments() {
    return equipments;
  }

  public void buildSetEquipments(String fileName) {
    Document doc = null;
    try {
// parsing XML-документа и создание древовидной структуры
      doc = docBuilder.parse(fileName);
      Element root = doc.getDocumentElement();
      // получение списка дочерних элементов <student>
      NodeList equipmentList = root.getChildNodes(); ///?

      for (int i = 0; i < equipmentList.getLength(); i++) {

        Node element = equipmentList.item(i);

        if (element instanceof Element) {
          Element equipmentElement = (Element) element;
          Equipment equipment = buildEquipment(equipmentElement);
          equipments.add(equipment);
        }
      }
    } catch (IOException e) {
      System.err.println("File error or I/O error: " + e);
    } catch (SAXException e) {
      System.err.println("Parsing failure: " + e);
    }
  }

  private Equipment buildEquipment(Element equipmentElement) {
    String elementName = equipmentElement.getNodeName();
    EquipmentEnum type = EquipmentEnum.valueOf(elementName.toUpperCase());
    Equipment equipment = null;
    // заполнение объекта equipment
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
      System.out.println(e);
    }

    return equipment;
  }

  public static void main(String[] args) {
    Set<Equipment> equipments = new HashSet<>();
    EquipmentDOMParser domBuilder = new EquipmentDOMParser();
    domBuilder.buildSetEquipments("src//equipment_res.xml");
    for (Equipment equipment : domBuilder.getEquipments()){
      System.out.println(equipment);
    }
  }
}


