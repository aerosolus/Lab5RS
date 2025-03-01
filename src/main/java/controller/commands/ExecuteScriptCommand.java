package controller.commands;

import client.Main;
import controller.CommandInterface;

/**
 * Команда, выполняющая скрипт из указанного файла.
 *
 * <p> Эта команда принимает в качестве аргумента имя файла скрипта, который необходимо выполнить.
 * Скрипт содержит последовательность команд, которые будут выполнены в порядке их записи. </p>
 *
 * @author Aerosolus
 * @version 1.2
 * @since 2.0
 */
public class ExecuteScriptCommand implements CommandInterface {

    /**
     * The path to the script file to be executed.
     */
    private String filepath;

    /**
     * Constructs an ExecuteScriptCommand instance with the specified path to the script file.
     *
     * @param filepath The path to the script file.
     */
    public ExecuteScriptCommand(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "считать и исполнить скрипт из указанного файла";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "execute_script ";
    }

    /**
     * Executes the script file specified in the constructor.
     */
    @Override
    public void execute() {
        Main.inputManager.readScript(filepath);
    }
}
