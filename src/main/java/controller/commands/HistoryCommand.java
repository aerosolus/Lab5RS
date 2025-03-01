package controller.commands;

import client.Main;
import controller.CommandInterface;

/**
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class HistoryCommand implements CommandInterface {

    @Override
    public String getDescription() {
        return getName() + "вывести последние 5 команд (без их аргументов)";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "history ";
    }

    /**
     * Executes the save operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        Main.terminalManager.printHistory();
    }
}
