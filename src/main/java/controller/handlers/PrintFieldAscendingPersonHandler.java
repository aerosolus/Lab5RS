package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.PrintFieldAscendingPersonCommand;
import data.Person;
import exceptions.IncorrectArgumentException;

/**
 * Обработчик для команды, которая выводит значения поля {@link Person} элементов коллекции в порядке возрастания.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды
 * {@link PrintFieldAscendingPersonCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class PrintFieldAscendingPersonHandler implements HandlerInterface {

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды, которая выводит значения поля {@link Person} элементов коллекции
     * в порядке возрастания.
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
     * Создает команду {@link PrintFieldAscendingPersonCommand} и присваивает ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new PrintFieldAscendingPersonCommand();
    }
}
