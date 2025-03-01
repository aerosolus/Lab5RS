package controller.commands;

import controller.CommandInterface;
import data.Person;
import managers.ServerEntryPoint;

/**
 * @since 2.0
 */
public class CountGreaterThanPersonCommand implements CommandInterface {

    private Person lowPerson;

    public CountGreaterThanPersonCommand(Person argument){
        this.lowPerson = argument;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести количество элементов, значение поля person которых больше заданного";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "count_greater_than_person ";
    }


    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.countGreaterThanPerson(lowPerson);
    }
}
