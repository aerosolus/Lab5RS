package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class UpdateCommand implements CommandInterface {

    private Long id;

    private Worker worker;

    public UpdateCommand(Long argument, Worker worker) {
        this.id = argument;
        this.worker = worker;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "update ";
    }

    /**
     * Executes the save operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.update(id, worker);
    }
}
