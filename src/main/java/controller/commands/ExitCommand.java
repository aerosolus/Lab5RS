package controller.commands;

import client.Main;
import controller.CommandInterface;

import static client.Main.outputManager;

/**
 * Команда, завершающая работу программы без сохранения данных в файл.
 *
 * <p> Эта команда не принимает аргументов. После её выполнения программа завершает свою работу. </p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.0
 */
public class ExitCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "завершить программу (без сохранения в файл)";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "exit ";
    }
    /**
     * Executes the exit operation, terminating the program immediately.
     */
    @Override
    public void execute() {
        outputManager.printLn("Работа программы завершена.");
        System.exit(0);
    }
}
