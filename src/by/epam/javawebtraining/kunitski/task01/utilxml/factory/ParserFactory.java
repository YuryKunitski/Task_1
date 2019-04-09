package by.epam.javawebtraining.kunitski.task01.utilxml.factory;

import by.epam.javawebtraining.kunitski.task01.utilxml.parser.AbstractParser;
import by.epam.javawebtraining.kunitski.task01.utilxml.parser.EquipmentDOMParser;
import by.epam.javawebtraining.kunitski.task01.utilxml.parser.EquipmentStAXParser;
import by.epam.javawebtraining.kunitski.task01.utilxml.parser.saxparser.EquipmentSAXParser;

public class ParserFactory {
  private enum TypeParser {
    SAX, STAX, DOM
  }

  public AbstractParser createEquipmentParser(String typeParser) {
    TypeParser type = TypeParser.valueOf(typeParser);
    switch (type) {
      case DOM:
        return new EquipmentDOMParser();
      case STAX:
        return new EquipmentStAXParser();
      case SAX:
        return new EquipmentSAXParser();
      default:
        throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
    }
  }
}
