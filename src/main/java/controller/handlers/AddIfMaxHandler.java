package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.AddIfMaxCommand;
import data.Worker;
import exceptions.IncorrectArgumentException;
import exceptions.NotNullException;

import static client.Main.script;
import static client.Main.terminalManager;

/**
 * Обработчик для команды добавления нового элемента в коллекцию, если его значение превышает максимальное значение в коллекции.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link AddIfMaxCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class AddIfMaxHandler implements HandlerInterface {

    /**
     * Объект {@link Worker}, который будет добавлен в коллекцию, если его значение превышает максимальное значение в коллекции.
     */
    private Worker worker;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды добавления элемента, если его значение превышает максимальное значение в коллекции.
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
                } catch (Exception e) {
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
     * Создает команду {@link AddIfMaxCommand} на основе объекта {@link Worker}.
     */
    @Override
    public void createCommand() {
        this.command = new AddIfMaxCommand(worker);
    }
}
