package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая очищает коллекцию, удаляя все ее элементы.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции очистки коллекции.
 *
 * <p>Эта команда не принимает аргументов и полностью очищает коллекцию, управляемую
 * {@link ServerEntryPoint#collectionManager}.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class ClearCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "очистить коллекцию";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "clear ";
    }

    /**
     * Выполняет операцию очистки коллекции, управляемой {@link ServerEntryPoint#collectionManager}.
     * Все элементы коллекции удаляются.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.clearCollection();
    }
}
