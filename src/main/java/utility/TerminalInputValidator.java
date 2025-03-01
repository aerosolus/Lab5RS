package utility;

/**
 * Класс для валидации и хранения ввода из терминала.
 * Инкапсулирует имя команды и аргументы, полученные через терминал.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.3
 */
public class TerminalInputValidator {

    /**
     * Имя команды, введенной через терминал.
     */
    private String commandName;

    /**
     * Аргументы, переданные вместе с командой.
     */
    private String commandArguments;

    /**
     * Конструктор, инициализирующий объект с указанным именем команды и аргументами.
     *
     * @param commandName Имя команды, введенной через терминал.
     * @param commandArguments Аргументы, переданные вместе с командой.
     */
    public TerminalInputValidator(String commandName, String commandArguments) {
        this.commandName = commandName;
        this.commandArguments = commandArguments;
    }

    /**
     * Возвращает имя команды, введенной через терминал.
     *
     * @return Имя команды.
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Возвращает аргументы, переданные вместе с командой.
     *
     * @return Аргументы команды.
     */
    public String getCommandArguments() {
        return commandArguments;
    }
}