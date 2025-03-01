package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.RemoveByIdCommand;
import exceptions.IncorrectArgumentException;
import exceptions.NotNullException;
import managers.ServerEntryPoint;

import static client.Main.outputManager;

/**
 * Обработчик для команды, которая удаляет элемент из коллекции по его уникальному идентификатору (id).
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды
 * {@link RemoveByIdCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class RemoveByIdHandler implements HandlerInterface {

    /**
     * Уникальный идентификатор (id) элемента, который должен быть удален из коллекции.
     */
    private Long id;

    /**
     * Команда, созданная обработчиком
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды, которая удаляет элемент из коллекции по его id.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     * @throws NotNullException Если элемент с указанным id не найден в коллекции.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (args != ""){
            try {
                id = Long.parseLong(args);
                if(ServerEntryPoint.collectionManager.getById(id) == null) throw new NotNullException();
                outputManager.printLn("Элемент с указанным id был удален из коллекции.");
                } catch (Exception e) {
                    throw new IncorrectArgumentException();
                }
                createCommand();
        } else {
            throw new IncorrectArgumentException();
        }
    }

    /**
     * Возвращает команду, созданную обработчиком.
     *
     * @return Команда {@link CommandInterface}.
     */
    @Override
    public CommandInterface getCommand() {
        return command;
    }

    /**
     * Создает команду {@link RemoveByIdCommand} и присваивает ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new RemoveByIdCommand(id);
    }
}
