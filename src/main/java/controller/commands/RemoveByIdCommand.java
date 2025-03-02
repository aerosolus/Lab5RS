package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая удаляет элемент из коллекции по его уникальному идентификатору (id).
 * Реализует интерфейс {@link CommandInterface} для выполнения операции удаления элемента.
 *
 * <p>Эта команда принимает один аргумент — идентификатор элемента, который необходимо удалить.
 * Если элемент с указанным идентификатором существует в коллекции, он будет удален.
 * В случае отсутствия аргумента или некорректного формата идентификатора, команда выводит сообщение об ошибке.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class RemoveByIdCommand implements CommandInterface {

    private Long id;

    public RemoveByIdCommand(Long argument){
        this.id = argument;
    }

    @Override
    public String getDescription() {
        return getName() + "удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id ";
    }

    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.removeFromCollectionById(id);
    }
}
