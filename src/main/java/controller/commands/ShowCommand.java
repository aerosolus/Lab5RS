package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая выводит все элементы коллекции в строковом представлении.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции вывода элементов коллекции.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения в стандартный поток вывода
 * выводятся все элементы коллекции в строковом представлении.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class ShowCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "show ";
    }

    /**
     * Выполняет команду "show". Выводит все элементы коллекции в строковом представлении
     * в стандартный поток вывода. Управление коллекцией осуществляется через
     * {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.showCollection();
    }
}
