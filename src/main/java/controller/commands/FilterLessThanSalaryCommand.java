package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * @since 2.0
 */
public class FilterLessThanSalaryCommand implements CommandInterface {

    private long maxSalary;

    public FilterLessThanSalaryCommand(long argument){
        this.maxSalary = argument;
    }

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести элементы, значение поля salary которых меньше заданного";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "filter_less_than_salary ";
    }


    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.filterLessThanSalary(maxSalary);
    }
}
