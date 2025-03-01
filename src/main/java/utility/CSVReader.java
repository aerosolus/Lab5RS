package utility;

import data.*;
import exceptions.InvalidInputException;
import managers.OutputManager;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utility.CSVWriter.FILE_HEADER;

/**
 * Класс, предназначенный для чтения коллекции объектов {@link Worker} из CSV-файла.
 * В коллекцию добавляются только те объекты, у которых все поля имеют корректные значения.
 * Если данные в файле некорректны, объект пропускается и не добавляется в коллекцию.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.2
 */
public class CSVReader {

    /**
     * Читает коллекцию объектов {@link Worker} из CSV-файла.
     * Проверяет на корректность значение каждого поля объекта перед добавлением в коллекцию.
     * Если файл не найден, пуст или содержит некорректные данные, программа завершается с соответствующим сообщением об ошибке.
     *
     * @param fileName Путь к CSV-файлу.
     * @return Коллекция объектов {@link Worker}, прошедших валидацию.
     * @throws IOException Если произошла ошибка ввода-вывода при чтении файла.
     */
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
                OutputManager.printError("Файл не найден или доступ запрещен");
                OutputManager.print("\nРабота программы завершена.");
                System.exit(1);
            } catch (InvalidInputException e) {
                OutputManager.printError("Использован неверный файл для загрузки данных коллекции");
                OutputManager.print("\nРабота программы завершена.");
                System.exit(1);
            } catch (NoSuchElementException exception) {
                OutputManager.printError("Файл пуст");
                OutputManager.print("\nРабота программы завершена");
                System.exit(1);
            } catch (NullPointerException exception) {
                OutputManager.printError("Неверный формат коллекции в файле");
                OutputManager.print("\nРабота программы завершена.");
                System.exit(1);
            } catch (IllegalStateException exception) {
                OutputManager.printError("Непредвиденная ошибка");
                OutputManager.print("\nРабота программы завершена.");
                System.exit(1);
            }
        }
        return new Vector<>();
    }
}