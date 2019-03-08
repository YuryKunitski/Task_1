package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;
import by.epam.javawebtraining.kunitski.task01.model.entity.Tv;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.util.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Read the data from file (PATH_FILE), then split necessary line and put it in listArgs,
 * then parse each value (value is validated in class Parser!) and create required equipment.
 */
public class CreatorTv implements AbstractCreator {

  @Override
  public Tv create(String dataPath) throws WrongDataPathTechnicalException {

    List<String> listString = Reader.readFromFile(dataPath);
    List<String> listArgs = new ArrayList<>();

    for (String line : listString) {
      if (line.contains("Tv")) {
        listArgs = Parser.splitLine(line);
      }
    }
    String arg1 = listArgs.get(1);;
    double arg2 = Parser.parserDouble(listArgs.get(2));
    int arg3 = Parser.parserInt(listArgs.get(3));
    boolean arg4 = Parser.parserBoolen(listArgs.get(4));
    int arg5 = Parser.parserInt(listArgs.get(5));
    Tv.TVType arg6 = Parser.parserTvType(listArgs.get(6));

    return new Tv(arg1, arg2, arg3, arg4, arg5, arg6);
  }
}
