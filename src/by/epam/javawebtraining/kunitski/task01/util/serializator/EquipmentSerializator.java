package by.epam.javawebtraining.kunitski.task01.util.serializator;

import by.epam.javawebtraining.kunitski.task01.model.entity.home.Home;
import by.epam.javawebtraining.kunitski.task01.view.LogPrinter;

import java.io.*;

public class EquipmentSerializator {

  public static void write(Home home, String filePath) {

    try (ObjectOutputStream writeStream = new ObjectOutputStream(
            new BufferedOutputStream(
                    new FileOutputStream(filePath)))) {

      writeStream.writeObject(home);

    } catch (IOException e) {
      LogPrinter.LOGGER.error(e);
    }
  }

  public static Home read(String filePath){

    Home home = null;

    try (ObjectInputStream readStream = new ObjectInputStream(
            new BufferedInputStream(
                    new FileInputStream(filePath)))) {

     home = (Home) readStream.readObject();

    } catch (IOException | ClassNotFoundException e) {
      LogPrinter.LOGGER.error(e);
    }
    return home;
  }
}
