package by.epam.javawebtraining.kunitski.task01.util.creator;

import by.epam.javawebtraining.kunitski.task01.model.entity.Tv;
import by.epam.javawebtraining.kunitski.task01.util.Parser;
import by.epam.javawebtraining.kunitski.task01.util.Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read the data from file (PATH_FILE), next split necessary line and put it in listArgs,
 * next parse each value (value is validated in class Parser!) and create required equipment.
 */
public class CreatorTv implements AbstractCreator {

  @Override
  public Tv create() throws FileNotFoundException {

    List<String> listString = Reader.readFromFile(AbstractCreator.PATH_FILE);
    List<String> listArgs = new ArrayList<>();

    for (String line : listString) {
      if (line.contains("Tv")) {
        listArgs = Parser.splitLine(line);
      }
    }
    String arg1 = null;
    double arg2 = 0;
    int arg3 = 0;
    boolean arg4 = false;
    int arg5 = 0;
    Tv.TypeTV arg6 = null;

    arg1 = listArgs.get(1);
    arg2 = Parser.parserDouble(listArgs.get(2));
    arg3 = Parser.parserInt(listArgs.get(3));
    arg4 = Parser.parserBoolen(listArgs.get(4));
    arg5 = Parser.parserInt(listArgs.get(5));
    arg6 = Parser.parserTypeTv(listArgs.get(6));

    return new Tv(arg1, arg2, arg3, arg4, arg5, arg6);
  }
}