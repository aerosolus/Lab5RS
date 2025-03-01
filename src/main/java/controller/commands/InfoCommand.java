package controller.commands;

import client.Main;
import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, реализующая вывод информации о коллекции в стандартный поток вывода.
 *
 * <p> Эта команда не принимает аргументов и предоставляет общую информацию о состоянии коллекции. </p>
 *
 * @author Aerosolus
 * @version 1.2
 * @since 2.0
 */
public class InfoCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода информацию о коллекции";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "info ";
    }

    /**
     * Executes the info operation, displaying information about the collection.
     */
    @Override
    public void execute() {
        Main.outputManager.printLn(ServerEntryPoint.collectionManager.collectionInfo());
    }
}
