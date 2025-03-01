package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class AddCommand implements CommandInterface {

    private Worker worker;

    public AddCommand(Worker worker) {
        this.worker = worker;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "добавить новый элемент в коллекцию";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "add ";
    }

    /**
     * Executes the save operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.addToCollection(worker);
    }
}
