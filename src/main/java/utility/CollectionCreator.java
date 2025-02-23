package utility;

import java.io.IOException;
import java.util.Vector;

/**
 * @since 1.2
 */
public final class CollectionCreator {

    private CollectionCreator() {
    }

    public static CollectionManager load(String filePath) {
        CSVReader csvReader = new CSVReader();
        CollectionManager collectionManager;
        if (filePath == null) {
            filePath = "data.csv"; //works on any PC
            System.out.println("Не удалось получить имя файла для загрузки коллекции.");
            System.out.println("Загружена коллекция из файла по умолчанию.");
        }
        try {
            collectionManager = new CollectionManager(csvReader.readCollectionFromFile(filePath), filePath);
        } catch (NullPointerException | IOException e) {
            System.out.println("Файл по некой причине не был прочитан. Создана пустая коллекция.");
            collectionManager = new CollectionManager(new Vector<>(), filePath);
        }
        collectionManager.setFilePath(filePath);
        return collectionManager;
    }

}
