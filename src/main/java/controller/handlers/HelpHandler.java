package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.HelpCommand;
import exceptions.IncorrectArgumentException;

/**
 * Обработчик для команды, которая дает справку по доступным при работе с коллекцией командам.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link HelpCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class HelpHandler implements HandlerInterface {

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды, которая дает справку по доступным при работе с коллекцией командам.
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
     * Создает команду {@link HelpCommand} и присваивает ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new HelpCommand();
    }
}
