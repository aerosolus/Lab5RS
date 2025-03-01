package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.ExecuteScriptCommand;
import exceptions.IncorrectArgumentException;

/**
 * Обработчик для команды, которая выполняет скрипт из указанного файла.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды
 * {@link ExecuteScriptCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class ExecuteScriptHandler implements HandlerInterface {

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Путь к файлу скрипта, который должен быть выполнен.
     */
    private String filepath;

    /**
     * Обрабатывает входные аргументы для команды, которая выполняет скрипт из указанного файла.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (args != "") {
            filepath = args;
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
     * Создает команду {@link ExecuteScriptCommand} с указанным путем к файлу скрипта и присваивает
     * ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new ExecuteScriptCommand(filepath);
    }
}
