package utility;

import data.*;
import exceptions.InvalidInputException;
import inputOutput.TerminalOutputManager;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utility.CSVWriter.FILE_HEADER;

/**
 * В коллекцию будут добавлены только те объекты, у которых все поля имеют корректные значения.
 * В случае наличия данных, которые нельзя обработать, объект пропускается и не добавляется в коллекцию.
 * @since 1.2
 */
public class CSVReader {

    public Vector<Worker> readCollectionFromFile(String fileName) throws IOException {
        Vector<Worker> workersVector = new Vector<>();
        if (!fileName.isEmpty()) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                String line;
                if ((reader.readLine() + "\n").equals(FILE_HEADER)) {
                    while ((line = reader.readLine()) != null) {
                        String[] properties = line.split("\t"); // Assuming tab symbol as the delimiter
                        Worker result = new Worker();
                        try {
                            if (ValuesValidator.validateWorkerId(properties[0])) {
                                result.setId(Long.parseLong(properties[0]));
                            } else {
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        }
                        try {
                            if (ValuesValidator.validateWorkerName(properties[1])) {
                                result.setName(properties[1]);
                            } else {
                                continue;
                            }
                        } catch (NullPointerException e) {
                            continue;
                        }
                        try {
                            if (ValuesValidator.validateWorkerCoordinateX(properties[2])
                                    && ValuesValidator.validateWorkerCoordinateY(properties[3])) {
                                result.setCoordinates(new Coordinates(
                                        new Coordinates.CoordinatesBuilder(Long.parseLong(properties[2]),
                                                Long.parseLong(properties[3]))));
                            } else {
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        }
                        try {
                            result.setCreationDate(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                                    Locale.ENGLISH).parse(properties[4]));
                        } catch (ParseException e) {
                            continue;
                        }
                        try {
                            if (ValuesValidator.validateWorkerSalary(properties[5])) {
                                result.setSalary(Long.parseLong(properties[5]));
                            } else {
                                continue;
                            }
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        try {
                            if (ValuesValidator.validateWorkerPosition(properties[6])) {
                                result.setPosition(Position.valueOf(properties[6]));
                            } else {
                                continue;
                            }
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        try {
                            if (ValuesValidator.validateWorkerStatus(properties[7])) {
                                result.setStatus(Status.valueOf(properties[7]));
                            } else {
                                continue;
                            }
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        try {
                            result.setPerson(new Person(
                                    new Person.PersonBuilder(Float.parseFloat(properties[8]),
                                            Color.valueOf(properties[9]),
                                            Color.valueOf(properties[10]),
                                            Country.valueOf(properties[11]))));
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        workersVector.add(result);
                    }
                    HashSet<Long> idSet = new HashSet<>();
                    workersVector.removeIf(worker -> !idSet.add(worker.getId()));
                    Collections.sort(workersVector);
                    return workersVector;
                } else {
                    throw new InvalidInputException();
                }
            } catch (FileNotFoundException exception) {
                TerminalOutputManager.printError("Файл не найден или доступ запрещен.\nРабота программы завершена");
                System.exit(1);
            } catch (InvalidInputException e) {
                TerminalOutputManager.printError("Использован неверный файл для загрузки данных коллекции");
            } catch (NoSuchElementException exception) {
                TerminalOutputManager.printError("Файл пуст.\nРабота программы завершена");
                System.exit(1);
            } catch (NullPointerException exception) {
                TerminalOutputManager.printError("Неверный формат коллекции в файле.\nРабота программы завершена");
                System.exit(1);
            } catch (IllegalStateException exception) {
                TerminalOutputManager.printError("Непредвиденная ошибка.\nРабота программы завершена");
                System.exit(1);
            }
        }
        return new Vector<>();
    }
}