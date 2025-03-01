package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.ClearCommand;
import exceptions.IncorrectArgumentException;

/**
 * Обработчик для команды очистки коллекции.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link ClearCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class ClearHandler implements HandlerInterface {

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды очистки коллекции.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (args == "") {
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
     * Создает команду {@link ClearCommand} и присваивает ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new ClearCommand();
    }
}
