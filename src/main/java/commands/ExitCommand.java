package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.TerminalManager;

/**
 * Команда, завершающая работу программы без сохранения данных в файл.
 *
 * <p> Эта команда не принимает аргументов. После её выполнения программа завершает свою работу. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class ExitCommand extends AbstractCommand {

    /**
     * Конструктор для создания команды "exit".
     * Устанавливает имя команды и её описание.
     */
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    /**
     * Выполняет команду "exit".
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
            TerminalManager.printLn("Работа с коллекцией завершена.");
            System.exit(0);
            return true;
        } catch (IncorrectAmountOfArgumentsException e) {
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
