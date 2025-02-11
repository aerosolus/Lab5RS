package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.CollectionManager;
import utility.TerminalManager;

/**
 * Команда, реализующая вывод информации о коллекции в стандартный поток вывода.
 *
 * <p> Эта команда не принимает аргументов и предоставляет общую информацию о состоянии коллекции. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class InfoCommand extends AbstractCommand {

    /**
     * Менеджер, ответственный за обработку операций с коллекцией.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания команды "info".
     * Устанавливает имя команды и её описание.
     *
     * @param collectionManager менеджер коллекции, который реализует доступ к ней.
     */
    public InfoCommand(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду "info".
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
            TerminalManager.printLn(collectionManager.collectionInfo());
            return true;
        } catch (IncorrectAmountOfArgumentsException e) {
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
