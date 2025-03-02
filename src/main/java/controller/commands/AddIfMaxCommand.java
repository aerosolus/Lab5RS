package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * Команда, которая добавляет новый элемент в коллекцию, если его значение превышает значение
 * наибольшего элемента в коллекции.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции условного добавления.
 *
 * <p>Этот класс принимает объект {@link Worker} и добавляет его в коллекцию, управляемую
 * {@link ServerEntryPoint#collectionManager}, только если значение нового элемента превышает
 * значение наибольшего элемента в коллекции.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class AddIfMaxCommand implements CommandInterface {

    /**
     * Объект {@link Worker}, который будет добавлен в коллекцию, если его значение
     * превышает значение наибольшего элемента в коллекции.
     */
    private Worker worker;

    /**
     * Конструктор, который инициализирует команду с указанным объектом {@link Worker}.
     *
     * @param worker Объект {@link Worker}, который будет добавлен в коллекцию, если его значение
     *              превышает значение наибольшего элемента в коллекции.
     */
    public AddIfMaxCommand(Worker worker) {
        this.worker = worker;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "add_if_max ";
    }

    /**
     * Выполняет операцию условного добавления элемента в коллекцию, управляемую
     * {@link ServerEntryPoint#collectionManager}. Элемент добавляется только в том случае,
     * если его значение превышает значение наибольшего элемента в коллекции.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.addIfMax(worker);
    }
}
