package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.CollectionManager;
import utility.FileManager;
import utility.TerminalManager;

/**
 * Команда, сохраняющая текущее состояние коллекции в файл.
 *
 * <p> Эта команда не принимает аргументов и записывает данные коллекции в файл,
 * используя предоставленный {@link FileManager}. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class SaveCommand extends AbstractCommand {

    /**
     * Менеджер, используемый для записи коллекции в файл.
     */
    private final FileManager fileManager;

    /**
     * Менеджер, ответственный за обработку операций с коллекцией.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания команды "save".
     * Устанавливает имя команды и её описание.
     *
     * @param fileManager менеджер файлов, который реализует запись коллекции в файл.
     * @param collectionManager менеджер коллекции, который предоставляет доступ к ее данным.
     */
    public SaveCommand(FileManager fileManager, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду "save".
     * Команда не принимает аргументов. Если аргумент передан, выбрасывается исключение
     * {@link IncorrectAmountOfArgumentsException}.
     *
     * @param argument аргумент команды (должен быть пустым).
     * @return {@code true}, если команда выполнена успешно, {@code false} в случае ошибки.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IncorrectAmountOfArgumentsException();
            fileManager.writeCollection(collectionManager.getCollection());
            return true;
        } catch (IncorrectAmountOfArgumentsException e){
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
