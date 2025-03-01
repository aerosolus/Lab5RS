package utility;

import java.io.IOException;
import java.util.Vector;

/**
 * Класс, предназначенный для создания и загрузки коллекции {@link CollectionManager} из файла.
 * Использует {@link CSVReader} для чтения данных из CSV-файла и инициализации коллекции.
 * Если файл не может быть прочитан, создается пустая коллекция с использованием стандартного пути к файлу.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.2
 */
public final class CollectionCreator {

    /**
     * Приватный конструктор, предотвращающий создание экземпляров класса.
     */
    private CollectionCreator() {
    }

    /**
     * Загружает коллекцию из указанного файла и создает объект {@link CollectionManager}.
     * Если файл не может быть прочитан, создается пустая коллекция с использованием стандартного пути к файлу.
     *
     * @param filePath Путь к файлу, из которого будет загружена коллекция.
     * @return Объект {@link CollectionManager}, содержащий загруженную или пустую коллекцию.
     */
    public static CollectionManager load(String filePath) {
        CSVReader csvReader = new CSVReader();
        CollectionManager collectionManager;
        try {
            collectionManager = new CollectionManager(csvReader.readCollectionFromFile(filePath), filePath);
        } catch (NullPointerException | IOException e) {
            System.out.println("Файл по некой причине не был прочитан. Создана пустая коллекция, использован стандартный путь к файлу");
            filePath = "data.csv";
            collectionManager = new CollectionManager(new Vector<>(), filePath);
        }
        collectionManager.setFilePath(filePath);
        return collectionManager;
    }

}
