package utility;

import data.Worker;
import inputOutput.TerminalOutputManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

/**
 * @since 1.2
 */
public class CSVWriter {

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
                TerminalOutputManager.printLn("Коллекция сохранена в файл с путем " + filePath);
            } catch (IOException e) {
                TerminalOutputManager.printError("Файл не может быть открыт по некой причине.");
            }
        } else TerminalOutputManager.printError("Файл поврежден или содержит ошибку в названии.");
    }
}
