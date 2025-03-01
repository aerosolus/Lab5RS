package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * @since 2.0
 */
public class PrintFieldAscendingPersonCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести значения поля person всех элементов в порядке возрастания";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "print_field_ascending_person ";
    }

    /**
     * Executes the print descending car operation, displaying the values of the 'car' field for all elements in descending order.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.printFieldAscendingPerson();
    }
}
