package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.RemoveLowerCommand;
import data.Worker;
import exceptions.IncorrectArgumentException;
import exceptions.NotNullException;

import static client.Main.script;
import static client.Main.terminalManager;

/**
 * Обработчик для команды, которая удаляет из коллекции все элементы, меньшие, чем заданный объект {@link Worker}.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды
 * {@link RemoveLowerCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class RemoveLowerHandler implements HandlerInterface {

    /**
     * Объект {@link Worker}, используемый для сравнения с элементами коллекции.
     */
    private Worker worker;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды, которая удаляет из коллекции все элементы,
     * меньшие, чем заданный объект {@link Worker}.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     * @throws NotNullException Если элемент с указанным id не найден в коллекции.
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
     * Создает команду {@link RemoveLowerCommand} с текущим объектом {@link Worker} и присваивает
     * ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new RemoveLowerCommand(worker);
    }
}
