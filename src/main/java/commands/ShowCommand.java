package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.CollectionManager;
import utility.TerminalManager;

/**
 * Команда, выводящая все элементы коллекции в строковом представлении.
 *
 * <p> Эта команда не принимает аргументов и выводит информацию о каждом элементе коллекции
 * в стандартный поток вывода. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class ShowCommand extends AbstractCommand {

    /**
     * Менеджер, ответственный за обработку операций с коллекцией.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор для создания команды "show".
     * Устанавливает имя команды и её описание.
     *
     * @param collectionManager менеджер коллекции, который реализует доступ к ней.
     */
    public ShowCommand(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду "show".
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
            collectionManager.showCollection();
            return true;
        } catch (IncorrectAmountOfArgumentsException e) {
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
