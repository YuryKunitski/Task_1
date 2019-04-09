package by.epam.javawebtraining.kunitski.task01.utilxml.validator;

import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXML {

  public static boolean validateXML(String fileName, String schemaName) {

    if (fileName != null && schemaName != null) {

      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      File schemaLocation = new File(schemaName);

      try {
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(fileName);
        validator.validate(source);
        LogPrinter.LOGGER.info(fileName + " is valid and may be parsed.");

        return true;

      } catch (SAXException e) {
        LogPrinter.LOGGER.error(fileName + " is not valid. " + e.getMessage());

      } catch (IOException e) {
        LogPrinter.LOGGER.error(e.getMessage() + " IOException was caught, validation was not successful");
      }
      return false;
    }
    LogPrinter.LOGGER.error("File, schema name or both were null, validation unsuccesfful");
    return false;
  }
}
