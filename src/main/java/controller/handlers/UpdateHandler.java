package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.UpdateCommand;
import data.Worker;
import exceptions.IncorrectArgumentException;
import managers.ServerEntryPoint;

import static client.Main.*;

/**
 * Обработчик для команды, которая обновляет элемент коллекции по его уникальному идентификатору (id).
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды
 * {@link UpdateCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class UpdateHandler implements HandlerInterface {

    /**
     * Уникальный идентификатор (id) элемента, который должен быть обновлен в коллекции.
     */
    private Long id;

    /**
     * Объект {@link Worker}, который будет использоваться для обновления элемента коллекции.
     * Создается либо через интерактивный ввод, либо через чтение из скрипта.
     */
    private Worker worker;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды, которая обновляет элемент коллекции по его id.
     * Если скриптовый режим не активен, объект {@link Worker} создается через интерактивный ввод.
     * В противном случае объект считывается из скрипта. Если элемент с указанным id отсутствует
     * в коллекции, выводится соответствующее сообщение.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (!script) {
            if (args != "") {
                try {
                    this.id = Long.parseLong(args);
                } catch (NumberFormatException e) {
                    throw new IncorrectArgumentException();
                }
                if (ServerEntryPoint.collectionManager.containsId(id)) {
                    this.worker = terminalManager.createWorker();
                    this.worker.setId(id);
                    createCommand();
                } else {
                    outputManager.printLn("В коллекции отсутствует элемент с указанным значением поля id!");
                }
            } else {
                throw new IncorrectArgumentException();
            }
        } else {
            try {
                this.id = Long.parseLong(args);
            } catch (NumberFormatException e) {
                throw new IncorrectArgumentException();
            }
            if (ServerEntryPoint.collectionManager.containsId(id)) {
                this.worker = terminalManager.readWorker();
                this.worker.setId(id);
                createCommand();
            } else {
                outputManager.printLn("В коллекции отсутствует элемент с указанным значением поля id!");
            }
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
     * Создает команду {@link UpdateCommand} с указанным id и объектом {@link Worker} и присваивает
     * ее полю {@code command}.
     */
    @Override
    public void createCommand() {
        this.command = new UpdateCommand(id, worker);
    }
}
