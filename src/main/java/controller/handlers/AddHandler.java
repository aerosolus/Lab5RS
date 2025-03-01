package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.AddCommand;
import data.Worker;
import exceptions.IncorrectArgumentException;
import exceptions.NotNullException;

import static client.Main.*;
import static client.Main.terminalManager;

/**
 * Обработчик для команды добавления нового элемента в коллекцию.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link AddCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class AddHandler implements HandlerInterface {

    /**
     * Объект {@link Worker}, который будет добавлен в коллекцию.
     */
    private Worker worker;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды добавления элемента.
     * В зависимости от режима работы (скрипт или интерактивный) создает объект {@link Worker}.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (!script) {
            if (args == "") {
                try {
                    this.worker = terminalManager.createWorker();
                    if (worker == null) throw new NotNullException();
                } catch (NotNullException e) {
                    throw new IncorrectArgumentException();
                }
                createCommand();
            } else {
                throw new IncorrectArgumentException();
            }
        } else {
            this.worker = terminalManager.readWorker();
            createCommand();
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
     * Создает команду {@link AddCommand} на основе объекта {@link Worker}.
     */
    @Override
    public void createCommand() {
        this.command = new AddCommand(worker);
    }
}
