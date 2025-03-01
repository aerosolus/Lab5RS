package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, сохраняющая текущее состояние коллекции в файл.
 *
 * <p> Эта команда не принимает аргументов и записывает данные коллекции в файл,
 * используя предоставленный {@link utility.CSVWriter}. </p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class SaveCommand implements CommandInterface {

    /**
     * Returns a description of the command, combining the command name with its action.
     *
     * @return A string describing the purpose of the command.
     */
    @Override
    public String getDescription() {
        return getName() + "сохранить коллекцию в файл";
    }

    /**
     * Returns the name of the command.
     *
     * @return A string representing the name of the command.
     */
    @Override
    public String getName() {
        return "save ";
    }

    /**
     * Executes the save operation on the collection managed by ServerEntryPoint.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.save();
    }
}
