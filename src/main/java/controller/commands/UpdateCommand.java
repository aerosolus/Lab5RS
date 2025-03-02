package controller.commands;

import controller.CommandInterface;
import data.Worker;
import managers.ServerEntryPoint;

/**
 * Команда, которая обновляет значение элемента коллекции по его уникальному идентификатору (id).
 * Реализует интерфейс {@link CommandInterface} для выполнения операции обновления элемента.
 *
 * <p>Эта команда принимает два аргумента: идентификатор элемента, который необходимо обновить,
 * и объект {@link Worker}, содержащий новые данные для обновления. Если элемент с указанным
 * идентификатором существует в коллекции, его данные будут заменены на новые.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class UpdateCommand implements CommandInterface {

    /**
     * Уникальный идентификатор (id) элемента, который должен быть обновлен.
     */
    private Long id;

    /**
     * Объект {@link Worker}, содержащий новые данные для обновления элемента коллекции.
     */
    private Worker worker;

    /**
     * Конструктор, который инициализирует команду с указанным идентификатором и объектом {@link Worker}.
     *
     * @param argument Идентификатор элемента, который необходимо обновить.
     * @param worker   Объект {@link Worker}, содержащий новые данные для обновления.
     */
    public UpdateCommand(Long argument, Worker worker) {
        this.id = argument;
        this.worker = worker;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "обновить значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "update ";
    }

    /**
     * Выполняет команду "update". Обновляет элемент коллекции с указанным идентификатором,
     * заменяя его данные на новые, предоставленные объектом {@link Worker}. Управление коллекцией
     * осуществляется через {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.update(id, worker);
    }
}
