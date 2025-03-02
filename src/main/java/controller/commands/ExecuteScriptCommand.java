package controller.commands;

import client.Main;
import controller.CommandInterface;

/**
 * Команда, которая выполняет скрипт из указанного файла.
 * Реализует интерфейс {@link CommandInterface} для выполнения скрипта, содержащего последовательность команд.
 *
 * <p>Эта команда принимает путь к файлу скрипта в качестве аргумента и выполняет команды,
 * записанные в этом файле, в порядке их следования.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class ExecuteScriptCommand implements CommandInterface {

    /**
     * Путь к файлу скрипта, который должен быть выполнен.
     */
    private String filepath;

    /**
     * Конструктор, который инициализирует команду с указанным путем к файлу скрипта.
     *
     * @param filepath Путь к файлу скрипта.
     */
    public ExecuteScriptCommand(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "считать и исполнить скрипт из указанного файла";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "execute_script ";
    }

    /**
     * Выполняет скрипт, указанный в поле {@code filepath}, с помощью {@link Main#inputManager}.
     * Команды из файла выполняются последовательно.
     */
    @Override
    public void execute() {
        Main.inputManager.readScript(filepath);
    }
}
