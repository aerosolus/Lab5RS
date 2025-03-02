package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * Команда, которая удаляет из коллекции все элементы, меньшие, чем заданный объект {@link Worker}.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции удаления элементов.
 *
 * <p>Эта команда принимает объект {@link Worker} в качестве аргумента и удаляет из коллекции
 * все элементы, которые меньше заданного объекта. Сравнение элементов выполняется на основе
 * их естественного порядка или определенного компаратора.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class RemoveLowerCommand implements CommandInterface {

    /**
     * Объект {@link Worker}, используемый для сравнения с элементами коллекции.
     */
    private Worker worker;

    /**
     * Конструктор, который инициализирует команду с указанным объектом {@link Worker}.
     *
     * @param worker Объект {@link Worker}, который будет использоваться для сравнения.
     */
    public RemoveLowerCommand(Worker worker) {
        this.worker = worker;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "удалить из коллекции все элементы, меньшие, чем заданный";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "remove_lower ";
    }

    /**
     * Выполняет команду "remove_lower". Удаляет из коллекции все элементы, которые меньше
     * заданного объекта {@link Worker}. Управление коллекцией осуществляется через
     * {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.removeLower(worker);
    }
}
