package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * @author Aerosolus
 * @version 1.2
 * @since 2.0
 */
public class ShowCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "show ";
    }

    /**
     * Executes the show operation, displaying all elements of the collection in string representation.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.showCollection();
    }
}
