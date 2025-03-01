package managers;

import controller.HandlerInterface;
import utility.CollectionCreator;
import utility.CollectionManager;

/**
 * Класс, представляющий точку входа для серверных операций.
 * Инициализирует и управляет коллекцией данных, а также выполняет команды через обработчики.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class ServerEntryPoint {

    /**
     * Единственный экземпляр {@link CollectionManager}, отвечающий за управление коллекцией.
     */
    public static CollectionManager collectionManager;

    /**
     * Путь к файлу, используемому для загрузки и сохранения коллекции.
     */
    public String filePath;

    /**
     * Конструктор по умолчанию для {@link ServerEntryPoint}.
     * Инициализирует {@link CollectionManager}, загружая данные из указанного файла.
     *
     * @param filePath Путь к файлу, из которого загружается коллекция.
     */
    public ServerEntryPoint(String filePath) {
        this.filePath = filePath;
        collectionManager = CollectionCreator.load(filePath);
    }

    /**
     * Выполняет команду через переданный обработчик.
     *
     * @param handler Обработчик, отвечающий за выполнение команды.
     */
    public void accomplishCommand(HandlerInterface handler){
        handler.getCommand().execute();
    }
}
