package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.TerminalManager;

/**
 * Команда, выполняющая скрипт из указанного файла.
 *
 * <p> Эта команда принимает в качестве аргумента имя файла скрипта, который необходимо выполнить.
 * Скрипт содержит последовательность команд, которые будут выполнены в порядке их записи. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class ExecuteScriptCommand extends AbstractCommand {

    /**
     * Конструктор для создания команды "execute_script".
     * Устанавливает имя команды и её описание.
     */
    public ExecuteScriptCommand() {
        super("execute_script", "считать и исполнить скрипт из указанного файла");
    }

    /**
     * Выполняет команду "execute_script".
     * Команда принимает один аргумент — путь к файлу скрипта. Если аргумент отсутствует,
     * выбрасывается исключение {@link IncorrectAmountOfArgumentsException}.
     *
     * @param argument путь к файлу скрипта, который необходимо выполнить.
     * @return {@code true}, если команда выполнена успешно, {@code false} в случае ошибки.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new IncorrectAmountOfArgumentsException();
            TerminalManager.printLn("Выполняется переданный файл скрипта '" + argument + "'");
            TerminalManager.readScript(argument);
            return true;
        } catch (IncorrectAmountOfArgumentsException e) {
            TerminalManager.printError("Отсутствуют аргументы для исполнения команды '" + getName() + "'");
        }
        return false;
    }
}
