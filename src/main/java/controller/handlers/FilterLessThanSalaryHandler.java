package controller.handlers;

import controller.CommandInterface;
import controller.HandlerInterface;
import controller.commands.FilterLessThanSalaryCommand;
import exceptions.IncorrectArgumentException;

/**
 * Обработчик для команды фильтрации элементов коллекции, значение поля salary которых меньше заданного.
 * Реализует интерфейс {@link HandlerInterface} для обработки аргументов и создания команды {@link FilterLessThanSalaryCommand}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class FilterLessThanSalaryHandler implements HandlerInterface {

    /**
     * Максимальное значение зарплаты, используемое для фильтрации элементов коллекции.
     */
    private long maxSalary;

    /**
     * Команда, созданная обработчиком.
     */
    private CommandInterface command;

    /**
     * Обрабатывает входные аргументы для команды фильтрации элементов коллекции, значение поля salary которых меньше заданного.
     *
     * @param args Входные аргументы, предоставленные пользователем.
     * @throws IncorrectArgumentException Если аргументы некорректны или не могут быть преобразованы в число.
     */
    @Override
    public void handle(String args) throws IncorrectArgumentException {
        if (args != "") {
            try {
                this.maxSalary = Long.parseLong(args);
            } catch (NumberFormatException e) {
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
     * Создает команду {@link FilterLessThanSalaryCommand} на основе значения {@code maxSalary}.
     */
    @Override
    public void createCommand() {
        this.command = new FilterLessThanSalaryCommand(maxSalary);
    }
}
