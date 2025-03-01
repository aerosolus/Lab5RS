package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, очищающая коллекцию.
 *
 * <p> Эта команда не принимает аргументов и удаляет все элементы из коллекции, очищая ее. </p>
 *
 * @author Aerosolus
 * @version 1.2
 * @since 2.0
 */
public class ClearCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "очистить коллекцию";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "clear ";
    }

    /**
     * Executes the clear operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.clearCollection();
    }
}
