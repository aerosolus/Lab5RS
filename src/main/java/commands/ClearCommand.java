package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.CollectionManager;
import utility.TerminalManager;

/**
 * Команда, очищающая коллекцию.
 *
 * <p> Эта команда не принимает аргументов и удаляет все элементы из коллекции, очищая ее. </p>
 */
public class ClearCommand extends AbstractCommand {

    /**
     * Менеджер, ответственный за обработку операций с коллекцией.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания команды "clear".
     * Устанавливает имя команды и её описание.
     *
     * @param collectionManager менеджер коллекции, который предоставляет доступ к данным коллекции.
     */
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду "clear".
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
            collectionManager.clearCollection();
            TerminalManager.printLn("Коллекция очищена.");
            return true;
        } catch (IncorrectAmountOfArgumentsException e){
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
