package by.epam.javawebtraining.kunitski.task01.utilxml.parser.saxparser;

import by.epam.javawebtraining.kunitski.task01.model.entity.Equipment;
import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.utilxml.parser.AbstractParser;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class EquipmentSAXParser implements AbstractParser {
  private Set<Equipment> equipments;
  private EquipmentHandler handler;
  private XMLReader reader;

  public EquipmentSAXParser() {

    handler = new EquipmentHandler();

    try {
      reader = XMLReaderFactory.createXMLReader();
      reader.setContentHandler(handler);

    } catch (SAXException e) {
      LogPrinter.LOGGER.error("SAX error: " + e.getMessage());
    }
  }

  @Override
  public Home getHome() {
    return new Home(equipments);
  }

  @Override
  public void buildEquipmentSet(String fileName) {
    try {
      reader.parse(fileName);
    } catch (SAXException e) {
      LogPrinter.LOGGER.error("SAX error: " + e);
    } catch (IOException e) {
      LogPrinter.LOGGER.error("IO error: " + e);
    }
    equipments = handler.getEquipments();
  }

}