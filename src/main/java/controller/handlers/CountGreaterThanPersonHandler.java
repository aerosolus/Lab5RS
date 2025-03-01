package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.CountGreaterThanPersonCommand;
import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.NotNullException;

import static client.Main.*;

/**
 * Обработчик для команды подсчета количества элементов коллекции, значение поля {@link Person} которых больше заданного.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link CountGreaterThanPersonCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class CountGreaterThanPersonHandler implements HandlerInterface {

    /**
     * Объект {@link Person}, используемый для сравнения с элементами коллекции.
     */
    private Person lowPerson;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды подсчета элементов коллекции, значение поля {@link Person} которых больше заданного.
     * В зависимости от режима работы (скрипт или интерактивный) создает объект {@link Person}.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (!script) {
            if (args == "") {
                try {
                    this.lowPerson = terminalManager.createPerson();
                    if (lowPerson == null) throw new NotNullException();
                } catch (Exception e) {
                    throw new IncorrectArgumentException();
                }
                createCommand();
            } else {
                throw new IncorrectArgumentException();
            }
        } else {
            this.lowPerson = terminalManager.readPerson();
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
     * Создает команду {@link CountGreaterThanPersonCommand} на основе объекта {@link Person}.
     */
    @Override
    public void createCommand() {
        this.command = new CountGreaterThanPersonCommand(lowPerson);
    }
}
