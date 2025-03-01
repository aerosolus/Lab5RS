package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

public class RemoveLowerCommand implements CommandInterface {

    private Worker worker;

    public RemoveLowerCommand(Worker worker) {
        this.worker = worker;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "удалить из коллекции все элементы, меньшие, чем заданный";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "remove_lower ";
    }

    /**
     * Executes the remove lower operation,
     * removing all elements from the collection that are lower than the given HumanBeing entity.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.removeLower(worker);
    }
}
