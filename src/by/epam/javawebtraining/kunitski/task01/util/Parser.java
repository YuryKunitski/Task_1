package by.epam.javawebtraining.kunitski.task01.util;

import by.epam.javawebtraining.kunitski.task01.exception.LogicException;
import by.epam.javawebtraining.kunitski.task01.exception.WrongDataPathTechnicalException;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentArray;
import by.epam.javawebtraining.kunitski.task01.model.container.EquipmentCollection;
import by.epam.javawebtraining.kunitski.task01.model.entity.*;
import by.epam.javawebtraining.kunitski.task01.util.creator.*;

public class Parser {

  private EquipmentCollection equipmentArray = new EquipmentArray();
  private AbstractCreator creator;

  public EquipmentCollection totalEquipmentList(String dataPath)
          throws WrongDataPathTechnicalException {

    try {
      String[] dataLines = Reader.readFromFile(dataPath).split("\n");
      kettleParser(dataLines);
      microwaveParser(dataLines);
      multiCookerParser(dataLines);
      computerParser(dataLines);
      tvParser(dataLines);
    } catch (LogicException e) {
      System.out.println(e);
    }

    return equipmentArray;
  }

  private void kettleParser(String[] dataLines) throws LogicException {
    String[] argumentArray = null;
    Kettle kettle = null;

    for (String s : dataLines) {
      if (s.contains("Kettle")
              && Validator.isValidKettle(argumentArray = s.split(" "))) {

        creator = new KettleCreator();

        kettle = ((KettleCreator) creator).create();

        kettle.setFirmName(argumentArray[1]);
        kettle.setPrice(Double.parseDouble(argumentArray[2]));
        kettle.setPower(Integer.parseInt(argumentArray[3]));
        kettle.setWorking(Boolean.parseBoolean(argumentArray[4]));
        kettle.setVolume(Double.parseDouble(argumentArray[5]));
        kettle.setMinWaterLevel(Double.parseDouble(argumentArray[6]));

        equipmentArray.addEquipment(kettle);
      }
    }
  }

  private void microwaveParser(String[] dataLines) throws LogicException {
    String[] argumentArray = null;
    Microwave microwave = null;

    for (String s : dataLines) {
      if (s.contains("Microwave")
              && Validator.isValidMicrowave(argumentArray = s.split(" "))) {

        creator = new MicrowaveCreator();

        microwave = ((MicrowaveCreator) creator).create();

        microwave.setFirmName(argumentArray[1]);
        microwave.setPrice(Double.parseDouble(argumentArray[2]));
        microwave.setPower(Integer.parseInt(argumentArray[3]));
        microwave.setWorking(Boolean.parseBoolean(argumentArray[4]));
        microwave.setVolume(Double.parseDouble(argumentArray[5]));
        microwave.setTouchControl(Boolean.parseBoolean(argumentArray[6]));

        equipmentArray.addEquipment(microwave);
      }
    }
  }

  private void multiCookerParser(String[] dataLines) throws LogicException {
    String[] argumentArray = null;
    MultiCooker multiCooker = null;

    for (String s : dataLines) {
      if (s.contains("MultiCooker")
              && Validator.isValidMultiCooker(argumentArray = s.split(" "))) {

        creator = new MultiCookerCreator();

        multiCooker = ((MultiCookerCreator) creator).create();

        multiCooker.setFirmName(argumentArray[1]);
        multiCooker.setPrice(Double.parseDouble(argumentArray[2]));
        multiCooker.setPower(Integer.parseInt(argumentArray[3]));
        multiCooker.setWorking(Boolean.parseBoolean(argumentArray[4]));
        multiCooker.setVolume(Double.parseDouble(argumentArray[5]));
        multiCooker.setNumbPrograms(Integer.parseInt(argumentArray[6]));

        equipmentArray.addEquipment(multiCooker);
      }
    }
  }


  private void computerParser(String[] dataLines) throws LogicException {
    String[] argumentArray = null;
    Computer computer = null;

    for (String s : dataLines) {
      if (s.contains("Computer")
              && Validator.isValidComputer(argumentArray = s.split(" "))) {

        creator = new ComputerCreator();

        computer = ((ComputerCreator) creator).create();

        computer.setFirmName(argumentArray[1]);
        computer.setPrice(Double.parseDouble(argumentArray[2]));
        computer.setPower(Integer.parseInt(argumentArray[3]));
        computer.setWorking(Boolean.parseBoolean(argumentArray[4]));
        computer.setSizeDisplay(Integer.parseInt(argumentArray[5]));
        computer.setRam(Integer.parseInt(argumentArray[6]));

        equipmentArray.addEquipment(computer);
      }
    }
  }


  private void tvParser(String[] dataLines) throws LogicException {
    String[] argumentArray = null;
    Tv tv = null;

    for (String s : dataLines) {
      if (s.contains("Tv") && Validator.isValidTv(argumentArray = s.split(" "))) {

        creator = new TvCreator();

        tv = ((TvCreator) creator).create();

        tv.setFirmName(argumentArray[1]);
        tv.setPrice(Double.parseDouble(argumentArray[2]));
        tv.setPower(Integer.parseInt(argumentArray[3]));
        tv.setWorking(Boolean.parseBoolean(argumentArray[4]));
        tv.setSizeDisplay(Integer.parseInt(argumentArray[5]));
        tv.setTvType(parserTvType(argumentArray[6]));

        equipmentArray.addEquipment(tv);
      }
    }
  }

  private Tv.TVType parserTvType(String value) {
    return Tv.TVType.valueOf(value.toUpperCase());
  }
}
