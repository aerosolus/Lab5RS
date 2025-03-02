package controller.commands;

import client.Main;
import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая выводит информацию о коллекции в стандартный поток вывода.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции вывода информации о коллекции.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения в стандартный поток вывода
 * выводится общая информация о состоянии коллекции, такая как тип коллекции, количество элементов
 * и дата инициализации.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class InfoCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести в стандартный поток вывода информацию о коллекции";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "info ";
    }

    /**
     * Выполняет команду "info". Выводит информацию о коллекции, такую как тип коллекции,
     * количество элементов и дата инициализации, в стандартный поток вывода.
     */
    @Override
    public void execute() {
        Main.outputManager.printLn(ServerEntryPoint.collectionManager.collectionInfo());
    }
}
