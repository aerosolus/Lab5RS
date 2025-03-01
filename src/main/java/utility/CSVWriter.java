package utility;

import data.Worker;
import managers.OutputManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 * Класс, предназначенный для записи коллекции объектов {@link Worker} в CSV-файл.
 * Каждая строка файла соответствует одному объекту {@link Worker}, а поля разделены символом табуляции.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.2
 */
public class CSVWriter {

    /**
     * Заголовок CSV-файла, содержащий названия полей.
     */
    static final String FILE_HEADER = "ID"
            + "\t" + "NAME"
            + "\t" + "X"
            + "\t" + "Y"
            + "\t" + "CREATION_DATE"
            + "\t" + "SALARY"
            + "\t" + "POSITION"
            + "\t" + "STATUS"
            + "\t" + "PERSON_HEIGHT"
            + "\t" + "PERSON_EYE_COLOR"
            + "\t" + "PERSON_HAIR_COLOR"
            + "\t" + "NATIONALITY" + "\n";

    /**
     * Записывает коллекцию объектов {@link Worker} в CSV-файл.
     * Если файл не может быть открыт или путь к файлу некорректен, выводится сообщение об ошибке.
     *
     * @param workersCollection Коллекция объектов {@link Worker} для записи.
     * @param filePath Путь к файлу, в который будет записана коллекция.
     * @throws IOException Если произошла ошибка ввода-вывода при записи в файл.
     */
    public void writeCollection(Vector<Worker> workersCollection, String filePath) throws IOException {
        if (!filePath.isEmpty()) {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            try {
                fileOutputStream.write(FILE_HEADER.getBytes());
                for (Worker worker : workersCollection) {
                    String line = worker.getId()
                            + "\t" + worker.getName()
                            + "\t" + worker.getCoordinates().getX()
                            + "\t" + worker.getCoordinates().getY()
                            + "\t" + worker.getCreationDate()
                            + "\t" + worker.getSalary()
                            + "\t" + worker.getPosition()
                            + "\t" + worker.getStatus()
                            + "\t" + worker.getPerson().getHeight()
                            + "\t" + worker.getPerson().getEyeColor()
                            + "\t" + worker.getPerson().getHairColor()
                            + "\t" + worker.getPerson().getNationality() + "\n";
                    fileOutputStream.write(line.getBytes());
                }
                fileOutputStream.close();
                System.out.println("Коллекция сохранена в файл с путем " + filePath);
            } catch (IOException e) {
                OutputManager.printError("Файл не может быть открыт по некой причине.");
            }
        } else OutputManager.printError("Файл поврежден или содержит ошибку в названии.");
    }
}
