package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * Команда, которая добавляет новый элемент в коллекцию.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции добавления.
 *
 * <p>Этот класс принимает объект {@link Worker} и добавляет его в коллекцию, управляемую
 * {@link ServerEntryPoint#collectionManager}.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class AddCommand implements CommandInterface {

    /**
     * Объект {@link Worker}, который будет добавлен в коллекцию.
     */
    private Worker worker;

    /**
     * Конструктор, который инициализирует команду с указанным объектом {@link Worker}.
     *
     * @param worker Объект {@link Worker}, который будет добавлен в коллекцию.
     */
    public AddCommand(Worker worker) {
        this.worker = worker;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "добавить новый элемент в коллекцию";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "add ";
    }

    /**
     * Выполняет операцию добавления элемента в коллекцию, управляемую {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.addToCollection(worker);
    }
}
