package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Kettle;
import by.epam.javawebtraining.kunitski.task01.model.util.Parser;
import by.epam.javawebtraining.kunitski.task01.model.util.Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Виктор Викторович посмотрите пожалуйста можно ли делать фабрику таким образом??
 */

public class CreatorKettle implements AbstractCreator {

  @Override
  public Kettle create() throws FileNotFoundException {
    List<String> listString = Reader.readFromFile(AbstractCreator.path);
    List<String> listArgs = new ArrayList<>();
    for (int i = 0; i < listString.size(); i++) {
      if (listString.get(i).contains("Kettle")) {
        listArgs = Parser.splitLine(listString.get(i));
      }
    }
    String arg1 = null;
    double arg2 = 0;
    int arg3 = 0;
    boolean arg4 = false;
    double arg5 = 0;
    double arg6 = 0;

    arg1 = listArgs.get(1);
    arg2 = Parser.parserDouble(listArgs.get(2));
    arg3 = Parser.parserInt(listArgs.get(3));
    arg4 = Parser.parserBoolen(listArgs.get(4));
    arg5 = Parser.parserDouble(listArgs.get(5));
    arg6 = Parser.parserDouble(listArgs.get(6));
      
    Kettle kettle = new Kettle(arg1, arg2, arg3, arg4, arg5, arg6);

    return kettle;
  }
}

