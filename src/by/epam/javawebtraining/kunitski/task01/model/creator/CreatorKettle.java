package by.epam.javawebtraining.kunitski.task01.model.creator;

import by.epam.javawebtraining.kunitski.task01.model.data.Kettle;
import by.epam.javawebtraining.kunitski.task01.model.util.Parser;
import by.epam.javawebtraining.kunitski.task01.model.util.Reader;

import java.io.FileNotFoundException;
import java.util.List;


public class CreatorKettle implements AbstractCreator {
  @Override
  public Kettle create() {
    return new Kettle();
  }

  public Kettle createKettle() throws FileNotFoundException {
    List<String> listString = Reader.readFromFile(path);
    String[] arrayString = new String[listString.size()];
    for (int i = 0; i < listString.size() ; i++) {
       arrayString  = Parser.splitLine(listString.get(i)+"");

    }

    return new Kettle();
  }
}

